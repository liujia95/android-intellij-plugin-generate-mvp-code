package me.liujia95;

import com.google.gson.Gson;
import me.liujia95.bean.ConfigBean;
import me.liujia95.bean.OptionsBean;
import me.liujia95.generate.*;
import me.liujia95.utils.FileUtils;

public class GenerateMvpCode {

    public static void execute(String json,String path,OptionsBean options) {
        ConfigBean bean = formatJson(json);
        if(options.hasFragment){
            FileUtils.writeToFile(
                    GenerateFragmentCode.spellFilePath(path),
                    GenerateFragmentCode.spellFileName(bean),
                    GenerateFragmentCode.spellContent(bean,path,options.hasRecyclerView));
        }
        if(options.hasAdapter){
            FileUtils.writeToFile(
                    GenerateAdapterCode.spellFilePath(path),
                    GenerateAdapterCode.spellFileName(bean),
                    GenerateAdapterCode.spellContent(bean,path));
        }
        if(options.hasPresenter){
            FileUtils.writeToFile(
                    GeneratePresenterCode.spellFilePath(path),
                    GeneratePresenterCode.spellFileName(bean),
                    GeneratePresenterCode.spellContent(bean,path));
        }
        if(options.hasModel){
            FileUtils.writeToFile(
                    GenerateModelCode.spellFilePath(path),
                    GenerateModelCode.spellFileName(bean),
                    GenerateModelCode.spellContent(bean,path));
        }
        if(options.hasContract){
            FileUtils.writeToFile(
                    GenerateContractCode.spellFilePath(path),
                    GenerateContractCode.spellFileName(bean),
                    GenerateContractCode.spellContent(bean,path));
        }
        if(options.hasApi){
            FileUtils.writeToFile(
                    path,
                    GenerateApiServiceCode.spellFileName(),
                    GenerateApiServiceCode.spellContent(bean));
        }
    }

    /**
     * 格式化Json
     * @param json
     * @return
     */
    private static ConfigBean formatJson(String json) {
        Gson gson = new Gson();
        return gson.fromJson(json, ConfigBean.class);
    }
}
