package com.cjhm.bbs.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cjhm.bbs.domain.BBS;
import com.cjhm.bbs.domain.User;

/**
 * Created by KimYJ on 2017-07-12.
 */
@Repository
public interface BBSRepository extends JpaRepository<BBS, Long> {
    BBS findByUser(User user);
}
