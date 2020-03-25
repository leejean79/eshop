package com.leejean.eshop.utils;

import java.util.Collection;

/**
     * 校验工具类
     */
    public class ValidateUtil {
        /**
         * 判断集合有效性
         */
        public static boolean isValid(Collection col){
            if(col == null || col.isEmpty())
                return false ;
            return true ;
        }
    }

