package com.cjhm.board.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.cjhm.board.domain.Board;
import com.cjhm.board.repository.BoardRepository;

/**
 * Created by KimYJ on 2017-07-13.
 */
@Service
public class BoardService {

    private final BoardRepository boardRepository;

    public BoardService(BoardRepository bbsRepository) {
        this.boardRepository = bbsRepository;
    }

    public Page<Board> findBoardList(Pageable pageable) {
//    	System.out.println(pageable.getPageNumber()+"/"+pageable.getPageSize()+"/"+pageable.getSort());
    	Sort defaultSort = new Sort(Direction.DESC,"idx");
        pageable = PageRequest.of(pageable.getPageNumber() <= 0 ? 0 : pageable.getPageNumber() - 1, pageable.getPageSize(),pageable.getSortOr(defaultSort));
        return boardRepository.findAll(pageable);
    }
    public List<Board> findBoardList() {
    	return boardRepository.findAllByUseYn("Y");
    }
	public List<Board> findBoardList(Long categoryId) {
    	return boardRepository.findAllByCategoryIdAndUseYn(categoryId, "Y");
	}


    public Board findBoardByIdx(Long idx) {
    	Board bbs = boardRepository.findById(idx).orElse(new Board());
        return bbs;
    }

    public Board saveAndUpdateBbs(Board board) {
        return boardRepository.save(board);
    }
    public void deleteBbs(Long idx) {
    	boardRepository.deleteById(idx);
    }

}
