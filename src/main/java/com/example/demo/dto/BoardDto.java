package com.example.demo.dto;


import lombok.Data;

import java.time.LocalDateTime;

@Data

public class BoardDto {
    public int seq;
    public String title;
    public String content;
    public LocalDateTime reg_dt;

}