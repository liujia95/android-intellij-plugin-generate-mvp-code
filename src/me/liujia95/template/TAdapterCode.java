package me.liujia95.template;

/**
 * Author: LiuJia on 2017/6/3 0003 21:18.
 * Email: liujia95me@126.com
 */

public interface TAdapterCode {

    //%1$s：类名关键字
    //%2$s：包路径
    String ADAPTER =
            "package %2$s;\n\n"+
            "public class %1$sRVAdapter extends BaseRecyclerViewAdapter</*todo:*/, BaseViewHolder> {\n" +
            "\n" +
            "    public %1$sRVAdapter() {\n" +
            "        super(R.layout./*todo:*/);\n" +
            "    }\n" +
            "\n" +
            "    @Override\n" +
            "    protected void convert(BaseViewHolder helper, /*todo:*/ item) {\n" +
            "    }\n" +
            "}";

}
