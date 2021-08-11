package com.example.demo.service;

import com.example.demo.dto.BoardDto;

import java.util.List;

public interface BoardService {
    List<BoardDto> listBoard(int page, int pageSize);
}
