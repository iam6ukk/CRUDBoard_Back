package com.example.demo.service;

import com.example.demo.dto.BoardDto;
import com.example.demo.dto.Criteria;


import java.util.List;

public interface BoardService {

    List<BoardDto> listBoard(int page, int pageSize);


}
