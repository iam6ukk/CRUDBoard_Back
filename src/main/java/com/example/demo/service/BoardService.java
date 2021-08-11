package com.example.demo.service;

import com.example.demo.dto.BoardDto;

import java.util.List;

public interface BoardService {

    // 페이지
    List<BoardDto> listBoard(int page, int pageSize);
}
