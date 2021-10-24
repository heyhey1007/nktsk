package com.example.nakatask.domain.service;

import com.example.nakatask.domain.entity.NakataskModel;
import com.example.nakatask.domain.repository.NakataskRepository;
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

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
@TestInstance(TestInstance.Lifecycle.PER_METHOD)
class NakataskServiceImplTest {

    @Mock
    private NakataskRepository repository;

    @InjectMocks
    private NakataskServiceImpl service;

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
    void データを全件取得し返却していること() throws Exception {
        // mockで返却するデータを作成
        ArrayList<NakataskModel> nakataskModelArrayList = new ArrayList<>();
        for (int i = 0; i < GET_DATA_COUNT; i++) {
            NakataskModel nakatask = new NakataskModel();
            nakatask.setId(i);
            nakatask.setName("task" + i);
            nakataskModelArrayList.add(nakatask);
        }
        // mockの振る舞いを定義
        when(repository.findAll())
                .thenReturn(nakataskModelArrayList);

        assertEquals(nakataskModelArrayList, service.getAll());
    }


}