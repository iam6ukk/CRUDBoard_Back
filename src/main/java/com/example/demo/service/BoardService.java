package com.example.demo.service;

import com.example.demo.domain.Board;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class BoardService {

    @Autowired
    private BoardRepository boardRepository;

    public List<Board> getAllBoard() {
        return boardRepository.findAll();
    }

    public Board createBoard(Board board){
        return boardRepository.save(board);
    }

    public ResponseEntity<Board> getBoard(Integer seq){
        Board board = boardRepository.findById(seq)
                .orElseThrow(() -> new ResourceNotFoundException("Not exist Board Data by no : ["+seq+"]"));
        return ResponseEntity.ok(board);
    }

    public ResponseEntity<Board> updateBoard(
            Integer seq, Board updateBoard) {
        Board board = boardRepository.findById(seq)
                .orElseThrow(() -> new ResourceNotFoundException("Not exist Board Data by no : [" + seq + "]"));
        board.setTitle(updateBoard.getTitle());
        board.setContent(updateBoard.getContent());

        Board endUpdateBoard = boardRepository.save(board);
        return ResponseEntity.ok(endUpdateBoard);

    }

    // delete board
    public ResponseEntity<Map<String, Boolean>> deleteBoard(
            Integer seq) {
        Board board = boardRepository.findById(seq)
                .orElseThrow(() -> new ResourceNotFoundException("Not exist Board Data by no : ["+seq+"]"));

        boardRepository.delete(board);
        Map<String, Boolean> response = new HashMap<>();
        response.put("Deleted Board Data by id : ["+seq+"]", Boolean.TRUE);
        return ResponseEntity.ok(response);
    }
}