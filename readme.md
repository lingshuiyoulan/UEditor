##uEditor简单使用教程

1.	添加lib中的jar包

2.	配置ueditor.config.js
    URL="/ueditor/";<br>
    此处强烈建议大家使用"相对于网站根目录的相对路径"进行配置<br>
    url应为  /application context/ueditor/  <br>
    其中application context为web项目发布在tomcat上的根目录一般为"/";<br>

3.	在ueditor目录下创建index.jsp
    引入js文件  <br>
    实例化编辑器
    
4.	启动tomcat运行就可以了

###注意事项：

####可以使用uEditor默认的上传uploader无需任何配置

1.  自定义文件上传controller
    覆盖默认获取路径的方法
    返回json数据格式
    <pre>
    {
    "state": "SUCCESS",
    "original": "80px - \u526f\u672c (2).jpg",//对应alt属性
    "size": "13252",
    "title": "1465731377326075274.jpg",       //对应title属性
    "type": ".jpg",
    "url": "/ueditor/jsp/upload/image/20160612/1465731377326075274.jpg"
    }
    </pre>
    多文件上传时返回数据不能有title和original，否则确定按钮失效，未解决



