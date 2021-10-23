package com.example.nakatask.api.resource;


import com.example.nakatask.domain.entity.NakataskModel;
import lombok.Data;

import java.util.ArrayList;

@Data
public class NakataskList {
    public ArrayList<NakataskModel> list = new ArrayList<>();
    public Integer count = 0;
}

