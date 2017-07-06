package me.liujia95;

import me.liujia95.bean.ConfigBean;

/**
 * Created by Administrator on 2017/7/5 0005.
 */
public class GenerateHelper {
    public static final String SEARCH_PATH_KEYWORD = "java/";

    //-------------------------- 包级 --------------------------
    public static String getPackageName(String selectFilePath,String suffix){
        return new StringBuilder(selectFilePath).append(suffix).substring(selectFilePath.indexOf(SEARCH_PATH_KEYWORD) + SEARCH_PATH_KEYWORD.length()).replace("/", ".");
    }

    //-------------------------- 类级 --------------------------
    public static String getClassName(ConfigBean bean){
        return bean.getKw_class_name();
    }

    public static String getLayoutName(ConfigBean bean){
        return bean.getFragment_layout();
    }

    //-------------------------- 方法级 --------------------------
    public static String getReturnType(ConfigBean.KwMethodNameListBean methodBean){
        return methodBean.getReturn_type();
    }

    public static String getReturnParams(ConfigBean.KwMethodNameListBean methodBean){
        return methodBean.getReturn_type() + " bean";
    }

    public static String getMethodType(ConfigBean.KwMethodNameListBean methodBean){
        return methodBean.getParams_type() + " " + methodBean.getParams_type().toLowerCase();
    }

    public static String getMethodName(ConfigBean.KwMethodNameListBean methodBean){
        return methodBean.getName();
    }

    //-------------------------- 参数级 --------------------------

}
