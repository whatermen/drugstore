package com.hlsofttech.platform.meituan.constants;

/**
 * @Description: 商品类型枚举
 * @Date: 2019/7/24
 **/
public enum GoodsCategory {
    FOOD(10, "外卖快餐"),
    FRUIT(20, "水果"),
    FRESH(30, "生鲜"),
    EXPRESS(40, "快递");

    private int code;
    private String description;

    GoodsCategory(int code, String description) {
        this.code = code;
        this.description = description;
    }

    public static GoodsCategory findByCode(int code) {
        for (GoodsCategory type : GoodsCategory.values()) {
            if (type.getCode() == code) {
                return type;
            }
        }
        return null;
    }

    public int getCode() {
        return code;
    }

    public String getDescription() {
        return description;
    }
}
