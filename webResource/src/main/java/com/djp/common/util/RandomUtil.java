package com.djp.common.util;

/**
 * Created by dengjianping on 2015/8/24.
 */
public class RandomUtil {
    private static RandomProbability rp1 = new RandomProbability();
    private static  RandomProbability rp2 = new RandomProbability();


    public static RandomProbability getPool_10_188_Instence(){
        return rp1;
    }

    public static RandomProbability getPool_1_5_Instence(){
        return rp2;
    }

}
