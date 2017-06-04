# Android base on MVP code generation
## 安装:

## 使用:
1.点击Android Studio下的Code菜单 ——> 选择单击MVP Code。
配置json格式。
 ```json
  {
     "kw_class_name":"类名关键字",
     "kw_method_name_list":[{
         "name":"函数名关键字",
         "return_type":"返回值",
         "params_type":"参数类型",
         "view_params_type":"响应返回类型",
         "url":"url路径",
         "url_params":[{
             "name":"参数名字"
         }]
     }],
     "fragment_layout":"fragment的布局文件名",
     "fragment_type":"页面的类型(1:recyclerview，2：表单型)"
 }
 ```
## License

Copyright (C) 2016 Nekocode (https://github.com/nekocode)

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

     http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
```
