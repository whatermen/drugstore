package com.hlsofttech.delivery.platform.meituan.util;


import com.alibaba.fastjson.JSON;
import com.hlsofttech.delivery.platform.meituan.request.*;
import org.apache.commons.lang3.StringUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description: 请求body构造器
 * @Author: suncy
 **/
public class ParamBuilder {

    private static void putIfNotEmpty(Map<String, String> map, String key, String value) {
        if (StringUtils.isNotEmpty(value) && !"null".equals(value)) {
            map.put(key, value);
        }
    }

    public static Map<String, String> convertToMap(EvaluateRequest request) {
        Map<String, String> map = new HashMap<>();
        if (request == null) {
            return map;
        }

        putIfNotEmpty(map, "appkey", request.getAppkey());
        putIfNotEmpty(map, "timestamp", String.valueOf(request.getTimestamp()));
        putIfNotEmpty(map, "version", request.getVersion());
        putIfNotEmpty(map, "sign", request.getSign());

        putIfNotEmpty(map, "comment_content", request.getCommentContent());
        putIfNotEmpty(map, "delivery_id", String.valueOf(request.getDeliveryId()));
        putIfNotEmpty(map, "mt_peisong_id", request.getMtPeisongId());
        putIfNotEmpty(map, "score", String.valueOf(request.getScore()));

        return map;
    }

    public static Map<String, String> convertToMap(CheckRequest request) {
        Map<String, String> map = new HashMap<>();
        if (request == null) {
            return map;
        }

        putIfNotEmpty(map, "appkey", request.getAppkey());
        putIfNotEmpty(map, "timestamp", String.valueOf(request.getTimestamp()));
        putIfNotEmpty(map, "version", request.getVersion());
        putIfNotEmpty(map, "sign", request.getSign());
        putIfNotEmpty(map, "shop_id", String.valueOf(request.getShopId()));
        putIfNotEmpty(map, "delivery_service_code", String.valueOf(request.getDeliveryServiceCode()));
        putIfNotEmpty(map, "receiver_address", request.getReceiverAddress());
        putIfNotEmpty(map, "receiver_lng", String.valueOf(request.getReceiverLng()));
        putIfNotEmpty(map, "receiver_lat", String.valueOf(request.getReceiverLat()));
        putIfNotEmpty(map, "check_type", String.valueOf(request.getCheckType()));
        putIfNotEmpty(map, "mock_order_time", String.valueOf(request.getMockOrderTime()));

        return map;
    }

    public static Map<String, String> convertToMap(CancelOrderRequest request) {
        Map<String, String> map = new HashMap<>();
        if (request == null) {
            return map;
        }

        putIfNotEmpty(map, "appkey", request.getAppkey());
        putIfNotEmpty(map, "timestamp", String.valueOf(request.getTimestamp()));
        putIfNotEmpty(map, "version", request.getVersion());
        putIfNotEmpty(map, "sign", request.getSign());
        putIfNotEmpty(map, "delivery_id", String.valueOf(request.getDeliveryId()));
        putIfNotEmpty(map, "mt_peisong_id", request.getMtPeisongId());
        putIfNotEmpty(map, "cancel_reason_id", String.valueOf(request.getCancelOrderReasonId().getCode()));
        putIfNotEmpty(map, "cancel_reason", request.getCancelReason());

        return map;
    }

