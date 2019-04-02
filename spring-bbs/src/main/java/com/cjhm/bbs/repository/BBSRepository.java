package com.cjhm.bbs.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cjhm.bbs.domain.Board;
import com.cjhm.bbs.domain.User;

/**
 * Created by KimYJ on 2017-07-12.
 */
@Repository
public interface BBSRepository extends JpaRepository<Board, Long> {
    Board findByUser(User user);
}
