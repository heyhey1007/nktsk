package com.example.nakatask.application.controller;

import com.example.nakatask.application.resource.CommonResponse;
import com.example.nakatask.application.resource.Nakatask;
import com.example.nakatask.application.resource.PostNakatask;
import com.example.nakatask.domain.service.NakataskService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.ArrayList;

@RestController
public class NakataskController {

    private final Logger LOG = LoggerFactory.getLogger(NakataskController.class);
    @Autowired
    private NakataskService nakataskService;

    @GetMapping("/nakatask")
    public ResponseEntity<Nakatask> getNakatask() {
        Nakatask nakatask = nakataskService.getAll();
        LOG.info("Get Data");
        return new ResponseEntity<Nakatask>(nakatask, HttpStatus.OK);
    }

    @PostMapping("/nakatask")
    public ResponseEntity<CommonResponse> postNakatask(@RequestBody PostNakatask postData, UriComponentsBuilder ucBuilder){
        LOG.info("Posting Data");
        nakataskService.postTask(postData);
        return new ResponseEntity(new CommonResponse(), HttpStatus.OK);
    }
}
