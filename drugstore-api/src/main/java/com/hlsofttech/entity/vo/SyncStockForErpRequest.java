package com.hlsofttech.entity.vo;


import com.hlsofttech.entity.erp.AbstractERPDTO;
import lombok.Data;

import javax.validation.Valid;

/***
 * @Author: suntf
 * @Description:erp-同步库存
 * @Date: 2019/8/6
 **/
@Data
public class SyncStockForErpRequest extends AbstractERPDTO {
    @Valid
    private SyncStockForErpListVO data;

}