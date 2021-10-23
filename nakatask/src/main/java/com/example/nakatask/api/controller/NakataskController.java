package com.example.nakatask.api.controller;

import com.example.nakatask.api.resource.CommonResponse;
import com.example.nakatask.api.resource.NakataskList;
import com.example.nakatask.api.resource.PostNakatask;
import com.example.nakatask.domain.entity.NakataskModel;

import com.example.nakatask.domain.service.NakataskService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

/**
 * Controller クラスはリソース単位に作成し、リソース毎の REST API のエンドポイント(URI)の指定を行う。
 *   リソースに対する CRUD 処理は、ドメイン層の Service に委譲する事で実現する。
 *   返却するJSON(JavaBeanクラス)へのマッピングなどもこちらで行う。
 */
@RestController
public class NakataskController {

    private final Logger LOG = LoggerFactory.getLogger(NakataskController.class);
    @Autowired
    private NakataskService nakataskService;

    /**
     * タスクデータの取得　API
     * @return タスクデータ
     */
    @GetMapping("/nakatask")
    public ResponseEntity<NakataskList> getNakatask() {
        // サービスへデータの取得処理を委譲
        ArrayList<NakataskModel> nakataskModelList = nakataskService.getAll();
        // 取得したデータを、返却するJSONのためにJavaBeansにマッピング
        NakataskList nakataskList = new NakataskList();
        // データ一覧をセット
        nakataskList.setList(nakataskModelList);
        nakataskList.setCount(nakataskModelList.size());
        // データを返却
        return new ResponseEntity<NakataskList>(nakataskList, HttpStatus.OK);
    }

    /**
     * タスクの追加
     *
     * @param postData リクエスト本文(body)
     * @return 成功レスポンス
     */
    @PostMapping("/nakatask")
    public ResponseEntity<CommonResponse> postNakatask(@RequestBody PostNakatask postData){
        LOG.info("Posting Data");
        // dataModel作成
        NakataskModel nakataskModel = new NakataskModel();
        // postDataをModelにマッピング
        nakataskModel.setName(postData.getName());
        // データの投稿
        nakataskService.postTask(nakataskModel);
        //レスポンス生成
        CommonResponse response = new CommonResponse();
        response.setMessage("TASK CREATED!!!");
        return new ResponseEntity(response, HttpStatus.CREATED);
    }
}
