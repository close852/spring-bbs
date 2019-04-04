package com.cjhm.board.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cjhm.board.domain.Board;

/**
 * Created by KimYJ on 2017-07-12.
 */
@Repository
public interface BoardRepository extends JpaRepository<Board, Long> {
	
	List<Board> findAllByCategoryIdAndUseYn(Long categoryId,String useYn);
	List<Board> findAllByUseYn(String useYn);
}
