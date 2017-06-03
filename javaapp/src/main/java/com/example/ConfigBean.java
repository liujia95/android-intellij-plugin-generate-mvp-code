package com.example;

import java.util.List;

/**
 * Author: LiuJia on 2017/6/2 0002 20:28.
 * Email: liujia95me@126.com
 */

public class ConfigBean {


    /**
     * kw_class_name : Home
     * kw_method_name_list : [{"name":"Banners","return_type":"BannerBean","params_type":"Params","params_list":[{"name":"token"},{"name":"fid"},{"name":"city"}]},{"name":"Notice","return_type":"BaseBean","params_type":"Params","params_list":[]}]
     * fragment_layout : fragment_home
     */

    private String kw_class_name;
    private String fragment_layout;
    private List<KwMethodNameListBean> kw_method_name_list;

    public String getKw_class_name() {
        return kw_class_name;
    }

    public void setKw_class_name(String kw_class_name) {
        this.kw_class_name = kw_class_name;
    }

    public String getFragment_layout() {
        return fragment_layout;
    }

    public void setFragment_layout(String fragment_layout) {
        this.fragment_layout = fragment_layout;
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
         * return_type : BannerBean
         * params_type : Params
         * params_list : [{"name":"token"},{"name":"fid"},{"name":"city"}]
         */

        private String name;
        private String return_type;
        private String params_type;
        private List<ParamsListBean> params_list;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getReturn_type() {
            return return_type;
        }

        public void setReturn_type(String return_type) {
            this.return_type = return_type;
        }

        public String getParams_type() {
            return params_type;
        }

        public void setParams_type(String params_type) {
            this.params_type = params_type;
        }

        public List<ParamsListBean> getParams_list() {
            return params_list;
        }

        public void setParams_list(List<ParamsListBean> params_list) {
            this.params_list = params_list;
        }

        public static class ParamsListBean {
            /**
             * name : token
             */

            private String name;

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }
        }
    }
}
