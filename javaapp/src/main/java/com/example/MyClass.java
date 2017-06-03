package com.example;

import com.google.gson.Gson;

import java.io.BufferedWriter;
import java.io.FileWriter;

public class MyClass {

    private static String json = "{\"kw_class_name\":\"Home\",\"kw_method_name_list\":[{\"name\":\"Banners\",\"return_type\":\"BannerBean\",\"params_type\":\"Params\",\"params_list\":[{\"name\":\"token\"},{\"name\":\"fid\"},{\"name\":\"city\"}]},{\"name\":\"Notice\",\"return_type\":\"BaseBean\",\"params_type\":\"Params\",\"params_list\":[]}],\"fragment_layout\":\"fragment_home\"}";
    static ConfigBean bean = formatJson();

    static String ROOT_PATH = "F:\\gaocheng\\code\\auto\\";

    public static void main(String[] args) {

        String c_moethView = "";
        String c_moethPresenter = "";
        String c_moethModel = "";

        String m_mothod = "";

        String p_mothod = "";

        String f_mothod = "";

        for (int i = 0; i < bean.getKw_method_name_list().size(); i++) {
            ConfigBean.KwMethodNameListBean methodBean = bean.getKw_method_name_list().get(i);
            String methodName = methodBean.getName();
            String methodType = methodBean.getParams_type() + " " + methodBean.getParams_type().toLowerCase();
            String methodReturn = methodBean.getReturn_type();
            //------------------ contract -------------------
            c_moethView += String.format(TempCode.CONTRACT_METHOD_VIEW, methodName, methodReturn + " bean");
            c_moethPresenter += String.format(TempCode.CONTRACT_METHOD_PRESENTER, methodName, methodType);
            c_moethModel += String.format(TempCode.CONTRACT_METHOD_MODEL, methodName, methodType, methodReturn);

            //------------------ model -------------------
            String paramsStr = "";
            for (int j = 0; j < methodBean.getParams_list().size(); j++) {
                paramsStr += methodBean.getParams_type().toLowerCase() + "." + methodBean.getParams_list().get(j).getName();
                if (j != methodBean.getParams_list().size() - 1) {
                    paramsStr += ",";
                }
            }
            m_mothod += String.format(TempCode.MODEL_METHOD, methodReturn, methodName, methodType, paramsStr);

            //------------------ presenter -------------------
            p_mothod += String.format(TempCode.PRESENTER_METHOD, methodName);

            //------------------ fragment -------------------
            f_mothod += String.format(TempCode.FRAGMENT_RESPONSE_METHOD, methodName,methodReturn+" bean");

        }
        System.out.print("-------------------- contract -----------------------\n");
        String contractStr = String.format(TempCode.CONTRACT,
                bean.getKw_class_name(), c_moethView, c_moethPresenter, c_moethModel);
        System.out.print(contractStr);
        writeToFile(ROOT_PATH + bean.getKw_class_name() + "Contract.java", contractStr);

        System.out.print("---------------------- model ------------------------\n");
        contractStr = String.format(TempCode.MODEL, bean.getKw_class_name(), m_mothod);
        System.out.print(contractStr);
        writeToFile(ROOT_PATH + bean.getKw_class_name() + "Model.java", contractStr);

        System.out.print("-------------------- presenter ----------------------\n");
        contractStr = String.format(TempCode.PRESENTER, bean.getKw_class_name(), p_mothod);
        System.out.print(contractStr);
        writeToFile(ROOT_PATH + bean.getKw_class_name() + "Presenter.java", contractStr);

        System.out.print("-------------------- fragment ----------------------\n");
        contractStr = String.format(TempCode.FRAGMENT, bean.getKw_class_name(),bean.getFragment_layout(),f_mothod);
        System.out.print(contractStr);
        writeToFile(ROOT_PATH + bean.getKw_class_name() + "Fragment.java", contractStr);
    }

    private static ConfigBean formatJson() {
        Gson gson = new Gson();
        return gson.fromJson(json, ConfigBean.class);
    }

    private static void writeToFile(String fileName, String content) {
        try {
            FileWriter fw = new FileWriter(fileName, true);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(content);
            bw.close();
            fw.close();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
