package com.liujia95.me.agcode;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.google.gson.Gson;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();

    private static String json = "{\"kw_class_name\":\"Home\",\"kw_method_name_list\":[{\"name\":\"Banners\",\"params_type\":\"Params\",\"return_type\":\"BannerBean\"},{\"name\":\"Notice\",\"params_type\":\"Params\",\"return_type\":\"BaseBean\"}]}";

    @SuppressLint("StringFormatMatches")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ConfigBean bean = formatJson();

        String moethView = "";
        String moethPresenter = "";
        String moethModel = "";
        for (int i = 0; i < bean.getKw_method_name_list().size(); i++) {
            ConfigBean.KwMethodNameListBean methodBean = bean.getKw_method_name_list().get(i);
            String methodName = methodBean.getName();
            String methodType = methodBean.getParams_type() + " " + methodBean.getParams_type().toLowerCase();
            String methodReturn = methodBean.getReturn_type();
            moethView += String.format(getResources().getString(R.string.temp_mothod_view, methodName, methodType));

//            methodName = methodBean.getName();
//            methodType = methodBean.getParams_type() + " " + methodBean.getParams_type().toLowerCase();
            moethPresenter += String.format(getResources().getString(R.string.temp_mothod_presenter, methodName, methodType));
            moethModel += String.format(getResources().getString(R.string.temp_mothod_model, methodName, methodType, methodReturn));
        }

        String contractStr = String.format(getResources().getString(R.string.temp_contract),
                bean.getKw_class_name(), moethView, moethPresenter, moethModel);

        Log.e(TAG, contractStr);
    }

    private ConfigBean formatJson() {
        Gson gson = new Gson();
        return gson.fromJson(json, ConfigBean.class);

    }
}
