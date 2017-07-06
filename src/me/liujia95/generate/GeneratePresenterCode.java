package me.liujia95.generate;

import me.liujia95.bean.ConfigBean;
import me.liujia95.GenerateHelper;
import me.liujia95.template.TPresenter;

/**
 * Created by Administrator on 2017/7/5 0005.
 */
public class GeneratePresenterCode {

    public static final String FILE_NAME_SUFFIX = "Presenter.java";
    public static final String FILE_PATH_SUFFIX = "\\presenter\\";

    public static String spellFilePath(String rootPath){
        return rootPath +FILE_PATH_SUFFIX;
    }

    public static String spellFileName(ConfigBean bean){
        return GenerateHelper.getClassName(bean)+FILE_NAME_SUFFIX;
    }
    public static String spellContent(ConfigBean bean,String selectFilePath){
        String className = GenerateHelper.getClassName(bean);
        String packageName = GenerateHelper.getPackageName(selectFilePath,".presenter");
        StringBuilder sbMethod = new StringBuilder();
        for (int i = 0;i<bean.getKw_method_name_list().size();i++){
            sbMethod.append(spellMethod(bean.getKw_method_name_list().get(i)));
        }
        //%1$s:类名关键字
        //%2$s:请求函数体
        //%3$s:包名
       return String.format(TPresenter.CONTENT,className,sbMethod,packageName);
    }

    public static String spellMethod(ConfigBean.KwMethodNameListBean bean){
        String methodName = GenerateHelper.getMethodName(bean);
        //%1$s:函数名关键字
        return String.format(TPresenter.REQUEST_METHOD,methodName);
    }

}
