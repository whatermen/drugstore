package com.hlsofttech.delivery.platform.meituan.request;

import lombok.Data;

/**
 * 模拟订单参数
 */
@Data
public class MockOrderRequest extends AbstractRequest {

    /**
     * 配送活动标识
     */
    private Long deliveryId;

    /**
     * 美团配送内部订单id，最长不超过32个字符
     */
    private String mtPeisongId;
}
