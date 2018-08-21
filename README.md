# SpringBootABC
1. [SpringBoot Mail](https://github.com/jackyLi177/SpringBootABC/tree/master/mail)
2. [SpringBoot Redis](https://github.com/jackyLi177/SpringBootABC/tree/master/redis/src/main)

   >第一步：添加spring-boot-starter-data-redis依赖   
   第二步：配置@EnableCaching开启缓存   
   第三步：在application.yml内配置Redis相关的信息
   第四步：配置@Cacheable注解完成数据缓存
 
3. [SpringBoot JWT](https://github.com/jackyLi177/SpringBootABC/tree/master/jwtdemo)
    * JWTUtil :生成token
    * 自定义拦截器验证request Header 中的token信息