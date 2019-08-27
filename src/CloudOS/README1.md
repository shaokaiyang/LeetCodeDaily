# 多组件分布式应用行为追踪演示

## 基本信息
授权协议：GPL  
操作系统：Centos  
开发语言：JAVA  
开发单位： 北京航空航天大学  
项目网站：  url
项目源码下载： url

## 项目描述
多组件分布式应用行为追踪演示项目基于PiggyMetrics分布式微服务系统（一个基于微服务的在线记账系统）进行请求链路追踪扩展，由北京航空航天大学倾力打造。
主要面向未来基于微服务的大型分布式应用，通过提供请求链路追踪库来完成对上层应用请求链路的追踪与分析，以辅助后续应用
性能优化、集群资源分配和部署优化、应用请求状态监控。目前提供请求链路追踪、请求组件图构建、关键路径分析和关键组件评估等功能，
并提供统一标准上层接口以适配不同微服务应用。

## 技术架构
1. 后端
  - 基础框架：SpringCloud,Docker,ZUUL,ELK
  - 持久层框架：mongoDB
  - 消息队列：rabbitmq
  - 缓存框架：redis
  - 日志打印：log4j
  - 其他：fastjson,quartz等

2. 开发环境
  - 语言：JAVA
  - IDE：IDEA
  - 依赖管理：Maven
  - 数据库：mongoDB
  - 缓存：redis

## 功能模块
- 请求链路追踪
- 请求组件图构建
- 关键路径分析
- 关键组件评估

## 后台开发环境和依赖
- java
- maven
- jdk8
- SpringCloud
- docker
- mongoDB

