package me.liujia95.generate;

import me.liujia95.bean.ConfigBean;
import me.liujia95.GenerateHelper;
import me.liujia95.template.TFragment;
import me.liujia95.template.TFragmentRecyclerViewCode;

/**
 * Created by Administrator on 2017/7/5 0005.
 */
public class GenerateFragmentCode {

    public static final String FILE_NAME_SUFFIX = "Fragment.java";
    public static final String FILE_PATH_SUFFIX = "\\view\\";

    public static String spellFilePath(String rootPath){
        return rootPath +FILE_PATH_SUFFIX;
    }

    public static String spellFileName(ConfigBean bean){
        return GenerateHelper.getClassName(bean)+FILE_NAME_SUFFIX;
    }

    public static String spellContent(ConfigBean bean, String selectFilePath, boolean hasRecyclerView){
        String className = GenerateHelper.getClassName(bean);
        String layoutName = GenerateHelper.getLayoutName(bean);
        String packageName = GenerateHelper.getPackageName(selectFilePath,".view");
        StringBuilder method = new StringBuilder();
        for (int i = 0;i<bean.getKw_method_name_list().size();i++){
            method.append(spellMethod(bean.getKw_method_name_list().get(i)));
        }
        String rvPart1="";
        String rvPart2="";
        String rvPart3="";
        String rvPart4="";

        if(hasRecyclerView){
            rvPart1 = String.format(TFragmentRecyclerViewCode.BIND_VIEW,className);
            rvPart2 = String.format(TFragmentRecyclerViewCode.INIT,className);;
            rvPart3 = TFragmentRecyclerViewCode.ERROR;
            rvPart4 = TFragmentRecyclerViewCode.RESPONSE;
        }

        //%1$s:类名关键字
        //%2$s:xml布局文件名。
        //%3$s:响应函数体。
        //%4$s:recyclerView部分的控件声明。
        //%5$s:recyclerView初始化部分。
        //%6$s:error函数体。
        //%7$s:包名
        //%8$s:含recyclerView响应体
        return String.format(
                TFragment.CONTENT,
                className,
                layoutName,
                method.toString(),rvPart1,rvPart2,rvPart3,packageName,rvPart4);
    }

    public static String spellMethod(ConfigBean.KwMethodNameListBean methodBean){
        String methodName = GenerateHelper.getMethodName(methodBean);
        String returnParams = GenerateHelper.getReturnParams(methodBean);
        //%1$s:方法名关键字
        //%2$s:响应值与类型
       return String.format(TFragment.RESPONSE_METHOD, methodName, returnParams);
    }

}
