<p style="text-align: center;">
  <h1 align="center"><a href="javascript:void(0);">qbit-java-sdk</a></h1>
</p>

## Qbit 概念

开发者 API 旨在允许企业与 Qbit 系统集成，并轻松将其作为其工作流程的一部分。该 API 允许开发者使用【全球账户】、【量子卡】业务等。

## 项目状态

当前版本`0.0.2`为测试版本。暂时支持了auth相关的接口，其他接口带后续完善，同时也提供了Qbit Api 所需的Post、put、delete、get请求，方便使用者更好调用其他接口，具体使用请看下面代码示例。

`注意`：请商户的专业技术人员在使用时注意系统和软件的正确性和兼容性，以及带来的风险。

## 环境要求

+ Java 1.8+

## 安装

最新版本已经在 [Maven Central](https://search.maven.org/artifact/io.github.klover2/qbit-java-sdk) 发布。

#### Gradle
在你的 build.gradle 文件中加入如下的依赖

```groovy
implementation 'io.github.klover2:qbit-java-sdk:1.0.0'
```

### Maven
加入以下依赖

```xml
<dependency>
    <groupId>io.github.klover2</groupId>
    <artifactId>qbit-java-sdk</artifactId>
    <version>1.0.0</version>
</dependency>
```

## 名词解释

+ Client，合作伙伴在 Qbit 我们称之为 Client。
+ Account， 合作伙伴的客户在 Qbit 我们称之为 Account
+ clientId，商户id，请联系我们申请。
+ clientSecret，商户密钥，用于签名，请联系我们申请。

## 开始

### 获取access token

```java
AuthService service = new AuthService.Builder()
        .config("qbit1f6efee44ceb8ca2", "8f70d42a1393802aebf567be27a47879", "https://api-global.qbitnetwork.com")
        .build();

CodeRes code = service.getCode("123", "https:www.baidu.com");
System.out.println(code);

AccessTokenRes accessToken = service.getAccessToken(code.getCode());
System.out.println(accessToken);
// AccessTokenRes(accessToken=6f24940c7aa34fcd2d10da6a52f0714b007ab419, refreshToken=c7968e9bb72234ca6475b12da4db8c7a2b8108b2240413c24e0f35f00d32c560, expiresIn=86400, timestamp=1665755612, message=null)
```

### 刷新access token

```java
AuthService service = new AuthService.Builder().config("qbit1f6efee44ceb8ca2", "8f70d42a1393802aebf567be27a47879", "https://api-global.qbitnetwork.com").build();
RefreshTokenRes res = service.refreshToken("c7968e9bb72234ca6475b12da4db8c7a2b8108b2240413c24e0f35f00d32c560");
System.out.println(res);
// RefreshTokenRes(accessToken=9ce5744a00af89bf0d25f170ebd2a02ce1e88aec, expiresIn=86400, timestamp=1665755613, code=null, message=null)
```

### 调用其他接口示例

```java
// 新增预算
QbitRequestService service = new QbitRequestService.Builder().config("6f24940c7aa34fcd2d10da6a52f0714b007ab419").build();
HashMap<String, Object> map = new HashMap<>();
map.put("name", "预算名");
map.put("cost", 10);
String res = service.postRequest("https://api-global.qbitnetwork.com/open-api/v1/budget", map);
service.close(); // 如果想同时请求多个接口 这个请放在最后关闭
Map<String, Object> parse = JsonUtil.parse(res);
System.out.println(parse);
```

## 敏感信息加解密

### 加密-HmacSHA256

```java
Map<String, Object> data = new HashMap<>();
data.put("id", "ee74c872-8173-4b67-81b1-5746e7d5ab88");
data.put("accountId", null);
data.put("holderId", "d2bd6ab3-3c28-4ac7-a7c4-b7eed5eee367");
data.put("currency", "USD");
data.put("settlementCurrency", null);
data.put("counterparty", "SAILINGWOOD;;US;1800948598;;091000019");
data.put("transactionAmount", 11);
data.put("fee", 0);
data.put("businessType", "Inbound");
data.put("status", "Closed");
data.put("transactionTime", "2021-11-22T07:34:10.997Z");
data.put("transactionId", "124d3804-defa-4033-9f30-1d8b0468e506");
data.put("clientTransactionId", null);
data.put("createTime", "2021-11-22T07:34:10.997Z");
data.put("appendFee", 0);
String sign = HmacCryptoUtil.encryptHmacSHA256(data, "25d55ad283aa400af464c76d713c07ad");
        System.out.println(Objects.equals(sign, "8287d5539c03918c9de51176162c2bf7065d5a8756b014e3293be1920c20d102"));
```

## 联系我们

如果你发现了**BUG**或者有任何疑问、建议，请通过issue进行反馈。

也欢迎访问我们的[官网](https://www.qbitnetwork.com/#/)。

## Keywords

QBIT 全球账户 量子卡