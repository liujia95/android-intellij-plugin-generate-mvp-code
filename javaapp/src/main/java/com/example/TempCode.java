package com.example;

/**
 * Author: LiuJia on 2017/6/3 0003 10:31.
 * Email: liujia95me@126.com
 */

public interface TempCode {

    //---------------------- contract -----------------------
    String CONTRACT = "public interface %1$sContract { \n" +
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
    String CONTRACT_METHOD_VIEW = "        void response%1$s(%2$s);\n";
    String CONTRACT_METHOD_PRESENTER = "        void request%1$s(%2$s);\n";
    String CONTRACT_METHOD_MODEL = "        Observable(%3$s) request%1$s(%2$s);\n";


    //---------------------- model -----------------------

    String MODEL ="public class %1$sModel extends BaseModel implements %1$sContract.Model {\n" +
            "    @Override\n" +
            "    public void start(Object request) {\n" +
            "\n" +
            "    }\n" +
            "\n" +
            "%2$s\n" +
            "}";
    String MODEL_METHOD = "\t@Override\n" +
            "    public Observable<%1$s> request%2$s(%3$s) {\n" +
            "        return HttpHelper.getService(ApiService.class).request%2$s(ApiService.request%2$s\n" +
            "                , %4$s)\n" +
            "                .subscribeOn(Schedulers.io());\n" +
            "    }\n";

    //---------------------- presenter -----------------------
    String PRESENTER = "public class %1$sPresenter extends BasePresenter<%1$sContract.View, %1$sContract.Model> implements %1$sContract.Presenter {\n" +
            "    private final String TAG = %1$sPresenter.class.getSimpleName();\n" +
            "\n" +
            "    public %1$sPresenter(%1$sContract.View mView) {\n" +
            "        super(mView);\n" +
            "    }\n" +
            "\n" +
            "    @NonNull\n" +
            "    @Override\n" +
            "    protected %1$sContract.Model createModel() {\n" +
            "        return new %1$sModel();\n" +
            "    }\n" +
            "\n" +
            "    @Override\n" +
            "    public void start(Object request) {\n" +
            "    }\n" +
            "\n" +
            "    %2$s\n" +
            "    \n" +
            "}";
    String PRESENTER_METHOD = "@Override\n" +
            "    public void request%1$s() {\n" +
            "        mRxManager.add(mModel.request%1$s()\n" +
            "                .observeOn(AndroidSchedulers.mainThread())\n" +
            "                .subscribe(bean -> {\n" +
            "                    if (bean.getOther().getCode() == Constants.RESPONSE_CODE_NOMAL) {\n" +
            "                        getView().response%1$s(bean);\n" +
            "                    } else {\n" +
            "                        getView().error(bean.getOther().getMessage());\n" +
            "                    }\n" +
            "                }, this::error));\n" +
            "    }\n";

    //---------------------- fragment -----------------------
    String FRAGMENT = "public class %1$sFragment extends BaseFragment<%1$sContract.Presenter> implements %1$sContract.View {\n" +
            "    \n" +
            "    public static final String TAG = %1$sFragment.class.getSimpleName();\n" +
            "    \n" +
            "    @BindView(R.id.toolbar_title)\n" +
            "    TextView toolbarTitle;\n" +
            "    @BindView(R.id.toolbar)\n" +
            "    Toolbar toolbar;\n" +
            "    \n" +
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
            "        \n" +
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
            "\n" +
            "    }\n" +
            "\n" +
            "    @Override\n" +
            "    public void error(String errorMessage) {\n" +
            "        DialogHelper.warningSnackbar(getView(), errorMessage);\n" +
            "    }\n" +
            "\n" +
            "%3$s\n" +
            "}";

    String FRAGMENT_RESPONSE_METHOD = "\t@Override\n" +
            "    public void response%1$s(%2$s) {\n" +
            "        \n" +
            "    }\n";
}