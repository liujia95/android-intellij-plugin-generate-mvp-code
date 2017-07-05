package me.liujia95.template;

/**
 * Created by Administrator on 2017/7/5 0005.
 */
public interface TContract {

    //%1$s:类名关键字
    //%2$s:View响应的方法声明
    //%3$s:Presenter请求的方法声明
    //%4$s:Model请求的方法声明
    //%5$s:包名
    String CONTENT =
            "package %5$s;\n\n"+
                    "import io.reactivex.Observable;\n"+
                    "public interface %1$sContract { \n" +
                    "\n" +
                    "    interface View extends BaseContract.View {\n" +
                    "%2$s" +
                    "    }\n" +
                    "\n" +
                    "    interface Presenter extends BaseContract.Presenter {\n" +
                    "%3$s" +
                    "    }\n" +
                    "\n" +
                    "    interface Model extends BaseContract.Model {\n" +
                    "%4$s" +
                    "    }\n" +
                    "}";

    //%1$s:请求的方法名关键字
    //%2$s:响应参数类名，参数名
    String CONTRACT_METHOD_VIEW = "        void response%1$s(%2$s);\n";

    //%1$s:请求的方法名关键字
    //%2$s:请求参数类名，参数名
    String CONTRACT_METHOD_PRESENTER = "        void request%1$s(%2$s);\n";

    //%1$s:请求的方法名关键字
    //%2$s:请求参数类名，参数名
    //%3$s:返回类型
    String CONTRACT_METHOD_MODEL = "        Observable<%3$s> request%1$s(%2$s);\n";

}
