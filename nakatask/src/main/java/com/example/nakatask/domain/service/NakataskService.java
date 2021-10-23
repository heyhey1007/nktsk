package com.example.nakatask.domain.service;

import com.example.nakatask.domain.entity.NakataskModel;

import java.util.ArrayList;

/**
 * サービスが実装するインターフェース
 *
 * これによりserviceとcontrollerが疎結合となり
 * Dependency Injectionを実現
 *
 * DIにより、プログラムは保守・テストが容易となる。
 */
public interface NakataskService {
    ArrayList<NakataskModel> getAll();
    void postTask(NakataskModel postDataModel);
}
