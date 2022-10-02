# Bistu-login-api，点个star支持一下吧

模拟登陆`北京信息科技大学教务网`的 API ，可应用于课程表信息查询、成绩查询等项目的开发。本项目基于[wisedu-unified-login-api](https://github.com/ZimoLoveShuang/wisedu-unified-login-api)项目二次开发，作者为 **ThinkStu** 。

# 声明

1. 如果你想要将此项目架设在服务器上，那么你首先需要配置服务器连接校园网，具体见我的另一篇博文：[服务器连接校园网](https://blog.csdn.net/qq_35760825/article/details/127134130?spm=1001.2014.3001.5501)
2. **本项目仅供学习交流使用，如作他用所承受的任何直接、间接法律责任一概与作者无关**
3. 如果此项目侵犯了您或者您公司的权益，请联系作者删除。

# api文档

1. 部署 SpringBoot 程序后使用命令行访问：

    ```shell
    curl -X GET "http://服务器ip地址:端口/bistu/login?password=教务网密码&username=学号" -H "accept: */*"
    ```

    例如：

    ```shell
    curl -X GET "http://127.0.0.1:8080/bistu/login?password=orangeCat123&username=202099999" -H "accept: */*"
    ```

2. 成功后返回：
    ```json
    {
        "msg": "login success!",
        "code": 0,
        "cookies": "route=c02e1c52cb44ccedc7a00ac44a74ab3c;JSESSIONID=sKnaX6W3z7rN5AB9cQJ4An3OX3aOwq3aziPc4FIVW641bc_ihwXK!-173725045;CASTGC=TGT-1394-3FaIbOEbJ4RVrhgVrtVPRNzNNcODy6V3RMXRblvJdAfL5H3qMc1588506634030-QUpr-cas;CASPRIVACY=;iPlanetDirectoryPro=QCMaHbaG7vdSgN1QuSldJ0;asessionid=5ad7f5b4-eb74-4c3c-a694-76d24ea97b3f;MOD_AUTH_CAS=MOD_AUTH_ST-96230-7W9q97JkbbFzRLhj7hRr1588506634075-YBLG-cas"
    }
    ```

3. 失败后返回：
    ```json
    {
        "msg": "login failed! 用户名或者密码错误",
        "code": 1,
        "cookies": null
    }
    ```

# 依赖

1. tess4j：用于ocr识别验证码
2. fastjson：用于处理json数据
4. jsoup：用于解析html代码

# 部署

1. 请先在服务器配置好`tessreact（自动识别验证码插件）`，**非常重要**，安装和配置可以参考[子墨的博文](https://blog.zimo.wiki/posts/c417f07b/)
2. 在release中下载打包好的war包，或者jar包
3. `war`包放入`tomcat`等容器中，jar包使用`java -jar wisedu-unified-login-api-v1.0.jar &`命令执行
5. [点此直达对新手小白更加友好的部署教程](https://blog.zimo.wiki/posts/6c809f81/)
