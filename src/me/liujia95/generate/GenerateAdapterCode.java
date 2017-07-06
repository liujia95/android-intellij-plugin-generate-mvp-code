package me.liujia95.generate;

import me.liujia95.GenerateHelper;
import me.liujia95.bean.ConfigBean;
import me.liujia95.template.TAdapterCode;

/**
 * Created by Administrator on 2017/7/5 0005.
 */
public class GenerateAdapterCode {

    public static final String FILE_NAME_SUFFIX = "RVAdapter.java";
    public static final String FILE_PATH_SUFFIX = "\\view\\";

    public static String spellFilePath(String rootPath){
        return rootPath +FILE_PATH_SUFFIX;
    }

    public static String spellFileName(ConfigBean bean){
        return GenerateHelper.getClassName(bean)+FILE_NAME_SUFFIX;
    }

    public static String spellContent(ConfigBean bean,String selectFilePath){
         String className = GenerateHelper.getClassName(bean);
         String packageName = GenerateHelper.getPackageName(selectFilePath,".view");
        //%1$s：类名关键字
        //%2$s：包路径
         return String.format(TAdapterCode.ADAPTER,className,packageName);
    }

}
