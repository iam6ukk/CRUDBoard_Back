package com.example.demo.controller;

import com.example.demo.dto.BoardDto;
import com.example.demo.mappper.BoardMapper;
import com.example.demo.service.BoardService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
// cors 문제 해결하기 위해
@RequestMapping(value = "/api")
@RestController
public class BoardController {

    @Autowired
    private BoardMapper boardMapper;

    @Resource
    private BoardService boardService;

//    // 게시글 목록
//    @GetMapping("/board")
//    public List<BoardDto> selectBoardList() {
//        return boardMapper.selectBoardList();
//        // boardMapper의 selectBoardList 함수 호출, 결과 반환
//    }

    @GetMapping("/board")
    public PageInfo<BoardDto> listBoard(
            @RequestParam(value="p_num", required = false, defaultValue = "1") int page){
        List<BoardDto> result = boardService.listBoard(page, 5);
        PageInfo<BoardDto> pi = new PageInfo<BoardDto>(result);
        return pi;
    }



    // 게시글 작성
    @PostMapping("/board")
    void insertBoard(@RequestBody BoardDto board) {
        boardMapper.insertBoard(board);
        // RequestBody 값 받아 insertBoard 함수 호출
    }

    // 게시글 상세
    @GetMapping("/board/{seq}")
    public BoardDto selectBoardDetail(@PathVariable int seq) {
        BoardDto selectBoardDetail = boardMapper.selectBoardDetail(seq);
        return selectBoardDetail;
        // PathVariable로 경로의 seq를 받아옴
        // seq를 매개로 selectBoardDetail 함수 호출, 결과 selectBoardDetail 변수에 저장
        // selectBoardDetail 반환
    }

    // 게시글 수정
    @PutMapping("/board/{seq}")
    public void updateBoard(@PathVariable int seq, @RequestBody BoardDto board) {
        BoardDto updateBoard = board;
        // RequestBody의 값을 updateBoard 변수에 저장
        updateBoard.setSeq(seq);
        // 경로의 seq값 updateBoard에 set
        System.out.println("파라미터확인 => "+ board);
        System.out.println("update => " + updateBoard);
        // 콘솔에 데이터 확인
        updateBoard.setTitle(board.getTitle());
        updateBoard.setContent(board.getContent());
        // board의 title과 content값 가져와서 updateBoard에 set

        boardMapper.updateBoard(updateBoard);
        // updateBoard 함수 호출
    }

    // 게시글 삭제
    @DeleteMapping("/board/{seq}")
    public void deleteBoard(@PathVariable int seq) {
        boardMapper.deleteBoard(seq);
        // Pathvariable로 경로의 seq를 받아옴
        // seq를 매개로 deleteBoard 함수 호출
    }
}



// JPA
//    // 전체 게시글 목록 가져옴
//    @GetMapping("/board")
//    public List<Board> getBoardList() {
//        return boardService.getAllBoard();
//        // boardService의 getAllBoard 함수 호출 해 결과 반환
//    }
//
//    // 게시글 목록 생성
//    @PostMapping("/board")
//    public Board creatBoard(@RequestBody Board board){
//        // http RequestBody를 객체로 변환시켜줌
//        return boardService.createBoard(board);
//        // boardService의 createBoard 함수 호출 해 결과 반환
//    }
//
//    // 게시글 상세
//    @GetMapping("/board/{seq}")
//    public ResponseEntity<Board> getBoardBySeq(
//            @PathVariable Integer seq) {
//            //경로를 통해 변수를 받아옴 -> seq
//        // ResponseEntity: 사용자의 httpRequest에 대한 데이터를 포함하는 클래스
//        return boardService.getBoard(seq);
//        // boardService의 getBoard 함수 호출 해 결과 반환
//        // 해당 seq의 board를 가져옴
//    }
//
//    // 게시글 수정
//    @PutMapping("/board/{seq}")
//    public ResponseEntity<Board> updateBoardBySeq(
//            @PathVariable Integer seq, @RequestBody Board board){
//        return boardService.updateBoard(seq, board);
//        // boardService의 updateBoard 함수 호출 해 결과 반환
//    }
//
//    // 게시글 삭제
//    @DeleteMapping("/board/{seq}")
//    public ResponseEntity<Map<String, Boolean>> deleteBoardBySeq(
//            @PathVariable Integer seq) {
//        return boardService.deleteBoard(seq);
//        // boardService의  deleteBoard 함수 호출 해 결과 반환
//    }

