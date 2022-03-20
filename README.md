# 获取天气
## URL: `/weather/{city}`

## 请求方式: `GET`

## 参数: `city`城市中文名称(无默认值)

## 返回值格式: `JSON`

## 返回值: 
`data`: object 天气数据

`data.yesterday`: object 今天的天气数据

`data.yesterday.date`: string 日期

`data.yesterday.high`: string 最高温度

`data.yesterday.fx`: string 风向

`data.yesterday.low`: string 最底温度

`data.yesterday.fl`: string 风力

`data.yesterday.type`: string 天气

`data.city`: string 城市

`data.forecast`: array(object) 未来的天气

`data.forecast.date`: string 日期

`data.forecast.high`: string 最高温度

`data.forecast.fengxiang`: string 风向

`data.forecast.low`: string 最底温度

`data.forecast.fengli`: string 风力

`data.forecast.type`: string 天气

`data.ganmao`: string 提醒

`data.wendu`: string 当前温度

`status`: int 状态码

`desc`: string 状态描述


## 实例:
request:
`/weather/上海`

response:
```json
{
    "data": {
        "yesterday": {
            "date": "19日星期六",
            "high": "高温 13℃",
            "fx": "北风",
            "low": "低温 7℃",
            "fl": "<![CDATA[3级]]>",
            "type": "阴"
        },
        "city": "上海",
        "forecast": [
            {
                "date": "20日星期天",
                "high": "高温 9℃",
                "fengli": "<![CDATA[2级]]>",
                "low": "低温 7℃",
                "fengxiang": "东北风",
                "type": "大雨"
            },
            {
                "date": "21日星期一",
                "high": "高温 8℃",
                "fengli": "<![CDATA[3级]]>",
                "low": "低温 7℃",
                "fengxiang": "东北风",
                "type": "大雨"
            },
            {
                "date": "22日星期二",
                "high": "高温 10℃",
                "fengli": "<![CDATA[3级]]>",
                "low": "低温 7℃",
                "fengxiang": "东北风",
                "type": "阴"
            },
            {
                "date": "23日星期三",
                "high": "高温 14℃",
                "fengli": "<![CDATA[2级]]>",
                "low": "低温 7℃",
                "fengxiang": "东北风",
                "type": "多云"
            },
            {
                "date": "24日星期四",
                "high": "高温 17℃",
                "fengli": "<![CDATA[3级]]>",
                "low": "低温 8℃",
                "fengxiang": "东南风",
                "type": "多云"
            }
        ],
        "ganmao": "感冒多发期，适当减少外出频率，适量补充水分，适当增减衣物。",
        "wendu": "7"
    },
    "status": 1000,
    "desc": "OK"
}
```


无默认值

# 编译成本地应用
我使用的命令: `./mvnw package -Pnative`

根目录下 `weather-1.0-SNAPSHOT-runner` 为我在自己电脑中生成的本地应用

## 环境: 

电脑: `MacBook Air(M1, 2020) MacOS 12.1`

JDK: `GraalVM 17.0.1`

Maven: `3.8.1`


# weather Project


This project uses Quarkus, the Supersonic Subatomic Java Framework.

If you want to learn more about Quarkus, please visit its website: https://quarkus.io/ .

## Running the application in dev mode

You can run your application in dev mode that enables live coding using:

```shell script
./mvnw compile quarkus:dev
```

> **_NOTE:_**  Quarkus now ships with a Dev UI, which is available in dev mode only at http://localhost:8080/q/dev/.

## Packaging and running the application

The application can be packaged using:

```shell script
./mvnw package
```

It produces the `quarkus-run.jar` file in the `target/quarkus-app/` directory. Be aware that it’s not an _über-jar_ as
the dependencies are copied into the `target/quarkus-app/lib/` directory.

The application is now runnable using `java -jar target/quarkus-app/quarkus-run.jar`.

If you want to build an _über-jar_, execute the following command:

```shell script
./mvnw package -Dquarkus.package.type=uber-jar
```

The application, packaged as an _über-jar_, is now runnable using `java -jar target/*-runner.jar`.

## Creating a native executable

You can create a native executable using:

```shell script
./mvnw package -Pnative
```

Or, if you don't have GraalVM installed, you can run the native executable build in a container using:

```shell script
./mvnw package -Pnative -Dquarkus.native.container-build=true
```

You can then execute your native executable with: `./target/weather-1.0-SNAPSHOT-runner`

If you want to learn more about building native executables, please consult https://quarkus.io/guides/maven-tooling.

## Provided Code

### RESTEasy JAX-RS

Easily start your RESTful Web Services

[Related guide section...](https://quarkus.io/guides/getting-started#the-jax-rs-resources)
