# 请注意，已经配置了mybatis逆向工程插件
如果要进行逆向工程，先配置主资源文件夹下的**generatorConfig.xml**，修改数据库驱动位置，数据库类型等，在context中按照示例使用table节点配置。
最后运行插件mybatis-generator-maven-plugin：
> mvn mybatis-generator:generate

即可在target目录下生成逆向文件