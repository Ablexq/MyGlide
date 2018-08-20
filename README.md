




参考：
==

[Glide加载自签名的https图片](https://blog.csdn.net/alpha58/article/details/61934543)

[Android使用OkHttp请求自签名的https网站](https://blog.csdn.net/alpha58/article/details/61627783)

[Glide加载https图片](https://blog.csdn.net/u014752325/article/details/73217577)

[okhttp3.0忽略https证书](https://blog.csdn.net/u014752325/article/details/73185351)

[Glide加载相同URL时由于缓存无法更新图片的问题](https://blog.csdn.net/zhifanxu/article/details/78981459)

[Google推荐——Glide使用详解](https://www.jianshu.com/p/7ce7b02988a4)


很多公司考虑到安全问题，项目中都采用https加密协议进行数据传输。但是一些公司又不想花一笔钱去CA申请证书，所以就采用自签名的证书。

OkHttp默认是可以访问通过CA认证的HTTPS链接，例如百度首页也是https链接（https://www.baidu.com/）。

但是如果是你们公司自签名(即自己用keytool生成的证书，

而不是采用通过CA认证的证书)的服务器，OkHttp是无法访问的，例如访问12306网站（https://kyfw.12306.cn/otn/），会报如下错误： 

```
javax.net.ssl.SSLHandshakeException: java.security.cert.CertPathValidatorException: 
Trust anchor for certification path not found.
```

Glide默认加载http或者通过CA认证了的https图片都是没问题的，但是当加载自签名的https图片的时候也会报以上错误（证书路径验证异常）。 

HTTPS的工作原理
===

HTTPS在传输数据之前需要客户端（浏览器）与服务端（网站）之间进行一次握手，在握手过程中将确立双方加密传输数据的密码信息。握手过程的简单描述如下：

1.浏览器将自己支持的一套加密算法、HASH算法发送给网站。

2.网站从中选出一组加密算法与HASH算法，并将自己的身份信息以证书的形式发回给浏览器。证书里面包含了网站地址，加密公钥，以及证书的颁发机构等信息。

3.浏览器获得网站证书之后，开始验证证书的合法性，如果证书信任，则生成一串随机数字作为通讯过程中对称加密的秘钥。然后取出证书中的公钥，将这串数字以及HASH的结果进行加密，然后发给网站。

4.网站接收浏览器发来的数据之后，通过私钥进行解密，然后HASH校验，如果一致，则使用浏览器发来的数字串使加密一段握手消息发给浏览器。

5.浏览器解密，并HASH校验，没有问题，则握手结束。接下来的传输过程将由之前浏览器生成的随机密码并利用对称加密算法进行加密。

握手过程中如果有任何错误，都会使加密连接断开，从而阻止了隐私信息的传输。





















