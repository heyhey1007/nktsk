package com.example.nakatask.domain.repository;

import com.example.nakatask.application.resource.Nakatask;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Optional;

@Mapper
public interface NakataskRepository {
    @Results(id = "nakataskModel", value = {
            @Result(id = true, property = "id", column = "id"),
            @Result(id = true, property = "name", column = "name")
    })
    @Select("SELECT * FROM nakatask")
    List<NakataskModel> findAll();

    @Insert("INSERT INTO nakatask (name) value (#{name})")
    void postTask(NakataskModel nakataskEntity);

    @Select("SELECT * FROM nakatask limit 1")
    Optional<NakataskModel> getOne();
}
