package com.hlsofttech.controller.erpapi;

import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.hlsofttech.annotation.AuthPower;
import com.hlsofttech.base.BaseController;
import com.hlsofttech.common.Constant;
import com.hlsofttech.entity.vo.OrderListForErpRequest;
import com.hlsofttech.entity.vo.SyncStockForErpRequest;
import com.hlsofttech.exception.CommonBizException;
import com.hlsofttech.exception.ExpCodeEnum;
import com.hlsofttech.rsp.Result;
import com.hlsofttech.service.product.DrugsCategoryService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description: 对接药店ERP系统API
 * @Date: 2019/8/2 15:08
 * @Author: suncy
 **/
@Slf4j
@RestController
@Api(tags = "ERP系统对接", value = "ERP系统对接", description = "ERP系统对接 @author suncy")
public class ERPApiController extends BaseController {
    private final Logger logger = LoggerFactory.getLogger(ERPApiController.class);

    @Reference(version = Constant.VERSION, group = "com.hlsofttech.product", timeout = Constant.TIMEOUT)
    public DrugsCategoryService iDrugsCategoryService;

    // 测试
    public static String app_secret = "7BB4DDA93C2972B9D9E447EE30E0A772";

    /***
     * @Description: 门店对照关系同步(根据统一信用代码)
     * @Date: 2019/8/5 9:23
     * @param param: 门店在ERP系统中的ID
     * @return: java.lang.String 门店在购药平台的ID
     * @Author: suncy
     **/
    @SuppressWarnings("rawtypes")
    @ApiOperation(value = "ERP系统对接-门店批量同步", notes = "ERP系统对接-门店批量同步", httpMethod = "POST")
    @PostMapping("/api/erpApi/shop/add")
    public Result shopAdd(@RequestBody String param) {

        log.info("ERP系统对接-门店批量同步:" + param);
        Result result = null;

        try {
            // 解析参数并进行验签处理，验签成功返回接收的参数
            boolean flag = ERPParamUtil.checkInfo(param, app_secret);
            if (flag) {
                JSONObject json = JSONObject.parseObject(param);
                JSONArray array = json.getJSONArray("data");

                Map<String, String> shopIdMap = new HashMap<>();
                for (int i = 0; i < array.size(); i++) {
                    JSONObject jo = array.getJSONObject(i);
                    String unifiedCreditCodeStr = jo.getString("unifiedCreditCode");

                    // TODO: 2019/8/5  根据统一信用代码查询门店在平台中的门店ID
                    String shopId = unifiedCreditCodeStr;
                    shopIdMap.put(unifiedCreditCodeStr, shopId);
                }
                result = new Result(true, "同步成功", shopIdMap);
            }
        } catch (Exception e) {
            e.printStackTrace();
            result = new Result(false, "同步失败");
        }
        return result;
    }


    /***
     * @Description: 药品信息同步
     * @Date: 2019/8/5 9:31
     * @param param: 国标码、条形码、
     * @return: java.lang.String
     * @Author: suncy
     **/
    @SuppressWarnings("rawtypes")
    @ApiOperation(value = "ERP系统对接-药品信息批量同步", notes = "ERP系统对接-药品信息批量同步", httpMethod = "POST")
    @PostMapping("/api/erpApi/drugs/add")
    public Result drugsAdd(@RequestBody String param) {
        log.info("ERP系统对接-药品信息批量同步:" + param);
        Result result = null;

        try {
            boolean flag = ERPParamUtil.checkInfo(param, app_secret);
            if (flag) {
                JSONObject json = JSONObject.parseObject(param);
                JSONArray array = json.getJSONArray("data");

                for (int i = 0; i < array.size(); i++) {
                    JSONObject jo = array.getJSONObject(i);


                    //


                }
                result = new Result(true, "同步成功");
            }
        } catch (Exception e) {
            e.printStackTrace();
            result = new Result(false, "同步失败");
        }
        return result;
    }

    /***
     * @Author: suntf
     * @Description:获取门店订单列表
     * @Date: 2019/8/6
     * @param orderListForErpRequest:
     * @return: com.hlsofttech.rsp.Result
     **/
    @ApiOperation(value = "ERP系统对接-获取门店订单列表", notes = "ERP系统对接-获取门店订单列表", httpMethod = "POST")
    @PostMapping("/api/erpApi/order/list")
    public Result orderList(@RequestBody @Validated OrderListForErpRequest orderListForErpRequest) {

        try {
            // 解析参数并进行验签处理，验签成功返回接收的参数
            boolean checkSign = ERPParamUtil.checkInfo(JSONObject.toJSON(orderListForErpRequest).toString(), app_secret);
            if (checkSign) {
                log.info("中台查询订单列表");

            } else {
                // 验签失败
                return Result.newFailureResult(new CommonBizException(ExpCodeEnum.SIGN_FAIL));
            }
        } catch (Exception e) {
            e.printStackTrace();
            return Result.newFailureResult(new CommonBizException(ExpCodeEnum.SYS_ERROR));
        }
        return Result.newSuccessResult("");
    }

    /***
     * @Author: suntf
     * @Description:库存同步,支持批量
     * @Date: 2019/8/6
     * @param syncStockForErpRequest:
     * @return: com.hlsofttech.rsp.Result
     **/
    @AuthPower(avoidSign = false, avoidLogin = true)
    @ApiOperation(value = "ERP系统对接-库存同步", notes = "ERP系统对接-库存同步", httpMethod = "POST")
    @PostMapping("/api/erpApi/stock/sync")
    public Result syncStock(@RequestBody SyncStockForErpRequest syncStockForErpRequest) {

        try {
            // 解析参数并进行验签处理，验签成功返回接收的参数
            boolean checkSign = ERPParamUtil.checkInfo(JSONObject.toJSON(syncStockForErpRequest).toString(), app_secret);
            if (checkSign) {
                log.info("中台同步药品库存");

            } else {
                // 验签失败
                return Result.newFailureResult(new CommonBizException(ExpCodeEnum.SIGN_FAIL));
            }
        } catch (Exception e) {
            e.printStackTrace();
            return Result.newFailureResult(new CommonBizException(ExpCodeEnum.SYS_ERROR));
        }
        return Result.newSuccessResult("");
    }
}
