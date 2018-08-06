### springboot使用mongodb

##### 1. pom.xml文件加入
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-data-mongodb</artifactId>
    </dependency>
    
##### 2.application.yml文件
    spring:
        data:
            mongodb:
              uri: mongodb://(username):(password)@localhost:27017/(collection)
              #username用户名   
              #password密码  
              #collection集合，可以想象成是mysql中的表
    
##### 3.MongoTemplate 对象使用。使用方法参考源码