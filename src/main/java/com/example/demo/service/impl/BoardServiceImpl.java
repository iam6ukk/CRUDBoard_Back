package com.example.demo.service.impl;

import com.example.demo.dto.BoardDto;
import com.example.demo.dto.Criteria;
import com.example.demo.mappper.BoardMapper;
import com.example.demo.service.BoardService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("boardService")
public class BoardServiceImpl implements BoardService {

   @Resource
   private BoardMapper boardMapper;

   @Override
   public List<BoardDto> listBoard(int page, int pageSize) {
      List<BoardDto> result = null;

      try{
         PageHelper.startPage(page, pageSize);
         PageHelper.orderBy("seq ASC");
         result = boardMapper.selectBoard();
      } catch(Exception e){
         e.printStackTrace();
      }
      return result;
   }
}
