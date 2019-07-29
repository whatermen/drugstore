package com.hlsofttech.delivery.platform.meituan.vo;

import org.apache.commons.lang3.StringUtils;

import java.math.BigDecimal;

/**
 * 订单商品信息
 */
public class OpenApiGood {
    /**
     * 商品数量
     */
    private int goodCount;

    /**
     * 商品名称
     */
    private String goodName;

    /**
     * 商品价格，单位为元
     */
    private BigDecimal goodPrice;

    /**
     * 商品单位，如个
     */
    private String goodUnit;

    public int getGoodCount() {
        return goodCount;
    }

    public void setGoodCount(int goodCount) {
        this.goodCount = goodCount;
    }

    public String getGoodName() {
        return goodName;
    }

    public void setGoodName(String goodName) {
        if (StringUtils.isEmpty(goodName)) {
            this.goodName = "";
        } else {
            this.goodName = goodName;
        }
    }

    public BigDecimal getGoodPrice() {
        return goodPrice;
    }

    public void setGoodPrice(BigDecimal goodPrice) {
        this.goodPrice = goodPrice;
    }

    public String getGoodUnit() {
        return goodUnit;
    }

    public void setGoodUnit(String goodUnit) {
        if (StringUtils.isEmpty(goodUnit)) {
            this.goodUnit = "";
        } else {
            this.goodUnit = goodUnit;
        }
    }

    @Override
    public String toString() {
        return "GoodDTO {" +
                "goodCount=" + goodCount +
                ", goodPrice=" + goodPrice +
                ", goodName=" + goodName +
                ", goodUnit=" + goodUnit +
                "}";
    }
}


