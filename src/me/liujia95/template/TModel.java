package me.liujia95.template;

/**
 * Created by Administrator on 2017/7/5 0005.
 */
public interface TModel {
    //%1$s:类名关键字
    //%2$s:请求函数体
    //%3$s:包名
    String CONTENT =
            "package %3$s;\n\n"+
                    "import io.reactivex.Observable;\nimport io.reactivex.schedulers.Schedulers;\n\n"+
                    "public class %1$sModel extends BaseModel implements %1$sContract.Model {\n" +
                    "    @Override\n" +
                    "    public void start(Object request) {\n" +
                    "\n" +
                    "    }\n" +
                    "\n" +
                    "%2$s\n" +
                    "}";

    //%1$s:返回的类型
    //%2$s:请求的方法名关键字
    //%3$s:请求参数类名，参数名
    //%4$s:请求的参数值
    String REQUEST_METHOD =
            "\t@Override\n" +
                    "    public Observable<%1$s> request%2$s(%3$s) {\n" +
                    "        return HttpHelper.getService(ApiService.class).request%2$s(ApiService.request%2$s\n" +
                    "                , %4$s)\n" +
                    "                .subscribeOn(Schedulers.io());\n" +
                    "    }\n";
}
