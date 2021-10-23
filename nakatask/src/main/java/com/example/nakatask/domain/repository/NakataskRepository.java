package com.example.nakatask.domain.repository;

import com.example.nakatask.domain.entity.NakataskModel;
import org.apache.ibatis.annotations.*;

import java.util.ArrayList;
import java.util.Optional;

@Mapper
public interface NakataskRepository {
    /**
     * Domain Objectのコレクションのような位置づけであり、Domain Objectの問い合わせや、作成、更新、削除のようなCRUD処理を担う。
     *
     * この層では、インタフェースのみ定義する。
     *
     * 実体はインフラストラクチャ層のRepositoryImplで実装するため、 どのようなデータアクセスが行われているかについての情報は持たない。
     *
     * 実際の実装はmybatisがビルド時に構成する
     *
     * @return
     */
    @Results(id = "nakataskModel", value = {
            @Result(id = true, property = "id", column = "id"),
            @Result(id = true, property = "name", column = "name")
    })
    @Select("SELECT * FROM nakatask")
    ArrayList<NakataskModel> findAll();

    @Insert("INSERT INTO nakatask (name) value (#{name})")
    void postTask(NakataskModel nakataskEntity);

    @Select("SELECT * FROM nakatask limit 1")
    Optional<NakataskModel> getOne();
}
