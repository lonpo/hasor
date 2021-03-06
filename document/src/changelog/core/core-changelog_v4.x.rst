--------------------
Release Hasor v4.x
--------------------
Hasor v4.1.1 (2020-02-?)
------------------------------------
**修复**
    - all-in-one 包的传递依赖丢失问题修复。
**新增**
    - 新增 DataQL Maven 插件，会根据 *.ql 文件生成对应的 Java 调用代码。

Hasor v4.1.0 (2020-02-03)
------------------------------------
**Commons**
    - 修复 ResourcesUtils 和 ScanClassPath，IO 文件句柄泄露问题。
    - BasicFuture 的 callback，当没有实现CancellFutureCallback的时候时候，会触发failed。
    - DataQL 中的 InterBeanMap 更名为 BeanMap 移到 commons 中。
    - DB 中的 LinkedCaseInsensitiveMap 移到 commons 中。
**Core**
    - 改造 hasor.core 全面支持 JSR-330。
    - 全新的 SPI 能力。
    - 单测覆盖率达到 90%，修复若干潜在的问题。
    - 主 namespace 'http://project.hasor.net/hasor/schema/main' 统一改为 'http://www.hasor.net/sechma/main'
    - @InjectSettings 注解增加，命名空间支持。
    - 默认配置文件名 hasor-config.xml 改为 hconfig.xml、不在提供环境参数属性文件的机制。
    - 其它大量接口上和内部执行机制的优化
**Web**
    - 单测覆盖率达到 90%，修复若干潜在的问题。
    - hasor-env-properties 参数不在有效。
    - @Produces 注解行为变化为不在影响使用哪个渲染器，而是负责指明使用什么类型作为 response 的 ContentType。
    - j2ee Servlet 会被转换成 MappingTo 运行。j2ee Filter 会被转换成 InvokerFilter 运行。
    - 新增 OneConfig 汇总了FilterConfig, ServletConfig, InvokerConfig 三个接口的实现。
    - ListenerPipeline 不在需要，取而代之使用 SPI 机制来替代。
    - RenderInvoker 接口不在提供 lockViewType 相关方法。
    - MimeType 接口在获取 mimeType 信息时改为优先框架内的数据，如果框架内数据招不到在到 context 上查找。
**DB**
    - mybatis 插件回归 hasor-db
**tConsole**
    - 重构，对于多行输入支持用户自定义命令结符号or字符串。重构后单测覆盖率达到 90%。
    - 支持 server 模式通过 Socket 端口运行
    - 支持 基于标准输入输出流运行
    - hasor-boot 能力被完完全全整合，因此 Hasor 将不在提供 hasor-boot。
**DataQL**
    - 重构，放弃 javacc 更换成 antlr4。antlr4 更加智能。AST 模型仍然不变。重构后单测覆盖率达到 90%。
    - DataQL 大量新语法新特性。具体参看语法参考手册。一些老的语法形式也不在支持，因此 DataQL 的语法和以前有明显变化。
    - 运行时内存模型：确定为 两栈一堆
    - 指令集系统：不在需要 ASM、ASA、ASO 三个指令，取而代之的是更严谨的指令集。
    - SDK：函数包能力
    - DataModel数据模型：增加 unwrap 方法，用来解开 DataModel 包裹
    - 新增 Fragment 机制允许 DataQL 执行外部非 DataQL 语法的代码片段。
    - BeanContainer 改为 Finder，删掉 UdfSource、UdfManager、UdfResult 不在需要这些概念。
    - 原有 dql test case 语句文件统一转移到 _old 目录下面备用。
**RSF**
    - rsf 使用 tconsole 的新接口
    - 注册中心暂不可用，下几个版本会重新设计。
    - rsf 的 InterAddress 支持域名传入，但是toString 的时仍然会转换为 ip。
**其它**
    - 删除 Hasor 默认提供的 JFinal 插件支持。理由是 JFinal 功能和 Hasor 体系重叠，同时 Hasor 的所有功能都是独立。
    - 整合 Hasor 及其容易因此没有提供集成代码的必要。
    - 新增 Hasor-all 包。

Hasor v4.0.6 (2019-05-31)
------------------------------------
**改进**
    - getInstance、getProvider 新增 param 参数以支持构造方法入参。
    - tConsole 接口调整。

