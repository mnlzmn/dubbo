# dubbo+spring整合
---------------------------------
## api项目

* 声明接口
```java
public interface service{}
```
---------------------------------
## provider项目:

* pom文件  
```xml
 <!--api-->
<dependency>
    <groupId>com.test</groupId>
    <artifactId>api</artifactId>
    <version>1.0-SNAPSHOT</version>
</dependency>
<!--dubbo-->
<dependency>
    <groupId>com.alibaba</groupId>
    <artifactId>dubbo</artifactId>
    <version>2.5.3</version>
    <exclusions>
        <exclusion>
            <groupId>org.springframework</groupId>
            <artifactId>spring</artifactId>
        </exclusion>
        <!--<exclusion>-->
        <!--<groupId>log4j</groupId>-->
        <!--<artifactId>log4j</artifactId>-->
        <!--</exclusion>-->
    </exclusions>
</dependency>

<!--zookeeper-->
  <dependency>
      <groupId>org.apache.zookeeper</groupId>
      <artifactId>zookeeper</artifactId>
      <exclusions>
          <exclusion>
              <groupId>org.slf4j</groupId>
              <artifactId>slf4j-log4j12</artifactId>
          </exclusion>
      </exclusions>
      <version>3.4.10</version>
 </dependency>

<!--zkclient，zookeeper注册 -->
 <dependency>
    <groupId>com.github.sgroschupf</groupId>
    <artifactId>zkclient</artifactId>
    <version>0.1</version>
 </dependency>

<!--logback，dubbo默认日志为log4j-->
<dependency>
    <groupId>ch.qos.logback</groupId>
    <artifactId>logback-classic</artifactId>
    <version>1.2.3</version>
</dependency>
```
* applicationContext.xml  
文件需要放到META-INF/spring目录下（dubbo规范）
```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xmlns:dubbo="http://code.alibabatech.com/schema/dubbo"
       xmlns:aop="http://www.springframework.org/schema/aop" xmlns:context="http://www.springframework.org/schema/context"
       xsi:schemaLocation="http://www.springframework.org/schema/beans  http://www.springframework.org/schema/beans/spring-beans.xsd
       http://www.springframework.org/schema/context http://www.springframework.org/schema/context/spring-context.xsd
       http://www.springframework.org/schema/aop http://www.springframework.org/schema/aop/spring-aop.xsd
       http://code.alibabatech.com/schema/dubbo http://code.alibabatech.com/schema/dubbo/dubbo.xsd">

    <!-- 提供方应用信息，用于计算依赖关系 -->
    <dubbo:application name="dubbo_provider" logger="slf4j"/>

    <!-- 使用zookeeper注册中心暴露服务地址 -->
    <dubbo:registry address="zookeeper://47.105.47.171:2181"/>

    <!-- 用dubbo协议在20880端口暴露服务 -->
    <dubbo:protocol name="dubbo" port="20880"/>

    <!-- 使用注解方式暴露接口 -->
    <dubbo:annotation package="com.dubbo"/>

    <!-- 加入spring注解扫描 -->
    <context:component-scan base-package="com.dubbo"/>
    <context:annotation-config/>
    <aop:aspectj-autoproxy proxy-target-class="true"/>
</beans>
```
* 接口实现
```java
import com.alibaba.dubbo.config.annotation.Service;

@service
public class ServiceImpl implements Service{}
```
* 启动
```java
public class Main {
    public static void main(String[] args) {
        com.alibaba.dubbo.container.Main.main(args);
    }
}
```

# consumer项目
* applicationContext.xml 
```
 <dubbo:application name="dubbo-consumer" logger="slf4j"/>
 <dubbo:registry address="zookeeper://47.105.47.171:2181"/>
 <dubbo:consumer check="false"/>
```

* 消费
```java
import com.alibaba.dubbo.config.annotation.Reference;

@Reference
private Service service;

```