    public static Map<String, String> convertToMap(CreateOrderByShopRequest request) {
        Map<String, String> map = new HashMap<>();
        if (request == null) {
            return map;
        }

        putIfNotEmpty(map, "appkey", request.getAppkey());
        putIfNotEmpty(map, "timestamp", String.valueOf(request.getTimestamp()));
        putIfNotEmpty(map, "version", request.getVersion());
        putIfNotEmpty(map, "sign", request.getSign());
        putIfNotEmpty(map, "delivery_id", String.valueOf(request.getDeliveryId()));
        putIfNotEmpty(map, "order_id", request.getOrderId());
        putIfNotEmpty(map, "shop_id", String.valueOf(request.getShopId()));
        putIfNotEmpty(map, "delivery_service_code", String.valueOf(request.getDeliveryServiceCode()));
        putIfNotEmpty(map, "receiver_name", request.getReceiverName());
        putIfNotEmpty(map, "receiver_address", request.getReceiverAddress());
        putIfNotEmpty(map, "receiver_phone", request.getReceiverPhone());
        putIfNotEmpty(map, "receiver_lng", String.valueOf(request.getReceiverLng()));
        putIfNotEmpty(map, "receiver_lat", String.valueOf(request.getReceiverLat()));
        putIfNotEmpty(map, "coordinate_type", String.valueOf(request.getCoordinateType()));
        putIfNotEmpty(map, "goods_value", String.valueOf(request.getGoodsValue()));
        putIfNotEmpty(map, "goods_height", String.valueOf(request.getGoodsHeight()));
        putIfNotEmpty(map, "goods_width", String.valueOf(request.getGoodsWidth()));
        putIfNotEmpty(map, "goods_length", String.valueOf(request.getGoodsLength()));
        putIfNotEmpty(map, "goods_weight", String.valueOf(request.getGoodsWeight()));
        putIfNotEmpty(map, "goods_detail", JSON.toJSONString(request.getGoodsDetail()));
        putIfNotEmpty(map, "goods_pickup_info", request.getGoodsPickupInfo());
        putIfNotEmpty(map, "goods_delivery_info", request.getGoodsDeliveryInfo());
        putIfNotEmpty(map, "expected_pickup_time", String.valueOf(request.getExpectedPickupTime()));
        putIfNotEmpty(map, "expected_delivery_time", String.valueOf(request.getExpectedDeliveryTime()));
        putIfNotEmpty(map, "poi_seq", request.getPoiSeq());
        putIfNotEmpty(map, "note", request.getNote());
        putIfNotEmpty(map, "cash_on_delivery", String.valueOf(request.getCashOnDelivery()));
        putIfNotEmpty(map, "cash_on_pickup", String.valueOf(request.getCashOnPickup()));
        putIfNotEmpty(map, "invoice_title", request.getInvoiceTitle());
        putIfNotEmpty(map, "order_type", String.valueOf(request.getOrderType().getCode()));

        return map;
    }

    public static Map<String, String> convertToMap(CreateOrderByCoordinatesRequest request) {
        Map<String, String> map = new HashMap<>();
        if (request == null) {
            return map;
        }

        putIfNotEmpty(map, "appkey", request.getAppkey());
        putIfNotEmpty(map, "timestamp", String.valueOf(request.getTimestamp()));
        putIfNotEmpty(map, "version", request.getVersion());
        putIfNotEmpty(map, "sign", request.getSign());
        putIfNotEmpty(map, "delivery_id", String.valueOf(request.getDeliveryId()));
        putIfNotEmpty(map, "order_id", request.getOrderId());
        putIfNotEmpty(map, "delivery_service_code", String.valueOf(request.getDeliveryServiceCode()));
        putIfNotEmpty(map, "receiver_name", request.getReceiverName());
        putIfNotEmpty(map, "receiver_phone", request.getReceiverPhone());
        putIfNotEmpty(map, "receiver_lng", String.valueOf(request.getReceiverLng()));
        putIfNotEmpty(map, "receiver_lat", String.valueOf(request.getReceiverLat()));
        putIfNotEmpty(map, "coordinate_type", String.valueOf(request.getCoordinateType()));
        putIfNotEmpty(map, "goods_value", String.valueOf(request.getGoodsValue()));
        putIfNotEmpty(map, "goods_height", String.valueOf(request.getGoodsHeight()));
        putIfNotEmpty(map, "goods_width", String.valueOf(request.getGoodsWidth()));
        putIfNotEmpty(map, "goods_length", String.valueOf(request.getGoodsLength()));
        putIfNotEmpty(map, "goods_weight", String.valueOf(request.getGoodsWeight()));
        putIfNotEmpty(map, "goods_detail", JSON.toJSONString(request.getGoodsDetail()));
        putIfNotEmpty(map, "goods_pickup_info", request.getGoodsPickupInfo());
        putIfNotEmpty(map, "goods_delivery_info", request.getGoodsDeliveryInfo());
        putIfNotEmpty(map, "expected_pickup_time", String.valueOf(request.getExpectedPickupTime()));
        putIfNotEmpty(map, "expected_delivery_time", String.valueOf(request.getExpectedDeliveryTime()));
        putIfNotEmpty(map, "poi_seq", request.getPoiSeq());
        putIfNotEmpty(map, "note", request.getNote());
        putIfNotEmpty(map, "order_type", String.valueOf(request.getOrderType().getCode()));

        putIfNotEmpty(map, "pick_up_type", String.valueOf(request.getPickUpType()));
        putIfNotEmpty(map, "receiver_province", request.getReceiverProvince());
        putIfNotEmpty(map, "receiver_city", request.getReceiverCity());
        putIfNotEmpty(map, "receiver_country", request.getReceiverCountry());
        putIfNotEmpty(map, "receiver_town", request.getReceiverTown());
        putIfNotEmpty(map, "receiver_detail_address", request.getReceiverDetailAddress());

        return map;
    }

