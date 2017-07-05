package me.liujia95.template;

/**
 * Created by Administrator on 2017/7/5 0005.
 */
public interface TApiService {

    //%1$s:方法名关键字
    //%2$s:url路径
    //%3$s:返回值类型
    //%4$s:参数名
    String API =
            "\tString request%1$s = \"%2$s\";\n" +
                    " \t@FormUrlEncoded\n" +
                    "    @POST\n" +
                    "    Observable<%3$s> request%1$s(\n" +
                    "            @Url String url\n" +
                    "%4$s    );\n";

    //%1$s:参数名
    String PARAMS = "            ,@Field(\"%1$s\") String %1$s\n";

}
