package com.djp.common.util;

import org.junit.Test;

/**
 * Created by dengjianping on 2015/8/14.
 */
public class Mytest implements Runnable {
    public static void main(String[] args) {
        Mytest test = new Mytest();
        for (int i=0;i<73;i++){
            test.run();
        }

    }


    public void run() {
        int[][] weigth = {{45,29,15,5,3,2,1},{0,1,2,3,4,5,6}};
        int result = new RandomUtil().randomValue(10,180,7,weigth);
        System.out.print(" "+result);
    }
}