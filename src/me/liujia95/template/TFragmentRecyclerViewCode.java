package me.liujia95.template;

/**
 * Author: LiuJia on 2017/6/3 0003 20:31.
 * Email: liujia95me@126.com
 */

public interface TFragmentRecyclerViewCode {

    String CREATE_VIEW=
            "\t@BindView(R.id.recyclerView)\n" +
            "    RecyclerView recyclerView;\n" +
            "    @BindView(R.id.ptrFrameLayout)\n" +
            "    PtrFrameLayout ptrFrameLayout;\n" +
            "    private %1$sRVAdapter adapter;";

    String INIT =
            "        recyclerView.setLayoutManager(new LinearLayoutManager(_mActivity));\n" +
            "        adapter = new %1$sRVAdapter();\n" +
            "        adapter.setEnableLoadMore(true);\n" +
            "        adapter.setOnLoadMoreListener(() -> {\n" +
            "            params.page++;\n" +
            "            //todo:mPresenter.request\n" +
            "        }, recyclerView);\n" +
            "        recyclerView.setAdapter(adapter);";

    String RESPONSE =
            "        ptrFrameLayout.refreshComplete();\n" +
            "        if (datas == null || datas.size() == 0) {\n" +
            "            adapter.loadMoreEnd();\n" +
            "            return;\n" +
            "        }\n" +
            "        if (params.page == 1) {\n" +
            "            adapter.setNewData(datas);\n" +
            "            adapter.disableLoadMoreIfNotFullPage(recyclerView);\n" +
            "        } else {\n" +
            "            adapter.addData(datas);\n" +
            "            adapter.setEnableLoadMore(true);\n" +
            "            adapter.loadMoreComplete();\n" +
            "        }\n";

    String ERROR =
            "        ptrFrameLayout.refreshComplete();\n" +
            "        if (params.page == 1) {\n" +
            "        } else if (params.page > 1) {\n" +
            "            adapter.loadMoreFail();\n" +
            "            params.page--;\n" +
            "        }\n";
}
