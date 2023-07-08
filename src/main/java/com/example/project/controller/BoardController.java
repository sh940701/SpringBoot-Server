package com.example.project.controller;

import com.example.project.model.Board;
import com.example.project.repository.BoardRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/board")
@Api(tags = "Board API")
public class BoardController {

    @Autowired
    private BoardRepository boardRepository;

    @GetMapping("/")
    @ApiOperation("게시글 목록 조회")
    public List<Board> getBoardList() {
        return boardRepository.findAll();
    }

    @GetMapping("/{id}")
    @ApiOperation("게시글 상세 조회")
    public Optional<Board> getBoardDetail(@PathVariable("id") String id) {
        return boardRepository.findById(id);
    }

    @PostMapping("/")
    @ApiOperation("게시글 작성")
    public Board createBoard(@RequestBody Board board) {
        return boardRepository.save(board);
    }

    @PutMapping("/{id}")
    @ApiOperation("게시글 수정")
    public Optional<Board> updateBoard(@PathVariable("id") String id, @RequestBody Board updatedBoard) {
        Optional<Board> optionalBoard = boardRepository.findById(id);
        if (optionalBoard.isPresent()) {
            Board board = optionalBoard.get();
            board.setTitle(updatedBoard.getTitle());
            board.setContent(updatedBoard.getContent());
            return Optional.of(boardRepository.save(board));
        } else {
            return Optional.empty();
        }
    }

    @DeleteMapping("/{id}")
    @ApiOperation("게시글 삭제")
    public void deleteBoard(@PathVariable("id") String id) {
        boardRepository.deleteById(id);
    }
}
