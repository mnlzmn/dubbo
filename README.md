# dubbo
dubbo+spring整合
---------------------------------
## api项目

* 声明接口
```
public interface service{}
```
---------------------------------
## provider:

* pom文件  
```xml
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
```
```
