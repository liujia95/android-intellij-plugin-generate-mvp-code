package com.liujia95.me.agcode;

import java.util.List;

/**
 * Author: LiuJia on 2017/6/2 0002 20:28.
 * Email: liujia95me@126.com
 */

public class ConfigBean {


    /**
     * kw_class_name : Home
     * kw_method_name_list : [{"name":"Banners","params_type":"Params","return_type":"BannerBean"},{"name":"Notice","params_type":"Params","return_type":"BaseBean"}]
     */

    private String kw_class_name;
    private List<KwMethodNameListBean> kw_method_name_list;

    public String getKw_class_name() {
        return kw_class_name;
    }

    public void setKw_class_name(String kw_class_name) {
        this.kw_class_name = kw_class_name;
    }

    public List<KwMethodNameListBean> getKw_method_name_list() {
        return kw_method_name_list;
    }

    public void setKw_method_name_list(List<KwMethodNameListBean> kw_method_name_list) {
        this.kw_method_name_list = kw_method_name_list;
    }

    public static class KwMethodNameListBean {
        /**
         * name : Banners
         * params_type : Params
         * return_type : BannerBean
         */

        private String name;
        private String params_type;
        private String return_type;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getParams_type() {
            return params_type;
        }

        public void setParams_type(String params_type) {
            this.params_type = params_type;
        }

        public String getReturn_type() {
            return return_type;
        }

        public void setReturn_type(String return_type) {
            this.return_type = return_type;
        }
    }
}
