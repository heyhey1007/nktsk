package com.example.nakatask.api.controller;

import com.example.nakatask.api.resource.NakataskList;
import com.example.nakatask.domain.entity.NakataskModel;
import com.example.nakatask.domain.service.NakataskService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
@TestInstance(TestInstance.Lifecycle.PER_METHOD)
class NakataskControllerTest {
    @Mock
    private NakataskService nakataskService;

    @InjectMocks
    private NakataskController nakataskController;

    private AutoCloseable closeable;

    private final int GET_DATA_COUNT = 5;

    @BeforeEach
    void setUp() {
        closeable = MockitoAnnotations.openMocks(this);
    }

    @AfterEach
    void tearDown() throws Exception {
        closeable.close();
    }

    @Test
    void 取得データのデータ数が一致しているか確認() throws Exception {
        // mockで返却するデータを作成
        ArrayList<NakataskModel> nakataskModelArrayList = new ArrayList<>();
        for (int i = 0; i < GET_DATA_COUNT; i++) {
            NakataskModel nakatask = new NakataskModel();
            nakatask.setId(i);
            nakatask.setName("task" + i);
            nakataskModelArrayList.add(nakatask);
        }
        // mockの振る舞いを定義
        // getAllが呼ばれたとき作成した結果データを返却する
        when(nakataskService.getAll())
                .thenReturn(nakataskModelArrayList);

        // test
        NakataskList nakataskList = nakataskController
                .getNakatask()
                .getBody();
        // データ数の確認
        assertEquals(nakataskList.getCount(), GET_DATA_COUNT);
    }

    void 取得データがnullでないこと() throws Exception {
        // mockで返却するデータを作成
        ArrayList<NakataskModel> nakataskModelArrayList = new ArrayList<>();
        for (int i = 0; i < GET_DATA_COUNT; i++) {
            NakataskModel nakatask = new NakataskModel();
            nakatask.setId(i);
            nakatask.setName("task" + i);
            nakataskModelArrayList.add(nakatask);
        }
        // mockの振る舞いを定義
        when(nakataskService.getAll())
                .thenReturn(nakataskModelArrayList);
        // test
        NakataskList nakataskList = nakataskController
                .getNakatask()
                .getBody();
        // データnullチェック
        assertNotNull(nakataskList.list);
    }


}