## 项目下载和运行
- 拉取项目代码
```
git clone url
```
- 编译
```
mvn clean;
mvn package;
```
- 运行
  - 镜像生成  
  ```
  gateway                latest              a532a250efa1        6 weeks ago         349 MB
  monitoring             latest              1d4485f6c5ed        6 weeks ago         352 MB
  notification-service   latest              a7b696ecf66a        6 weeks ago         355 MB
  statistics-service     latest              2464eaa4a1d7        6 weeks ago         354 MB
  account-service        latest              fb3dcff48ff4        6 weeks ago         354 MB
  auth-service           latest              1bbbc17418ff        6 weeks ago         350 MB
  account-mongo-service            latest              2b0b84d3d8a1        6 weeks ago         642 MB
  registry               latest              216c1f736617        6 weeks ago         348 MB
  config                 latest              c3e41d5ae3c7        6 weeks ago         333 MB
  rabbitmq               latest              5a8b7f36d59f        7 weeks ago         151 MB
  docker-base            latest              17a1ba013238        2 months ago        100 MB
  redis                  3                   1200574c8af9        2 months ago        366 MB
  rabbitmq               3-management        6cb6e2f951a8        2 months ago        151 MB
  statistics-mongo-service            latest              17a1ba013238        2 months ago        100 MB
  notification-mongo-service            latest              17a1ba013238        2 months ago        100 MB
  ```
  - 镜像运行
  注意：里面的192开头的ip都换成自己的ip
  1. 启动redis
  docker run -d --name redis -p 6379:6379 redis
  1. 运行rabbitmq
  docker run -d -p 5672:5672 -p 15672:15672 --name=rabbitmq rabbitmq:3-management
  <br>通过 ip:15672/ 查看是否成功启动  账号是 user 密码是 root
  2. 运行config--配置服务器
  docker run -d -p 8888:8888 -e CONFIG_SERVICE_PASSWORD=${CONFIG_SERVICE_PASSWORD} --name=config config
  <br>通过ip:8888/gateway/default 如果能读取配置文件 即成功
  3. 运行eureka -- 注册中心
  docker run -d -p 8761:8761 -e REGISTRY_PORT=8761 -e CONFIG_PORT=8888 -e CONFIG_SERVICE_PASSWORD=${CONFIG_SERVICE_PASSWORD} --add-host config:192.168.1.191 --add-host registry:192.168.1.191 --name=registry registry
  <br>通过ip:8761验证
  4. 启动auth-service
  docker run -d -p 5000:5000  -e SERVICE_PORT=5000 -e AUTH_SERVICE_PORT=5000 -e HOST_IP=192.168.1.191 -e REDIS_IP=${REDIS_IP} -e CONFIG_SERVICE_PASSWORD=${CONFIG_SERVICE_PASSWORD} -e NOTIFICATION_SERVICE_PASSWORD=${NOTIFICATION_SERVICE_PASSWORD} -e STATISTICS_SERVICE_PASSWORD=${STATISTICS_SERVICE_PASSWORD} -e ACCOUNT_SERVICE_PASSWORD=${ACCOUNT_SERVICE_PASSWORD} -e MONGODB_PASSWORD=${MONGODB_PASSWORD} --add-host config:192.168.1.191 -e CONFIG_PORT=8888 --add-host registry:192.168.1.191 -e REGISTRY_PORT=8761 --name=auth-service auth-service
  通过mongo 192.168.4.201/piggymetrics -u user -p root验证
  5. 启动account-mongo-service
  docker run -d -p 7777:7777 -e SERVICE_PORT=7777 -e HOST_IP=192.168.1.191 -e REDIS_IP=${REDIS_IP} -e CONFIG_SERVICE_PASSWORD=${CONFIG_SERVICE_PASSWORD} -e INIT_DUMP=/account-service-dump.js  -e NOTIFICATION_SERVICE_PASSWORD=${NOTIFICATION_SERVICE_PASSWORD} -e STATISTICS_SERVICE_PASSWORD=${STATISTICS_SERVICE_PASSWORD} -e ACCOUNT_SERVICE_PASSWORD=${ACCOUNT_SERVICE_PASSWORD} -e MONGODB_PASSWORD=${MONGODB_PASSWORD} --add-host config:192.168.1.191 -e CONFIG_PORT=8888 --add-host registry:192.168.1.191 -e REGISTRY_PORT=8761 --add-host rabbitmq:192.168.1.191 -e RABBITMQ_PORT=5672 --add-host auth-service:192.168.1.191 -e AUTH_SERVICE_PORT=5000 --name=account-mongo-service account-mongo-service
  <br>可通过eureka面板查看服务是否注册
  6. 启动account-service
  docker run -d -p 6000:6000 -e SERVICE_PORT=6000 -e HOST_IP=192.168.1.191  -e REDIS_IP=${REDIS_IP} -e CONFIG_SERVICE_PASSWORD=${CONFIG_SERVICE_PASSWORD} -e ACCOUNT_SERVICE_PASSWORD=${ACCOUNT_SERVICE_PASSWORD} -e MONGODB_PASSWORD=${MONGODB_PASSWORD} --add-host config:192.168.1.191 -e CONFIG_PORT=8888 --add-host registry:192.168.1.191 -e REGISTRY_PORT=8761 --add-host rabbitmq:192.168.1.191 -e RABBITMQ_PORT=5672 --add-host auth-service:192.168.1.191 -e AUTH_SERVICE_PORT=5000 --name=account-service account-service
  <br>可通过eureka面板查看服务是否注册
  12. 启动gateway
  docker run -d -p 4000:4000 -e SERVICE_PORT=4000 -e HOST_IP=192.168.1.191 -e REDIS_IP=${REDIS_IP} -e CONFIG_SERVICE_PASSWORD=${CONFIG_SERVICE_PASSWORD} --add-host config:192.168.1.191 -e CONFIG_PORT=8888 --add-host registry:192.168.1.191 -e REGISTRY_PORT=8761 --add-host auth-service:192.168.1.191 -e AUTH_SERVICE_PORT=5000 --name=gateway gateway
  <br>通过ip:4000访问
  7. 启动statistics-mongo-service
  docker run -d -p 7778:7778 -e SERVICE_PORT=7778 -e HOST_IP=192.168.1.191 -e REDIS_IP=${REDIS_IP} -e CONFIG_SERVICE_PASSWORD=${CONFIG_SERVICE_PASSWORD} -e NOTIFICATION_SERVICE_PASSWORD=${NOTIFICATION_SERVICE_PASSWORD} -e STATISTICS_SERVICE_PASSWORD=${STATISTICS_SERVICE_PASSWORD} -e ACCOUNT_SERVICE_PASSWORD=${ACCOUNT_SERVICE_PASSWORD} -e MONGODB_PASSWORD=${MONGODB_PASSWORD} --add-host config:192.168.1.191 -e CONFIG_PORT=8888 --add-host registry:192.168.1.191 -e REGISTRY_PORT=8761 --add-host rabbitmq:192.168.1.191 -e RABBITMQ_PORT=5672 --add-host auth-service:192.168.1.191 -e AUTH_SERVICE_PORT=5000 --name=statistics-mongo-service statistics-mongo-service
  <br>可通过eureka面板查看服务是否注册
  8. 启动statistics-service
  docker run -d -p 7000:7000 -e SERVICE_PORT=7000 -e HOST_IP=192.168.1.191 -e REDIS_IP=${REDIS_IP} -e CONFIG_SERVICE_PASSWORD=${CONFIG_SERVICE_PASSWORD} -e STATISTICS_SERVICE_PASSWORD=${STATISTICS_SERVICE_PASSWORD} -e MONGODB_PASSWORD=${MONGODB_PASSWORD} --add-host config:192.168.1.191 -e CONFIG_PORT=8888 --add-host registry:192.168.1.191 -e REGISTRY_PORT=8761 --add-host auth-service:192.168.1.191 -e AUTH_SERVICE_PORT=5000 --add-host rabbitmq:192.168.1.191 -e RABBITMQ_PORT=5672  --name=statistics-service statistics-service
  <br>可通过eureka面板查看服务是否注册
  9. 启动notification-mongo-service
  docker run -d -p 7779:7779 -e SERVICE_PORT=7779 -e HOST_IP=192.168.1.191 -e REDIS_IP=${REDIS_IP} -e CONFIG_SERVICE_PASSWORD=${CONFIG_SERVICE_PASSWORD} -e NOTIFICATION_SERVICE_PASSWORD=${NOTIFICATION_SERVICE_PASSWORD} -e STATISTICS_SERVICE_PASSWORD=${STATISTICS_SERVICE_PASSWORD} -e ACCOUNT_SERVICE_PASSWORD=${ACCOUNT_SERVICE_PASSWORD} -e MONGODB_PASSWORD=${MONGODB_PASSWORD} --add-host config:192.168.1.191 -e CONFIG_PORT=8888 --add-host registry:192.168.1.191 -e REGISTRY_PORT=8761 --add-host rabbitmq:192.168.1.191 -e RABBITMQ_PORT=5672 --add-host auth-service:192.168.1.191 -e AUTH_SERVICE_PORT=5000 --name=notification-mongo-service notification-mongo-service
  <br>可通过eureka面板查看服务是否注册
  10. 启动notification-service
  docker run -d -p 8000:8000 -e SERVICE_PORT=8000 -e HOST_IP=192.168.1.191 -e REDIS_IP=${REDIS_IP} -e CONFIG_SERVICE_PASSWORD=${CONFIG_SERVICE_PASSWORD} -e NOTIFICATION_SERVICE_PASSWORD=${NOTIFICATION_SERVICE_PASSWORD} -e MONGODB_PASSWORD=${MONGODB_PASSWORD} --add-host config:192.168.1.191 -e CONFIG_PORT=8888 --add-host registry:192.168.1.191 -e REGISTRY_PORT=8761 --add-host auth-service:192.168.1.191 -e AUTH_SERVICE_PORT=5000 --add-host rabbitmq:192.168.1.191 -e RABBITMQ_PORT=5672 --name=notification-service notification-service
  <br>可通过eureka面板查看服务是否注册
  11. 启动monitoring
  docker run -d -p 8989:8989 -p 8080:8080 -e HOST_IP=192.168.1.191 -e CONFIG_SERVICE_PASSWORD=${CONFIG_SERVICE_PASSWORD} --add-host config:192.168.1.191 -e CONFIG_PORT=8888  --add-host registry:192.168.1.191 -e REGISTRY_PORT=8761 --add-host rabbitmq:192.168.1.191 -e RABBITMQ_PORT=5672 --name=monitoring monitoring
  <br>通过http://192.168.1.191:8080/hystrix     在地址栏输入http://192.168.1.191:8989查看监控  

## 附件下载