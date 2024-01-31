package com.eating.demo;
/**
 * @author ${LIN}
 * @date ${2024.1.31} ${13:04}
 */
public class food {
    private String name;
    private int price;


    public food() {
    }

    public food(String name, int price) {
        this.name = name;
        this.price = price;
    }

    /**
     * 获取
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * 设置
     * @param name 名字
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取
     * @return price
     */
    public int getPrice() {
        return price;
    }

    /**
     * 设置
     * @param price 价格
     */
    public void setPrice(int price) {
        this.price = price;
    }

}
