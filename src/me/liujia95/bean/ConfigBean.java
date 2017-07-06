package me.liujia95.bean;

import java.util.List;

/**
 * Author: LiuJia on 2017/6/2 0002 20:28.
 * Email: liujia95me@126.com
 */

public class ConfigBean {


    /**
     * kw_class_name : 类名关键字
     * kw_method_name_list : [{"name":"函数名关键字","return_type":"返回值","params_type":"参数类型","view_params_type":"响应返回类型","url":"url路径","url_params":[{"name":"参数名字"}]}]
     * fragment_layout : fragment的布局文件名
     */

    private String kw_class_name;
    private String fragment_layout;

    public String getFragment_type() {
        return fragment_type;
    }

    public void setFragment_type(String fragment_type) {
        this.fragment_type = fragment_type;
    }

    private String fragment_type;
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
         * name : 函数名关键字
         * return_type : 返回值
         * params_type : 参数类型
         * view_params_type : 响应返回类型
         * url : url路径
         * url_params : [{"name":"参数名字"}]
         */

        private String name;
        private String return_type;
        private String params_type;
        private String view_params_type;
        private String url;
        private List<UrlParamsBean> url_params;

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

        public String getView_params_type() {
            return view_params_type;
        }

        public void setView_params_type(String view_params_type) {
            this.view_params_type = view_params_type;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public List<UrlParamsBean> getUrl_params() {
            return url_params;
        }

        public void setUrl_params(List<UrlParamsBean> url_params) {
            this.url_params = url_params;
        }

        public static class UrlParamsBean {
            /**
             * name : 参数名字
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
