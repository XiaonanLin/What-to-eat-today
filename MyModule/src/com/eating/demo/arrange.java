package com.eating.demo;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

/**
 * @author ${LIN}
 * @date ${2024.1.31} ${13:08}
 */
public class arrange {
    public static void main(String[] args) {
        food f1 = new food("牛肉面",14);
        food f2 = new food("煲仔饭",16);
        food f3 = new food("肠粉",15);
        food f4 = new food("拉面",18);
        food f5 = new food("鸡腿饭",14);
        food f6 = new food("炒饭",11);
        food f7 = new food("焗饭",17);
        food f8 = new food("麻辣烫",19);

        List<food> list = new ArrayList<>();

        list.add(f1);
        list.add(f2);
        list.add(f3);
        list.add(f4);
        list.add(f5);
        list.add(f6);
        list.add(f7);
        list.add(f8);

        Random random = new Random();
        Scanner sc = new Scanner(System.in);


        System.out.println("分别输入X,N（一周内吃超过X元的食物的次数不能超过N次）");
        int x = sc.nextInt();
        int n = sc.nextInt();
        System.out.println("输入M（一周内吃重复食物次数不能超过M次）");
        int m = sc.nextInt();
        int[]count = new int[]{0,0,0,0,0,0,0,0};
        for (int i = 0; i < 14; i++) {
            if (i == 0) {
                System.out.println("周一：");
            } else if (i == 2) {
                System.out.println("周二：");
            } else if (i == 4) {
                System.out.println("周三：");
            } else if (i == 6) {
                System.out.println("周四：");
            } else if (i == 8) {
                System.out.println("周五：");
            } else if (i == 10) {
                System.out.println("周六：");
            } else if (i == 12) {
                System.out.println("周日：");
            }

            int r = random.nextInt(8);
            food f = list.get(r);
            while(true) {
                //用来限制一周内吃超过X元的食物的次数不能超过N次
                while (true) {
                    //是否超过输入价格
                    if (f.getPrice() > x) {
                        //是否即将超过次数
                        if (count[r] >= n) {
                            //超过了就重新获取
                            r = random.nextInt(8);
                            f = list.get(r);
                        } else {
                            break;
                        }
                    }else {
                        break;
                    }
                }
                //用来限制一周内吃重复食物次数不能超过M次
                while (true) {
                    //是否超过次数
                    if (count[r] >= m){
                        //即将超过重复次数就重新获取
                        r = random.nextInt(8);
                        f = list.get(r);
                    }else {
                        break;
                    }
                }
                //找到不超过重复次数的食物后再次做超过价格的判断
                //超过就重新获取再循环一遍
                if (f.getPrice()>x){
                    if (count[r] >= n) {
                        r = random.nextInt(8);
                        f = list.get(r);
                    } else {
                        break;
                    }
                } else {
                    //不超过说明符合一切条件退出循环
                    break;
                }
            }
            //符合条件就让次数加一
            count[r] = ++count[r];
            System.out.println(f.getName() + "  " + f.getPrice() + "元");

            if (i % 2 == 1) {
                System.out.println("~~~~~~~~~~~~~~~~~~");
            }
        }

    }
}
