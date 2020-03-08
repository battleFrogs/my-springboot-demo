如上代码参照借鉴于 https://github.com/xuyulong2017/my-java-demo/tree/master/spring-boot-security-demo

### springSecurity项目

    使用的用户的密码：123456

#### 技术及版本

      springboot ： 2.2.5   
      mysql ：    
      springSecurity ：   
      MyBatis-Plus: 3.1.0
      jdk：1.8  
      
#### 分支  

    1.master 只是使用spring Security
    2.jwt  加上jwt的使用
  
#### 项目结构
  
      ├── config   
      |     ├── entity
      |     │     └── SelfUserEntity 【springSecurity】的用户实体类
      |     |
      |     ├── handler
      |     │     ├── UserAuthAccessDeniedHandler 无权限自定义返回类
      |     |     ├── UserAuthenticationEntryPointHandler 未登录自定义返回类
      |     |     ├── UserLoginFailureHandler   登录失败处理类
      |     |     ├── UserLoginSuccessHandler   登陆成功处理类
      |     |     └── UserLogoutSuccessHandler  用户注销处理类
      |     ├── filter 
      |     |     └── JWTAuthenticationTokenFilter 每次请求的jwt的权限校验
      |     | 
      |     ├── SecurityConfig  springSecurity 核心配置
      |     ├── UserAuthenticationProvider 自定义登录验证类
      |     └── UserPermissionEvaluator   自定义权限注解验证
      |     
      ├── constant 常量类
      |       ├── ResultData  定义controller返回值
      |       └── RetCode 定义失败和成功的返回code
      │  
      ├── controller 控制层
      |
      ├──  dao 
      |     ├── single 对应单独的mysql的单表
      |     └── group  对于mysql的组合查询返回的组合值
      ├── entity 实体类
      |     └── group mysql对于返回的组合实体类
      |     
      ├── service 业务层 
      |     ├── base 对应的单表的操作
      |     └── business 对应业务的操作
      ├── utils 工具类
      |     └── ResultUtils 再springSecurity上定义返回工具类
      
  

### sql文件  

- user 用户表
- role 角色表
- user_role 用户角色表
- auth 权限表
- role_auth 角色权限表

### 测试  

1.注册账号,访问 localhost:8080/register/userRegister ,传递username和password    
2.登录 访问 localhost:8080/login/userLogin ,post请求并传递 username和password ,此时会返回token值。    
2-1 登录成功后， 访问接口将通过拦截器，header上添加Authorization的token值，然后就顺利进去   
3.注销账号 访问 localhost:8080/login/userLogout   
4.访问权限接口 localhost:8080/authText/* 
