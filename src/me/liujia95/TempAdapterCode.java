package me.liujia95;

/**
 * Author: LiuJia on 2017/6/3 0003 21:18.
 * Email: liujia95me@126.com
 */

public interface TempAdapterCode {

    String ADAPTER = "public class %1$sVAdapter extends BaseRecyclerViewAdapter</*todo:*/, BaseViewHolder> {\n" +
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
