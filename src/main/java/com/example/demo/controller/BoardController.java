package com.example.demo.controller;

import com.example.demo.domain.Board;
import com.example.demo.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.Inet4Address;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping(value = "/api")
@RestController
public class BoardController {

    @Autowired
    private BoardService boardService;

    // 전체 게시글 목록 get
    @GetMapping("/board")
    public List<Board> getBoardList() {
        return boardService.getAllBoard();
    }

    // 게시글 목록 생성
    @PostMapping("/board")
    public Board creatBoard(@RequestBody Board board){
        return boardService.createBoard(board);
    }

    // 게시글 상세
    @GetMapping("/board/{seq}")
    public ResponseEntity<Board> getBoardBySeq(
            @PathVariable Integer seq) {
        return boardService.getBoard(seq);
    }

    //게시글 수정
    @PutMapping("/board/{seq}")
    public ResponseEntity<Board> updateBoardBySeq(
            @PathVariable Integer seq, @RequestBody Board board){
        return boardService.updateBoard(seq, board);
    }

    @DeleteMapping("/board/{seq}")
    public ResponseEntity<Map<String, Boolean>> deleteBoardBySeq(
            @PathVariable Integer seq) {
        return boardService.deleteBoard(seq);
    }

}