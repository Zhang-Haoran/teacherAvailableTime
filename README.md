

# Spring Boot 后端知识点


## 关于Java基础 - 2天

1. Java 8的代码
    - (https://www.runoob.com/java/java8-new-features.html)
    - Lambda 表达式 − Lambda 允许把函数作为一个方法的参数（函数作为参数传递到方法中）。
    - 方法引用 − 方法引用提供了非常有用的语法，可以直接引用已有Java类或对象（实例）的方法或构造器。与lambda联合使用，方法引用可以使语言的构造更紧凑简洁，减少冗余代码
2. lambda 表达式
    - (https://www.runoob.com/java/java8-lambda-expressions.html)
    - Lambda 表达式，也可称为闭包，它是推动 Java 8 发布的最重要新特性。
      Lambda 允许把函数作为一个方法的参数（函数作为参数传递进方法中）
      

## 关于spring - 20天
1. Spring 基本概念
    - (https://juejin.cn/post/6844903826076467207)
    - Spring框架是一个为Java应用程序的开发提供了综合、广泛的基础性支持的Java平台。Spring帮助开发者解决了开发中基础性的问题，使得开发人员可以专注于应用程序的开发
2. jpa
    - (https://spring.io/projects/spring-data-jpa)
    - (https://www.w3cschool.cn/article/1946cee4c53df8.html#:~:text=JPA%20(Java%20Persistence%20API)%20%E6%98%AF,%E5%BA%94%E7%94%A8%E4%B8%AD%E7%9A%84%E5%85%B3%E7%B3%BB%E6%95%B0%E6%8D%AE%E3%80%82)
    - (https://segmentfault.com/a/1190000037755804)
    - JPA (Java Persistence API) 是 Sun 官方提出的 Java 持久化规范。它为 Java 开发人员提供了一种对象/关联映射工具来管理 Java 应用中的关系数据。
    - 关系表的映射关系，并将运行期的实体对象持久化到数据库中
    - 实体类 Repository接口 Controller
3. Spring Security
    - (https://spring.io/projects/spring-security)
    - (https://www.jianshu.com/p/08cc28921fd0)
    - Spring Security，是一个基于Spring AOP和Servlet过滤器的安全框架
4. AOP 前置通知，后置增强，最终通知，抛出异常通知
    - (https://codeantenna.com/a/xajFBUvMoG)
    - ⾯面向切⾯面编程是⾯面向对象编程的有益补充。aop是将那些与业务⽆无关，却为业务模块所
      共同调⽤用的逻辑或责任进⾏行行封装。
    - 需要在分析项目功能时，找出切面。
      合理的安排切面的执行时间（在目标方法前， 还是目标方法后）
      合理的安全切面执行的位置，在哪个类，哪个方法增加增强功能
    - @Before：前置通知注解 表示切面的执行时间 ，使用的before注解。
    - @AfterReturning:后置通知 在目标方法之后执行的
    - @AfterThorwing 异常通知注解
      在目标方法抛出异常时执行的，通过Exception类型的参数，能够获取到异常信息
    - @After 最终通知
      总是会被执行
    
5. 自定义注解
    - (https://segmentfault.com/a/1190000038145897)
    - 注解可以理解为就是一个标识。可以在程序代码中的关键节点上打上这些标识，它不会改变原有代码的执行逻辑
    - 自定义注解使用的基本流程： 定义注解 --> 根据业务进行创建。 使用注解 --> 在相应的代码中进行使用。 解析注解 --> 在编译期或运行时检测到标记，并进行特殊操作。
6. springDoc(swagger)
    - (https://blog.csdn.net/itguangit/article/details/78978296)
    - 通过注解方式写API文档
7. Servlet
    - (https://zhuanlan.zhihu.com/p/65036564)
    - (https://xie.infoq.cn/article/802a66e879ac3774c3464b932)
    - Spring Boot支持内嵌的Tomcat服务器(Tomcat 作为 web 容器)，多数开发者只需要使用合适的'Starter'来获取一个完全配置好的实例即可，内嵌服务器默认监听8080端口的HTTP请求。
    - 使用内嵌servlet容器时，你可以通过使用Spring beans或扫描Servlet组件的方式注册Servlets，Filters及特定Servlet相关的所有listeners（比如HttpSessionListener）。
    - 将Servlets，Filters和listeners注册为Spring beans.常见的Servlet容器配置可以通过Spring Environment进行设置
    - Servlet 就是真正的负责请求、响应的
    - Servlet 根据请求对象（HttpServletRequest）的信息决定如何处理， 通过响应对象（HttpServletResponse）来创建响应。
    - 将IoC容器管理理的对象称为Bean
    

## 关于消息队列 - 5天
1. 消息队列
    - (https://zh.wikipedia.org/wiki/%E6%B6%88%E6%81%AF%E9%98%9F%E5%88%97)
    - 消息队列提供了异步的通信协议
    - 是一种进程间通信或同一进程的不同线程间的通信方式
2. rabbitmq
    - (https://www.rabbitmq.com/)
    - (http://www.ityouknow.com/springboot/2016/11/30/spring-boot-rabbitMQ.html)
    - RabbitMQ 是实现 AMQP（高级消息队列协议）的消息中间件的一种,用于在分布式系统中存储转发消息.
    - RabbitMQ 主要是为了实现系统之间的双向解耦而实现的。当生产者大量产生数据时，消费者无法快速消费，那么需要一个中间层。保存这个数据。
3.  Kafka
    - (https://spring.io/projects/spring-kafka)
    - (https://www.liaoxuefeng.com/wiki/1252599548343744/1282388443267106)
    - Kafka也是一个消息服务器，它的特点一是快，二是有巨大的吞吐量
    

## 关于测试 - 2天
1. Junit单元测试
    - (https://juejin.cn/post/6844903778957656071)
    - JUnit 是一个 Java 编程语言的单元测试框架


## 关于项目打包与部署 - 14天 
1. ssh
    - (https://www.baeldung.com/java-ssh-connection)
    - 是一种网络协议，它允许一台计算机通过不安全的网络安全地连接到另一台计算机。JSch是 SSH2 的 Java 实现，它允许我们连接到 SSH 服务器。创建一个客户端会话并将其配置为连接到我们的 SSH 服务器。然后，我们创建一个用于与 SSH 服务器通信的客户端通道，在该通道中我们提供了一个通道类型——在本例中为exec，这意味着我们将向服务器传递 shell 命令
2. redis
    - (https://juejin.cn/post/6844903962504609805)
    - Redis 是目前使用的非常广泛的免费开源内存数据库，是一个高性能的 key-value 数据库
    - Redis 支持数据的持久化，它可以将内存中的数据保存在磁盘中，重启的时候可以再次加载进行使用。
    - Redis 不仅仅支持简单的 key-value 类型的数据，同时还提供 list，set，zset，hash 等数据结构的存储。
    - Redis 支持数据的备份，即 master-slave 模式的数据备份。
3. ehcache
    - (https://www.ehcache.org/)
    - 最广泛使用的基于 Java 的缓存
4. maven
    - (https://maven.apache.org/)
    - (https://blog.csdn.net/soulmate_P/article/details/80780406)
    - maven是一个跨平台的项目管理工具。 它是Apache的一个开源项目，主要服务于基于Java平台的项目构建
5. docker
    - (https://docs.docker.com/)
    - 环境打包工具
6. k8s
    - (https://kubernetes.io/)
    - (https://zhuanlan.zhihu.com/p/29232090)  
    - 真实的生产环境应用会包含多个容器，而这些容器还很可能会跨越多个服务器主机部署。Kubernetes 提供了为那些工作负载大规模部署容器的编排与管理能力
    

## 关于搜索服务器 - 14天
1. ShardingSphere
    - (https://shardingsphere.apache.org/)
    - (https://www.jianshu.com/p/0238ff53c6bb?utm_campaign=maleskine&utm_content=note&utm_medium=seo_notes&utm_source=recommendation)
    - ShardingSphere是一套开源的分布式数据库中间件解决方案组成的生态圈。
      它由Sharding-JDBC、Sharding-Proxy和Sharding-Sidecar（计划中）这3款相互独立的产品组成，shardingSphere定位为关系型数据库中间件。
2. minio
    - (https://min.io/)
    - (https://www.jianshu.com/p/68ac0477291d)
    - Minio是Apache License v2.0下发布的对象存储服务器。它与Amazon S3云存储服务兼容。它最适合存储非结构化数据，如照片，视频，日志文件，备份和容器/ VM映像。对象的大小可以从几KB到最大5TB
      Minio服务器足够轻，可以与应用程序堆栈捆绑在一起，类似于NodeJS，Redis和
3. Apache solr
    - (https://solr.apache.org/)
    - (https://www.jianshu.com/p/03b1199dec2c)
    - Solr是Apache下的一个顶级开源项目，采用Java开发，它是基于Lucene的全文搜索服务器
    - 全文检索技术 在一些大型门户网站、电子商务网站等都需要站内搜索功能 使用传统的数据库查询方式实现搜索无法满足一些高级的搜索需求，比如：搜索速度要快、搜索结果按相关度排序、搜索内容格式不固定等，这里就需要使用全文检索技术实现搜索功能

4. elasticsearch柔搜索
    - (https://zhuanlan.zhihu.com/p/266575220)
    - ElasticSearch 就是一个搜索框架。对于搜索这个词我们并不陌生，当我们输入关键词后，返回含有该关键词的所有信息结果
    - 数据库做搜索存在着许多弊端，例如： 存储问题：当数据量大的时候就必须进行分库分表
    - 是使用 Java 开发的，基于 Lucene、分布式、通过 Restful 方式进行交互的近实时搜索平台框架
    

## 软件设计 - 23天
1. Java 23种设计模式
    - (http://c.biancheng.net/design_pattern/)
    - (https://zhuanlan.zhihu.com/p/128145128)
    - 设计模式的六大原则（SOLID）
    - 设计模式的三大类
        - 创建型模式（Creational Pattern）：对类的实例化过程进行了抽象，能够将软件模块中对象的创建和对象的使用分离。
          （5种）工厂模式、抽象工厂模式、单例模式、建造者模式、原型模式
        - 结构型模式（Structural Pattern）：关注于对象的组成以及对象之间的依赖关系，描述如何将类或者对象结合在一起形成更大的结构，就像搭积木，可以通过简单积木的组合形成复杂的、功能更为强大的结构。
          （7种）适配器模式、装饰者模式、代理模式、外观模式、桥接模式、组合模式、享元模式
        - 行为型模式（Behavioral Pattern）：关注于对象的行为问题，是对在不同的对象之间划分责任和算法的抽象化；不仅仅关注类和对象的结构，而且重点关注它们之间的相互作用。
          （11种）策略模式、模板方法模式、观察者模式、迭代器模式、责任链模式、命令模式、备忘录模式、状态模式、访问者模式、中介者模式、解释器模式
2. 悲观锁
    - (https://zhuanlan.zhihu.com/p/40211594)
    - 总是假设最坏的情况，每次去拿数据的时候都认为别人会修改，所以每次在拿数据的时候都会上锁，这样别人想拿这个数据就会阻塞直到它拿到锁（共享资源每次只给一个线程使用，其它线程阻塞，用完后再把资源转让给其它线程
3. 乐观锁
    - (https://zhuanlan.zhihu.com/p/40211594)
      总是假设最好的情况，每次去拿数据的时候都认为别人不会修改，所以不会上锁，但是在更新的时候会判断一下在此期间别人有没有去更新这个数据。乐观锁适用于多读的应用类型，这样可以提高吞吐量.
    - 大多数情况用悲观锁  
4. OAuth2
    - (https://developer.okta.com/blog/2017/06/21/what-the-heck-is-oauth)
    - (https://zhuanlan.zhihu.com/p/92051359)
    - OAuth 2.0是一个业界标准的授权协议，其定义了四种可以适用于各种应用场景的授权交互模式：授权码模式、应用授信模式、用户授信模式、简化模式