Hasor v4.0.5 (2019-05-27)
------------------------------------
**重要**
    - 4.0.0版本新增的 Hasor-Boot 项目不在单独存在，理由 Hasor 可以很好的在 Spring Boot 上运行和部署，因此并无任何必要在重复构建相同功能。
    - Boot 的机制融入到AppContext 接口的两个 join、joinSignal 新增方法中，不在单独设立 Hasor Boot 启动器。
    - 删除 @IgnoreParam 注解，@ParameterForm 注解更名为 @ParameterGroup。
**新增**
    - 新增 @Destroy 注解 @PreDestroy 注解支持，可以配置当容器停止时调用的方法。
    - binder 可以声明 Destroy 方法了，要想使用 Destroy 的Bean 必须是单例的。
    - Web请求中 ServletContext 可以作为特殊类型注入进来了。
    - AppContext 新增 join、joinSignal 两个方法。
**改进**
    - 标记了 @ParameterForm 的参数对象会执行 inject。
    - ApiBinder 的 installModule 支持数组入参了。
    - Hasor 类的工具方法拆分到 HasorUtils 中。
    - Hasor.assertIsNotNull 方法使用 Objects 相关的方法进行替代。

Hasor v4.0.4 (2019-05-22)
------------------------------------
**新增**
    - Environment 接口新增 getVariableNames、getVariable 两个方法方便获取环境变量。
**改进**
    - Environment 接口的 removeEnvVar 方法更名为 removeVariable
    - Environment 接口的 addEnvVar 方法更名为 addVariable
**修复**
    - 修复了 WebApiBinder 接口 loadRender 方法
    - 修复 RenderWebPlugin NPE 的问题。

Hasor v4.0.3 (2019-05-17)
------------------------------------
**修复**
    - 删除默认配置文件中 net.hasor.web.valid.ValidWebPlugin，插件的配置，该插件已经不存在但是遗留了一个配置导致启动报错。

Hasor v4.0.2 (2019-05-17)
------------------------------------
**修复**
    - fix 当@ParameterForm、@HeaderParameter 和其它注解组合使用时候，发现参数丢失问题。
**改进**
    - 优化验证框架。
    - 删除了 WebPlugin 机制。


Hasor v4.0.1 (2019-05-12)
------------------------------------
**Web**
    - BeanContainer 增加当配置新 Bean 发生异常时自动回滚新 Bean 的能力
    - @Render 注解功能从描述URL请求尾缀，变为描述渲染器名字，同时可以执行这个渲染器使用的特殊MimeType。
    - InMapping 接口删除
    - Invoker 接口新增 ownerMapping、fillForm 方法。
    - 对应TestCase 调整。
*Boot*
    - Boot Maven插件项目不在单独设立，而是只保留一个启动器，使用时建议用户结合 SpringBoot使用更加方便。


Hasor v4.0.0 (2019-05-09)
------------------------------------
**JDK8相关 **
    - 依赖JDK版本从 jdk6 升级到 jdk8，代码层面全面迁移到 jdk8 语法并深入结合 jdk8 相关特性。
    - net.hasor.core.Matcher 接口暂时保留，但已经不在使用，已替换成 java8 提供的 java.util.function.Predicate 接口替代。
    - net.hasor.core.Provider 接口暂时保留，但已经不在使用，已替换成 java8 提供的 java.util.function.Supplier 接口替代。
    - @Aop、@MappingTo、注解迎合JDK8特性可以同时标注多个。
**新成员**
    - 新增：hasor-boot 项目和配套的 hasor-boot mavenplugin。
    - 新增：tConsole 框架，提供一个 Telnet 环境支持，给予没有界面类的应用一个可以通过命令行进行交互的工具。
**static-config.xml 和 env.config**
    - 当使用 maven-shade-plugin 进行 maven 打包时由于 static-config.xml 无法通过文件追加的方式进行简单合并。
    - 因此老版本 Hasor 的工程无法使用 maven-shade-plugin 打包。
    - 3.3.0 版本之后修改了 static-config.xml 发现机制，改为通过 /META-INF/hasor.schemas 配置文件进行发现。
    - 改进之后，使用 maven-shade-plugin 的 hasor 工程可以像处理 spring.schemas 一样处理 hasor.schemas 合并。
    - 取消 env.config 属性文件机制。
