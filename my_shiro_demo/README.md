如上代码参照借鉴于 https://github.com/xuyulong2017/my-java-demo/tree/master/spring-boot-security-demo

### springSecurity项目

    使用的用户的密码：123456

#### 技术及版本

      springboot ： 2.2.5   
      mysql ：    
      shiro ：  1.4.0 
      MyBatis-Plus: 3.1.0
      jdk：1.8  
      
#### 分支  

    1.master 只是使用spring Security
    2.jwt  加上jwt的使用
  
#### 项目结构
  
      ├── config   
      |     ├── ShiroConfig  shiro的核心配置
      |     ├── ShiroRealm    自定义身份验证和权限验证
      |     └── ShiroSessionManager   （暂时未用）
      |     
      ├── constant 常量类
      |       ├── ResultData  定义controller返回值
      |       └── RetCode 定义失败和成功的返回code
      │  
      ├── controller 控制层
      |     ├── info  测试权限接口信息
      |     ├── login   登录接口
      |     └── register  注册接口
      |
      ├──  dao mapper层使用
      ├── entity 实体类
      |     └── DTO 传输层
      |
      ├── exception 全局异常处理
      |     
      ├── service 业务层 
      ├── utils 工具类
      |     ├── ShiroUtils  获取当前的用户登录相关信息
      |     ├── SpringUtils   获取指定的bean
      |     └── EncryptionUtil  注册使用的工具加密密码
      
      
  

### sql文件  

- user 用户表
- role 角色表
- user_role 用户角色表
- auth 权限表
- role_auth 角色权限表

### 测试  

1.注册账号,访问 localhost:8764/register/userRegister ,传递username和password    
2.登录 访问 localhost:8764/login/userLogin ,该请求可匿名访问 username和password        
3.注销账号 访问 localhost:8764/login/getLogout   
4.访问权限接口 localhost:8764/userInfo/* 
