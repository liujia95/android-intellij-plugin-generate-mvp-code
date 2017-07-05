package me.liujia95.template;

/**
 * Created by Administrator on 2017/7/5 0005.
 */
public interface TPresenter {
    //%1$s:类名关键字
    //%2$s:请求函数体
    //%3$s:包名
    String CONTENT =
            "package %3$s;\n\n"+
                    "import android.support.annotation.NonNull;\n"+
                    "import io.reactivex.android.schedulers.AndroidSchedulers;\n"+
                    "public class %1$sPresenter extends BasePresenter<%1$sContract.View, %1$sContract.Model> implements %1$sContract.Presenter {\n" +
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




    //%1$s:函数名关键字
    String REQUEST_METHOD =
            "@Override\n" +
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

}
