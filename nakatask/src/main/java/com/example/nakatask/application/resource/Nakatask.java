package com.example.nakatask.application.resource;


import com.example.nakatask.domain.repository.NakataskModel;
import lombok.Data;

import java.util.ArrayList;

@Data
public class Nakatask {
    public ArrayList<NakataskModel> list = new ArrayList<>();
    public Integer count = 0;
}

