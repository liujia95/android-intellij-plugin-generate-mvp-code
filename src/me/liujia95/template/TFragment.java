package me.liujia95.template;

/**
 * Created by Administrator on 2017/7/5 0005.
 */
public interface TFragment {
    //%1$s:类名关键字
    //%2$s:xml布局文件名。
    //%3$s:响应函数体。
    //%4$s:recyclerView部分的控件声明。
    //%5$s:recyclerView初始化部分。
    //%6$s:error函数体。
    //%7$s:包名
    //%8$s:含recyclerView响应体
    String CONTENT =
            "package %7$s;\n\n"+
                    "import android.os.Bundle;\n" +
                    "import android.support.annotation.NonNull;\n" +
                    "import android.support.annotation.Nullable;\n" +
                    "import android.support.v7.widget.Toolbar;\n" +
                    "import android.view.LayoutInflater;\n" +
                    "import android.view.View;\n" +
                    "import android.view.ViewGroup;\n" +
                    "import android.widget.TextView;\n\n"+
                    "import butterknife.BindView;\n" +
                    "import butterknife.ButterKnife;\n" +
                    "import butterknife.Unbinder;\n\n"+
                    "public class %1$sFragment extends BaseFragment<%1$sContract.Presenter> implements %1$sContract.View {\n" +
                    "    \n" +
                    "    public static final String TAG = %1$sFragment.class.getSimpleName();\n" +
                    "    \n" +
                    "    @BindView(R.id.toolbar_title)\n" +
                    "    TextView toolbarTitle;\n" +
                    "    @BindView(R.id.toolbar)\n" +
                    "    Toolbar toolbar;\n" +
                    "%4$s\n" +
                    "   \n" +
                    "    private Unbinder unbinder;\n" +
                    "    private Params params = Params.getInstance();\n" +
                    "\n" +
                    "    public static %1$sFragment newInstance() {\n" +
                    "        return new %1$sFragment();\n" +
                    "    }\n" +
                    "\n" +
                    "    @NonNull\n" +
                    "    @Override\n" +
                    "    protected %1$sContract.Presenter createPresenter() {\n" +
                    "        return new %1$sPresenter(this);\n" +
                    "    }\n" +
                    "\n" +
                    "    @Nullable\n" +
                    "    @Override\n" +
                    "    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {\n" +
                    "        View view = inflater.inflate(R.layout.%2$s, container, false);\n" +
                    "        unbinder = ButterKnife.bind(this, view);\n" +
                    "        return attachToSwipeBack(view);\n" +
                    "    }\n" +
                    "\n" +
                    "    @Override\n" +
                    "    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {\n" +
                    "        super.onViewCreated(view, savedInstanceState);\n" +
                    "        initToolbar();\n" +
                    "        initData();\n" +
                    "        initListener();\n" +
                    "    }\n" +
                    "\n" +
                    "    @Override\n" +
                    "    public void onRefresh() {\n" +
                    "        params.page = 1;\n" +
                    "        params.pageSize = Constants.PAGE_SIZE;\n" +
                    "    }\n" +
                    "\n" +
                    "    private void initToolbar() {\n" +
                    "        initStateBar(toolbar);\n" +
                    "        toolbarTitle.setText(\"\");\n" +
                    "        toolbar.setNavigationIcon(R.drawable.ic_chevron_left_white_24dp);\n" +
                    "        toolbar.setNavigationOnClickListener(v -> _mActivity.onBackPressedSupport());\n" +
                    "    }\n" +
                    "\n" +
                    "    private void initData() {\n" +
                    "%5$s\n" +
                    "    }\n" +
                    "\n" +
                    "    private void initListener(){\n" +
                    "\n" +
                    "    }\n" +
                    "\n" +
                    "    @Override\n" +
                    "    public void onDestroyView() {\n" +
                    "        super.onDestroyView();\n" +
                    "        unbinder.unbind();\n" +
                    "        \n" +
                    "    }\n" +
                    "\n" +
                    "    @Override\n" +
                    "    public void start(Object response) {\n" +
                    "%8$s\n" +
                    "    }\n" +
                    "\n" +
                    "    @Override\n" +
                    "    public void error(String errorMessage) {\n" +
                    "%6$s\n" +
                    "        DialogHelper.warningSnackbar(getView(), errorMessage);\n" +
                    "    }\n" +
                    "\n" +
                    "%3$s\n" +
                    "}";

    //%1$s:方法名关键字
    //%2$s:响应值与类型
    String RESPONSE_METHOD =
                    "   @Override\n" +
                    "   public void response%1$s(%2$s) {\n" +
                    "   }";

}