    public static Map<String, String> convertToMap(QueryOrderRequest request) {
        Map<String, String> map = new HashMap<>();
        if (request == null) {
            return map;
        }

        putIfNotEmpty(map, "appkey", request.getAppkey());
        putIfNotEmpty(map, "timestamp", String.valueOf(request.getTimestamp()));
        putIfNotEmpty(map, "version", request.getVersion());
        putIfNotEmpty(map, "sign", request.getSign());
        putIfNotEmpty(map, "delivery_id", String.valueOf(request.getDeliveryId()));
        putIfNotEmpty(map, "mt_peisong_id", request.getMtPeisongId());

        return map;
    }

    public static Map<String, String> convertToMap(MockOrderRequest request) {
        Map<String, String> map = new HashMap<>();
        if (request == null) {
            return map;
        }

        putIfNotEmpty(map, "appkey", request.getAppkey());
        putIfNotEmpty(map, "timestamp", String.valueOf(request.getTimestamp()));
        putIfNotEmpty(map, "version", request.getVersion());
        putIfNotEmpty(map, "sign", request.getSign());
        putIfNotEmpty(map, "delivery_id", String.valueOf(request.getDeliveryId()));
        putIfNotEmpty(map, "mt_peisong_id", request.getMtPeisongId());

        return map;
    }

    public static Map<String, String> convertToMap(QueryShopAreaRequest request) {
        Map<String, String> map = new HashMap<>();
        if (request == null) {
            return map;
        }

        putIfNotEmpty(map, "appkey", request.getAppkey());
        putIfNotEmpty(map, "timestamp", String.valueOf(request.getTimestamp()));
        putIfNotEmpty(map, "version", request.getVersion());
        putIfNotEmpty(map, "sign", request.getSign());
        putIfNotEmpty(map, "delivery_service_code", String.valueOf(request.getDeliveryServiceCode()));
        putIfNotEmpty(map, "shop_id", request.getShopId());

        return map;
    }

    public static Map<String, String> convertToMap(CreateShopRequest request) {
        Map<String, String> map = new HashMap<>();
        if (request == null) {
            return map;
        }

        putIfNotEmpty(map, "appkey", request.getAppkey());
        putIfNotEmpty(map, "timestamp", String.valueOf(request.getTimestamp()));
        putIfNotEmpty(map, "version", request.getVersion());
        putIfNotEmpty(map, "sign", request.getSign());

        putIfNotEmpty(map, "shop_id", request.getShopId());
        putIfNotEmpty(map, "shop_name", request.getShopName());
        putIfNotEmpty(map, "category", String.valueOf(request.getCategory()));
        putIfNotEmpty(map, "second_category", String.valueOf(request.getSecondCategory()));
        putIfNotEmpty(map, "contact_name", request.getContactName());
        putIfNotEmpty(map, "contact_phone", request.getContactPhone());
        putIfNotEmpty(map, "contact_email", request.getContactEmail());
        putIfNotEmpty(map, "shop_address", request.getShopAddress());
        putIfNotEmpty(map, "shop_address_detail", request.getShopAddressDetail());
        putIfNotEmpty(map, "shop_lng", String.valueOf(request.getShopLng()));
        putIfNotEmpty(map, "shop_lat", String.valueOf(request.getShopLat()));
        putIfNotEmpty(map, "coordinate_type", String.valueOf(request.getCoordinateType()));
        putIfNotEmpty(map, "delivery_service_codes", request.getDeliveryServiceCodes());
        putIfNotEmpty(map, "business_hours", request.getBusinessHours());

        return map;
    }

    public static Map<String, String> convertToMap(QueryShopRequest request) {
        Map<String, String> map = new HashMap<>();
        if (request == null) {
            return map;
        }

        putIfNotEmpty(map, "appkey", request.getAppkey());
        putIfNotEmpty(map, "timestamp", String.valueOf(request.getTimestamp()));
        putIfNotEmpty(map, "version", request.getVersion());
        putIfNotEmpty(map, "sign", request.getSign());
        putIfNotEmpty(map, "shop_id", String.valueOf(request.getShopId()));

        return map;
    }
}
