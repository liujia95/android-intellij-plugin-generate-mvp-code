package me.liujia95;

import com.google.gson.Gson;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

public class GenerateMvpCode {
//{"kw_class_name":"Home","kw_method_name_list":[{"name":"Banners","return_type":"BannerBean","params_type":"Params","url":"http://www.aglhz.com:8090/sub_property_ysq/neighbor/activity/to-client/activity-list","url_params":[{"name":"pageSize"},{"name":"page"},{"name":"keywords"},{"name":"cmnt_c"}]},{"name":"Notice","return_type":"BaseBean","params_type":"Params","url":"http://www.aglhz.com:8090/sub_property_ysq/neighbor/activity/to-client/activity-list","url_params":[{"name":"pageSize"},{"name":"page"},{"name":"keywords"},{"name":"cmnt_c"}]}],"fragment_layout":"fragment_home","fragment_type":"1"}
    static ConfigBean bean;

    static String root_path = "F:\\gaocheng\\code\\auto\\";
    private static String packageStr;

    public static void execute(String json,String path) {
        root_path = path;

        try {
            packageStr = path.substring(path.indexOf("java/")+("java/").length()).replace("/",".");
        }catch (Exception e){
        }

        bean = formatJson(json);
        String c_moethView = "";
        String c_moethPresenter = "";
        String c_moethModel = "";

        String m_mothod = "";

        String p_mothod = "";

        String f_mothod = "";

        String api_method = "";

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
            String api_params = "";
            for (int j = 0; j < methodBean.getUrl_params().size(); j++) {
                String name = methodBean.getUrl_params().get(j).getName();
                paramsStr += methodBean.getParams_type().toLowerCase() + "." + name;
                api_params += String.format(TempCode.API_PARAMS, name);
                if (j != methodBean.getUrl_params().size() - 1) {
                    paramsStr += ",";
                }
            }
            m_mothod += String.format(TempCode.MODEL_METHOD, methodReturn, methodName, methodType, paramsStr);

            //------------------ api -------------------
            api_method += String.format(TempCode.API,methodName,methodBean.getUrl(),methodReturn,api_params);

            //------------------ presenter -------------------
            p_mothod += String.format(TempCode.PRESENTER_METHOD, methodName);

            //------------------ fragment -------------------
            f_mothod += String.format(TempCode.FRAGMENT_RESPONSE_METHOD, methodName, methodReturn + " bean");

        }
        System.out.print("-------------------- contract -----------------------\n");
        String contentStr = String.format(TempCode.CONTRACT,
                bean.getKw_class_name(), c_moethView, c_moethPresenter, c_moethModel, packageStr +".contract");
        System.out.print(contentStr);
        writeToFile(root_path +"\\contract\\"  ,bean.getKw_class_name() + "Contract.java", contentStr);

        System.out.print("-------------------- api -----------------------\n");
        System.out.print(api_method);
        writeToFile(root_path  , "\\ApiService.java", api_method);

        System.out.print("---------------------- model ------------------------\n");
        contentStr = String.format(TempCode.MODEL, bean.getKw_class_name(), m_mothod, packageStr +".model");
        System.out.print(contentStr);
        writeToFile(root_path +"\\model\\"  , bean.getKw_class_name() + "Model.java", contentStr);

        System.out.print("-------------------- presenter ----------------------\n");
        contentStr = String.format(TempCode.PRESENTER, bean.getKw_class_name(), p_mothod, packageStr +".presenter");
        System.out.print(contentStr);
        writeToFile(root_path + "\\presenter\\"  ,bean.getKw_class_name() + "Presenter.java", contentStr);

        System.out.print("-------------------- fragment ----------------------\n");

        String rv_create_view="";
        String rv_init="";
        String rv_error="";
        switch (bean.getFragment_type()){
            case "1":
                createAdapterFile();
                rv_create_view =String.format(TempRvCode.CREATE_VIEW,bean.getKw_class_name());
                rv_init = String.format(TempRvCode.INIT,bean.getKw_class_name());
                rv_error = TempRvCode.ERROR;
                break;
        }

        contentStr = String.format(TempCode.FRAGMENT,
                bean.getKw_class_name(),
                bean.getFragment_layout(),
                f_mothod,
                rv_create_view,
                rv_init,
                rv_error,
                packageStr +".fragment");
        System.out.print(contentStr);
        writeToFile(root_path + "\\fragment\\" ,bean.getKw_class_name() + "Fragment.java", contentStr);
    }

    private static void createAdapterFile() {
        String contentStr = String.format(TempAdapterCode.ADAPTER,bean.getKw_class_name(),packageStr+".fragment");
        writeToFile(root_path +"\\fragment\\", bean.getKw_class_name() + "RVAdapter.java", contentStr);
    }

    private static ConfigBean formatJson(String json) {
        Gson gson = new Gson();
        return gson.fromJson(json, ConfigBean.class);
    }

    private static void writeToFile(String filePath,String fileName, String content) {
        try {
            File file = new File(filePath);
            if(!file.exists()){
                file.mkdirs();
            }
            FileWriter fw = new FileWriter(new File(filePath+fileName), true);
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
