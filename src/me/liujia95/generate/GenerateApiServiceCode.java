package me.liujia95.generate;

import me.liujia95.bean.ConfigBean;
import me.liujia95.template.TApiService;

/**
 * Created by Administrator on 2017/7/5 0005.
 */
public class GenerateApiServiceCode {

    public static String spellFileName(){
        return "\\ApiService.java";
    }

    public static String spellContent(ConfigBean bean){
        StringBuilder method= new StringBuilder();
        for (int i = 0;i<bean.getKw_method_name_list().size();i++){
            method.append(spellMethod(bean.getKw_method_name_list().get(i)));
        }
        return method.toString();
    }

    public static String spellMethod(ConfigBean.KwMethodNameListBean bean){
        String methodName = bean.getName();
        String url = bean.getUrl();
        String returnType = bean.getReturn_type();
        StringBuilder sbParams = new StringBuilder();
        for (int i= 0 ;i<bean.getUrl_params().size();i++){
            sbParams.append(spellParams(bean.getUrl_params().get(i)));
        }
        //%1$s:方法名关键字
        //%2$s:url路径
        //%3$s:返回值类型
        //%4$s:参数名
        return String.format(TApiService.API,methodName,url,returnType,sbParams);
    }

    public static String spellParams(ConfigBean.KwMethodNameListBean.UrlParamsBean bean){
        //%1$s:参数名
        return String.format(TApiService.PARAMS,bean.getName());
    }
}
