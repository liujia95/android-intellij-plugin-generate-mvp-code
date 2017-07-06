package me.liujia95.template;

/**
 * Created by Administrator on 2017/7/4 0004.
 */
public interface TJson {

    String TEMP =
            "{\n" +
            "     \"kw_class_name\":\"类名关键字\",\n" +
            "     \"kw_method_name_list\":[{\n" +
            "         \"name\":\"函数名关键字\",\n" +
            "         \"return_type\":\"返回值\",\n" +
            "         \"params_type\":\"参数类型\",\n" +
            "         \"view_params_type\":\"响应返回类型\",\n" +
            "         \"url\":\"url路径\",\n" +
            "         \"url_params\":[{\n" +
            "             \"name\":\"参数名字\"\n" +
            "         }]\n" +
            "     }],\n" +
            "     \"fragment_layout\":\"fragment的布局文件名\",\n" +
            "     \"fragment_type\":\"页面的类型(1:recyclerview，2：表单型)\"\n" +
            " }";

}
