package me.liujia95.generate;

import me.liujia95.bean.ConfigBean;
import me.liujia95.GenerateHelper;
import me.liujia95.template.TModel;

/**
 * Created by Administrator on 2017/7/5 0005.
 */
public class GenerateModelCode {

    public static final String FILE_NAME_SUFFIX = "Model.java";
    public static final String FILE_PATH_SUFFIX = "\\model\\";

    public static String spellFilePath(String rootPath){
        return rootPath +FILE_PATH_SUFFIX;
    }

    public static String spellFileName(ConfigBean bean){
        return GenerateHelper.getClassName(bean)+FILE_NAME_SUFFIX;
    }

    public static String spellContent(ConfigBean bean, String selectFilePath){
        String className = GenerateHelper.getClassName(bean);
        StringBuilder mothod = new StringBuilder();
        String packageName = GenerateHelper.getPackageName(selectFilePath,".model");
        for (int i = 0;i<bean.getKw_method_name_list().size();i++){
            mothod.append(spellMothod(bean.getKw_method_name_list().get(i)));
        }
        //%1$s:类名关键字
        //%2$s:请求函数体
        //%3$s:包名
       return String.format(TModel.CONTENT,className, mothod.toString(), packageName);
    }

    public static String spellMothod(ConfigBean.KwMethodNameListBean methodBean){
        String methodName = GenerateHelper.getMethodName(methodBean);
        String methodType = GenerateHelper.getMethodType(methodBean);
        String returnType = GenerateHelper.getReturnType(methodBean);
        String paramsStr = spellParams(methodBean);
        //%1$s:返回的类型
        //%2$s:请求的方法名关键字
        //%3$s:请求参数类名，参数名
        //%4$s:请求的参数值
        return String.format(TModel.REQUEST_METHOD,returnType, methodName, methodType,paramsStr);
    }

    public static String spellParams(ConfigBean.KwMethodNameListBean methodBean){
        StringBuilder paramsStr = new StringBuilder();
        for (int j = 0; j < methodBean.getUrl_params().size(); j++) {
            String name = methodBean.getUrl_params().get(j).getName();
            paramsStr.append(methodBean.getParams_type().toLowerCase()).append(".").append(name);
            if (j != methodBean.getUrl_params().size() - 1) {
                paramsStr.append(",");
            }
        }
        return paramsStr.toString();
    }
}
