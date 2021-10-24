package com.example.nakatask.domain.service;

import com.example.nakatask.domain.entity.NakataskModel;
import com.example.nakatask.domain.repository.NakataskRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

/**
 * 業務処理を提供する。
 * 実装内容は主にデータソース(今回はDB)に対するCRUD処理など
 * ほかにも例えば画像のアップロードなど、、
 */
@Service
public class NakataskServiceImpl implements NakataskService {

    private final Logger LOG = LoggerFactory.getLogger(NakataskService.class);
    @Autowired
    NakataskRepository nakataskRepository;

    @Override
    public ArrayList<NakataskModel> getAll() {
        ArrayList<NakataskModel> tasks = nakataskRepository.findAll();
        return tasks;
    }

    @Override
    public void postTask(NakataskModel postDataModel) {
        // インサート処理を実行
        nakataskRepository.postTask(postDataModel);
    }
}
