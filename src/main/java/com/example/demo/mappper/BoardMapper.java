package com.example.demo.mappper;




import com.example.demo.dto.BoardDto;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BoardMapper {

    // 게시글 조회(1)
    List<BoardDto> selectBoardList();

    // 게시글 조회(2)
    List<BoardDto> selectBoard();


    // 게시글 작성
    void insertBoard(BoardDto board);

    // 게시글 상세
    BoardDto selectBoardDetail(int seq);

    // 게시글 수정
    void updateBoard(BoardDto board);

    // 게시글 삭제
    void deleteBoard(int seq);
}