# 项目目录结构
```bash
advisor:
----root 顶层父模块
--------+common 模块
----------+tools category package
--------+persistence 模块
----------+dao category package
--------+service 模块
----------+service category package
--------+schedule 模块
----------+task category package
--------+web 父模块
---------+mobile 移动端模块
---------+destop 桌面端模块
--------+android 模块
--------+ios 模块
--------+reactapp 模块
```
## root模块
作为整个项目的父模块，主要用于依赖版本管理，私服仓库设置，发布设置等一些默认设置设置。
> 此项目打包方式为pom，在子项目中引入新依赖时注意查看是否已有版本约束

## common模块
此模块主要存放通用工具类，如ip地址库转换，通用http操作，第三方接口集成等。
> 注意此项目中所有的方法需要做到无状态，并且如果整个类中方法为静态方法，那么需要提供私有构造函数防止实例化。工具类按包名存放，需添加时先查看是否已有或是否需要重构

## persistence模块
此模块主要存放ORM层的内容，包括DAO接口，映射Model以及产生的配置文件
> dao，model和映射配置文件按业务模块划分，同一业务模块的存放在一个包/目录中

## service模块
此模块存放业务逻辑处理类，业务逻辑简单时分一个层，当需要调用多个业务完成一个业务的情况增多时，分2层。
> 注意同级业务处理类互调的情况，尽量不用使用，避免高耦合出现。此模块依赖persistence模块

## schedule模块
此模块为任务调度模块，所有调度任务在此模块编码。
> 注意

## web模块
web模块为前端controller父模块，有2个子模块：mobile和desktop。
> controller主要功能为参数完整性校验，视图选择逻辑，视图渲染。此模块为pom打包类型，提供两个子模块公用、默认配置。

### mobile模块
此模块为移动端服务模块，通过restful接口对app常规原生编码提供支持。

### desktop模块
此模块为桌面服务端模块，主要输出html，同时对app调用H5页面的功能支持。

## android模块
安卓项目模块。

## ios模块
ios项目模块。

## reactapp模块
react-native实现的跨终端app