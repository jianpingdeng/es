package com.djp.common.util;

/**
 * Created by dengjianping on 2015/8/14.
 */
public class Mytest implements Runnable {
    private RandomProbability randomUtil =  RandomUtil.getPool_10_188_Instence();
    private RandomProbability randomUtil2 =  RandomUtil.getPool_1_5_Instence();
    private int[][] weigth = {{45,29,15,5,3,2,1},{0,1,2,3,4,5,6}};
    private int[][] weigth2 = {{1,1},{0,1}};
    public static void main(String[] args) {
        Mytest test = new Mytest();

        for (int i=0;i<20000;i++){
            test.run();
        }

    }


    public void run() {
        int result =0;
        while (result == 0){
            result = randomUtil.randomValue(10,180,7,weigth);
        }
        System.out.print(" "+result+" ");
        result = 0;
        while (result == 0){
            result = randomUtil2.randomValue(1,5,2,weigth2);
        }
        System.out.print(" "+result+"\n");
    }
}