package com.example.nakatask.domain.service;

import com.example.nakatask.application.resource.Nakatask;
import com.example.nakatask.application.resource.PostNakatask;
import com.example.nakatask.domain.repository.NakataskModel;
import com.example.nakatask.domain.repository.NakataskRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class NakataskService {

    private final Logger LOG = LoggerFactory.getLogger(NakataskService.class);
    @Autowired
    NakataskRepository nakataskRepository;

    public Nakatask getAll() {
        List<NakataskModel> tasks = nakataskRepository.findAll();
        LOG.info(tasks.toString());
        Nakatask nakatask = new Nakatask();
        nakatask.setList((ArrayList<NakataskModel>) tasks);
        nakatask.setCount(tasks.size());
        return nakatask;
    }

    public void postTask(PostNakatask postData) {
        NakataskModel nakataskModel = new NakataskModel();
        nakataskModel.setName(postData.getName());
        nakataskRepository.postTask(nakataskModel);
    }
}
