package com.hlsofttech.delivery.platform.meituan.vo;

import lombok.Data;

import java.util.List;

/**
 * 订单商品信息列表
 */
@Data
public class OpenApiGoods {
    private List<OpenApiGood> goods;
}


