package me.liujia95.generate;

import me.liujia95.ConfigBean;
import me.liujia95.GenerateHelper;
import me.liujia95.template.TContract;

/**
 * Created by Administrator on 2017/7/5 0005.
 */
public class GenerateContractCode {
    public static final String FILE_NAME_SUFFIX = "Contract.java";
    public static final String FILE_PATH_SUFFIX = "\\contract\\";

    public static String spellFilePath(String rootPath){
        return rootPath +FILE_PATH_SUFFIX;
    }

    public static String spellFileName(ConfigBean bean){
        return GenerateHelper.getClassName(bean)+FILE_NAME_SUFFIX;
    }

    public static String spellContent(ConfigBean bean, String selectFilePath){
        String className = GenerateHelper.getClassName(bean);
        String packageName = GenerateHelper.getPackageName(selectFilePath,".contract");
        StringBuilder sbViewMethod = new StringBuilder();
        StringBuilder sbModelMethod = new StringBuilder();
        StringBuilder sbPresenterMethod = new StringBuilder();
        for (int i = 0 ;i<bean.getKw_method_name_list().size();i++){
            sbViewMethod.append(spellViewMethod(bean.getKw_method_name_list().get(i)));
            sbModelMethod.append(spellModelMethod(bean.getKw_method_name_list().get(i)));
            sbPresenterMethod.append(spellPresenterMethod(bean.getKw_method_name_list().get(i)));
        }

        //%1$s:类名关键字
        //%2$s:View响应的方法声明
        //%3$s:Presenter请求的方法声明
        //%4$s:Model请求的方法声明
        //%5$s:包名
        return String.format(TContract.CONTENT,className,sbViewMethod.toString(),sbPresenterMethod,sbModelMethod,packageName);
    }

    public static String spellViewMethod(ConfigBean.KwMethodNameListBean bean){
        String methodName = GenerateHelper.getMethodName(bean);
        String returnParams = GenerateHelper.getReturnParams(bean);

        //%1$s:请求的方法名关键字
        //%2$s:响应参数类名，参数名
        return String.format(TContract.CONTRACT_METHOD_VIEW,methodName,returnParams);
    }

    public static String spellModelMethod(ConfigBean.KwMethodNameListBean bean){
        String methodName = GenerateHelper.getMethodName(bean);
        String methodType = GenerateHelper.getMethodType(bean);
        String returnType = GenerateHelper.getReturnType(bean);

        //%1$s:请求的方法名关键字
        //%2$s:请求参数类名，参数名
        //%3$s:返回类型
        return String.format(TContract.CONTRACT_METHOD_MODEL,methodName,methodType,returnType);
    }
    public static String spellPresenterMethod(ConfigBean.KwMethodNameListBean bean){
        String methodName = GenerateHelper.getMethodName(bean);
        String methodType = GenerateHelper.getMethodType(bean);

        //%1$s:请求的方法名关键字
        //%2$s:响应参数类名，参数名
        return String.format(TContract.CONTRACT_METHOD_PRESENTER,methodName,methodType);
    }

}
