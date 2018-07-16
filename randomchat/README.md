[![输开源协议](https://img.shields.io/badge/License-Apache--2.0-brightgreen.svg "Apache")](https://www.apache.org/licenses/LICENSE-2.0)

[![maven最新版本](https://maven-badges.herokuapp.com/maven-central/org.j-im/jim-server/badge.svg "maven最新版本")](https://maven-badges.herokuapp.com/maven-central/org.j-im/jim-server)
## RandomChat简介

 RandomChat 是用JAVA语言,基于t-io开发的轻量、高性能、(可能)支持百万在线用户IM，主要目标降低即时通讯门槛，快速打造低成本接入在线IM系统，通过极简洁的消息格式就可以实现多端不同协议间的消息发送如内置(Http、Websocket、Tcp自定义IM协议)等，并提供通过http协议的api接口进行消息发送无需关心接收端属于什么协议，一个消息格式搞定一切！

## 主要特点
        1、高性能(单机可支持上万人同时在线)
        2、轻量、可扩展性极强
        3、消息格式极其简洁(JSON)
        4、支持多种协议(Socket自定义IM协议、Websocket、Http),可分别独立部署。
        5、内置消息持久化(离线、历史、漫游)，保证消息可靠性，高性能存储
        6、各种丰富的API接口。
        7、零成本部署，一键启动。

## 消息格式

 **1.聊天请求消息结构** 
 ```
{
    "from": "来源ID",
    "to": "目标ID",
    "cmd":"命令码(11)int类型",
    "createTime": "消息创建时间long类型",
    "msgType": "消息类型int类型(0:text、1:image、2:voice、3:vedio、4:music、5:news)",
    "chatType":"聊天类型int类型(0:未知,1:公聊,2:私聊)",
    "group_id":"群组id仅在chatType为(1)时需要,String类型",
    "content": "内容"
}
```
请求:COMMAND_CHAT_REQ(11) 响应:COMMAND_CHAT_RESP(12)

 **2.鉴权请求消息结构** 
```
{
    "cmd":"命令码(3)int类型",
    "token": "校验码"
}
```
请求:COMMAND_AUTH_REQ(3) 响应:COMMAND_AUTH_RESP(4)

 **3.握手请求消息结构** 
```
{
    "cmd":"命令码(1)int类型",
    "hbyte":"握手1个字节"
}
```
说明:请求:COMMAND_HANDSHAKE_REQ(1) 响应:COMMAND_HANDSHAKE_RESP(2)

 **4.登录请求消息结构** 
```
{
    "cmd":"命令码(5)int类型",
    "loginname": "用户名",
    "password": "密码",
    "token": "校验码(此字段可与logingname、password共存,也可只选一种方式)"
}
```
请求:COMMAND_LOGIN_REQ(5) 响应:COMMAND_LOGIN_RESP(6)

 **5.心跳请求消息结构** 
```
{
    "cmd":"命令码(13)int类型",
    "hbbyte":"心跳1个字节"
}
```
请求:COMMAND_HEARTBEAT_REQ(13) 响应:COMMAND_HEARTBEAT_REQ(13)

 **6.关闭、退出请求消息结构** 
```
{
    "cmd":"命令码(14)int类型",
    "userid":"用户id"
}
```
请求:COMMAND_CLOSE_REQ(14) 响应:无

 **7.获取用户信息请求消息结构** 
```
{
     "cmd":"命令码(17)int类型",
     "userid":"用户id(只在type为0或是无的时候需要)",
     "type":"获取类型(0:指定用户,1:所有在线用户,2:所有用户[在线+离线])"
}
```
请求:COMMAND_GET_USER_REQ(17) 响应:COMMAND_GET_USER_RESP(18)

**8.获取用户消息请求结构** 
```
{
     "cmd":"命令码(19)int类型",
     "fromUserId":"消息发送用户id(此字段必须与userId一起使用,获取双方聊天消息),非必填",
     "userId":"当前用户id(必填字段),当只有此字段时,type必须为0，意思是获取当前用户所有离线消息(好友+群组)",
     "groupId":"群组id(此字段必须与userId一起使用,获取当前用户指定群组聊天消息),非必填",
     "beginTime":"消息区间开始时间Date毫秒数double类型,非必填",
     "endTime":"消息区间结束时间Date毫秒数double类型,非必填",
     "offset":"分页偏移量int类型，类似Limit 0,10 中的0,非必填",
     "count":"显示消息数量,类似Limit 0,10 中的10,非必填",
     "type":"消息类型(0:离线消息,1:历史消息)"
}
```
请求:COMMAND_GET_MESSAGE_REQ(19) 响应:COMMAND_GET_MESSAGE_RESP(20)

## 性能
&nbsp;&nbsp;&nbsp;极其震撼的性能，那个每秒发送500万条聊天消息，单机支持几十万人同时在线的测试当年引起了极大争议,看看t-io用户的一则测试报告吧：[ t-io 30W长连接并发压力测试报告](https://my.oschina.net/u/2369298/blog/915435)

## 使用
- 引入randomchat(快速开发自己的高性能IM服务器),在你的pom.xml中加入如下代码片段
```
 <parent>
		<groupId>org.randomchat</groupId>
		<artifactId>randomchat-parent</artifactId>
		<version>1.0.1.v20180715-RELEASE</version>
  </parent>
```

## J-IM一些截图

  Web访问地址:http://localhost:8888

  ![输入图片说明](https://gitee.com/uploads/images/2017/0922/195539_4a5d9ed4_410355.jpeg "tio-img-0.jpg")

  Http协议api调用地址:http://localhost:8888/api/message/send

  ![输入图片说明](https://gitee.com/uploads/images/2017/0830/190054_a128b214_410355.jpeg "tio-im-2.jpg")

  ![输入图片说明](https://gitee.com/uploads/images/2017/0830/190428_474270ae_410355.jpeg "tio-im-3.jpg")

## 近期发布
- 集群支持
- RandomChat开发文档编写(已完成)
- 官网开发

## 更多
更多相关信息持续关注这家伙：**[t-io不仅仅百万并发框架](https://github.com/leoyang0126/RandomChat/

## 鸣谢
[RandomChat不仅仅百万并发框架](https://github.com/leoyang0126/RandomChat/)

## 联系方式
   个人QQ:2572097002<br>
   个人Email:leoyang0126@163.com
