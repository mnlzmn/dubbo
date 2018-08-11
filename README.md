# dubbo
dubbo+spring整合
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
```
