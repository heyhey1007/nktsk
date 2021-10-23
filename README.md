## 概要

[Spring Initializr](https://start.spring.io/) から作成

- Maven
- java 8
- 依存ライブラリ
  - mybatis
  - spring web
  - lombok
  - mysql driver

## アーキテクチャ

Application
domain
![image](https://user-images.githubusercontent.com/54203719/138185560-89b0c99f-7e5d-470c-82c3-546d67cc95cf.png)

![image](https://user-images.githubusercontent.com/54203719/138185503-0c6adc1a-8653-4f93-b409-2d8f75665fa3.png)

## DI について

### Dependency Injection(DI)

依存性の注入
「プログラムが別のプログラムの「メソッドの実装やインスタンス変数」に依存している」状態を解決し、保守・テストがしやすいよう疎結合を保つための仕組み

## 参考資料

TERASOLUNA Server Framework for Java (5.x) Development Guideline 5.7.0.RELEASE documentation
http://terasolunaorg.github.io/guideline/current/ja/ArchitectureInDetail/WebServiceDetail/REST.html#restaboutresourceorientedarchitecture

spring-guides/gs-rest-service  
https://github.com/spring-guides/gs-rest-service/blob/main/complete/src/main/java/com/example/restservice/GreetingController.java

kazuki43zoo/qiita-materials  
https://github.com/kazuki43zoo/qiita-materials

javabycode/spring-mvc-4-restful-web-service-crud-example
https://github.com/javabycode/spring-mvc-4-restful-web-service-crud-example/tree/master/src/main/java/com/javabycode

依存性の注入(DI)について解説してみる  
https://www.w2solution.co.jp/tech/2021/10/06/eg_ns_rs_izonseinotyunyu/
