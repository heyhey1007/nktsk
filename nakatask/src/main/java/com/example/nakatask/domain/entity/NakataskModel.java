package com.example.nakatask.domain.entity;

import lombok.Data;


/**
 * ドメインオブジェクトクラス
 * データモデルとも
 * Domain Objectはビジネスを行う上で必要な資源や、ビジネスを行っていく過程で発生するものを表現するモデルである。
 *
 * Mybatisを使用しDB操作を行う場合にentityとも呼ばれる
 * データベースのテーブルの1レコードを表現するクラスであるEntityは、Domain Objectである。
 * DAO/DTOパターン
 */
@Data
public class NakataskModel {
    //  DBに格納するデータの1レコードを表現する
    // id
    public int id;
    // name
    public String name;
}
