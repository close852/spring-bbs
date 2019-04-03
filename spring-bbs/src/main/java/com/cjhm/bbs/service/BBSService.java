package com.cjhm.bbs.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.cjhm.bbs.domain.Board;
import com.cjhm.bbs.repository.BBSRepository;

/**
 * Created by KimYJ on 2017-07-13.
 */
@Service
public class BBSService {

    private final BBSRepository bbsRepository;

    public BBSService(BBSRepository bbsRepository) {
        this.bbsRepository = bbsRepository;
    }

    public Page<Board> findBbsList(Pageable pageable) {
//    	System.out.println(pageable.getPageNumber()+"/"+pageable.getPageSize()+"/"+pageable.getSort());
    	Sort defaultSort = new Sort(Direction.DESC,"idx");
        pageable = PageRequest.of(pageable.getPageNumber() <= 0 ? 0 : pageable.getPageNumber() - 1, pageable.getPageSize(),pageable.getSortOr(defaultSort));
        return bbsRepository.findAll(pageable);
    }

    public Board findBbsByIdx(Long idx) {
    	Board bbs = bbsRepository.findById(idx).orElse(new Board());
        return bbs;
    }

    public Board saveAndUpdateBbs(Board board) {
        return bbsRepository.save(board);
    }
    public void deleteBbs(Long idx) {
    	bbsRepository.deleteById(idx);
    }
}