**ApiBinder**
    - ApiBinder 接口支持 inject 一个 Class 类型。
    - ApiBinder 接口中新增 asEagerSingletonClear 方法，可以用来抹除 Bean 身上配置的 @Prototype 或者 @Singleton 行为。
    - 新增 MetaInfo 接口，AppContext、BindInfo 两个接口均继承自这个接口。从而提供除了 Context 之外的第二种途径绑定环境参数。
    - 增加一组 bindToCreater 方法用户绑定 BeanCreaterListener 到 BindInfo 上，BeanCreaterListener的作用是当创建 Bean 的时候会调用这个监听器。
**Settings**
    - @InjectSettings @Inject 注解支持标注在参数上了。
    - Settings 接口增添 removeSetting 方法，可以将整个配置项的多个值全部删除。
    - 使用 Hasor 设置 mainSettings 配置文件时可以指定 Reader 类型了。
    - Hasor 类增加支持设置 setMainSettings 为 Reader 或 InputStream
    - Hasor 类增加 addSettings 用来代码方式增添配置文件。
    - 配置项 “hasor.modules.loadErrorShow” 改名为 “hasor.modules.throwLoadError”
**EventContext**
    - EventContext 接口增加异步任务方法，从现在开始可以使用异步任务了。
    - EventContext 接口 fireSyncEventWithEspecial 更名为 fireSyncEventWithAlone
    - EventContext 接口 新增 clearListener 清空监听器能力。
**Environment**
    - StandardEnvironment 增添若干构造方法，AbstractEnvironment 调整输出日志内容。
    - Environment.addEnvVar 方法在添加 环境变量时如果 Value 为空或者空字符串，其行为相当于删除。
    - Environment 接口上的一些常量定义删除（例如：WORK_HOME）
**Web**
    - MappingSetup 接口，更名为 MappingDiscoverer，MappingData更名为Mapping
    - web RuntimeListener 新增：hasor-root-module、hasor-hconfig-name、hasor-env-properties 三个 web.xml 的属性配置。
    - @HttpMethod 注解可以加到 Method 上了。
    - WebApiBinder 接口中 scanAnnoRender 方法改为 loadRender。
    - InvokerFilter、InvokerChain 拥有返回值了。
**RSF**
    - 进行重构。
    - 使用 RSF_DATA_HOME 环境变量替代 RsfEnvironment.WORK_HOME。
    - rsf的内置 hessian 序列化和反序列化配置文件，路径改到 ‘META-INF/hasor-framework/rsf-hessian/’ 下面。以避免和 hessian jar包冲突。
    - rsf Gateway 从 rsf 基础框架中删除后面会独立成一个框架。
    - rsf 地址本保存时候不在保存空数据。
**JDBC**
    - fix 执行查询结果返回为空时，AbstractRowMapper.convertValueToRequiredType 方法报 NPE 的 Bug。
    - fix JdbcTemplate 类中 requiredSingleResult 当执行结果为空时报空指针的异常。
**Bean容器**
    - BeanBuilder 接口的三个 getInstance 方法改为 getProvider 方法。
    - 新增 @ConstructorBy 注解，可以在多个构造方法中指定一个作为创建 Bean 的入口。
    - fix 包扫描 AopIgnore 注解时，如果包里面没有任何类不加载 package-info.class 的问题。
    - AopIgnore 注解新增 ignore 属性，可以用于关闭注解功能（一般用不到）。
    - fix 了 Aop 的类不支持 double, long 两种基础类型参数的问题。
    - 字节码工具 ASM 升级到 7.0 版本
    - 新增 BeanCreaterListener 接口，该接口可以用来监听 Bean 的创建。通过 ApiBinder 中 whenCreate 相关方法来配置这个接口。
**改进和优化**
    - Hasor 类新增一组 asxxxSingleton 方法，用来设定 AppContext 的单例范围（静态、线程、ClassLoader）
    - asSmaller 时会设置 HASOR_LOAD_EXTERNALBINDER 、HASOR_LOAD_MODULE 为false，调用 asSmaller 之后不会加载任何 module 和 binder 扩展。同时任何位置的 mime.types.xml 也都不会加载
    - FutureCallback 的 cancelled 方法沉降到 CancellFutureCallback 接口中。
    - Class.forName 用法改进，普遍增加 ClassLoader 参数传入。
    - BeanUtils 类的 canWriteField，修复了对 Field 为 final 的判断。
    - 新增：utils resource loader 相关工具，来源为老版本 hasor 中的工具。
    - plugin 项目新增多种 freemarker 的 loader。
    - 增加单元测试，提升代码测试覆盖率。
