package com.arbiter.numberblock.service;

import com.arbiter.numberblock.modal.NumberBlock;
import com.arbiter.numberblock.repository.NumberBlockRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * Created By Praneeth On 08/07/2019 for numberblock v1.0
 */

@Slf4j
@Service
public class NumberBlockServiceImpl implements NumberBlockService {
    private final NumberBlockRepository numberBlockRepository;

    public NumberBlockServiceImpl(NumberBlockRepository numberBlockRepository) {
        this.numberBlockRepository = numberBlockRepository;
    }

    @Transactional
    @Override
    public <S, T> S save(T object) {
        NumberBlock numberBlock = numberBlockRepository.save((NumberBlock) object);
        return (S) numberBlock;
    }

    @Transactional
    @Override
    public <S, T> S update(T object) {
        NumberBlock numberBlock = numberBlockRepository.save((NumberBlock) object);
        log.info("Return numberBlock : {}", numberBlock.toString());
        return (S) numberBlock;
    }

    @Override
    public <T> List<T> findAll() {
        return (List<T>) numberBlockRepository.findAll();
    }

    @Override
    public <T, K> T findById(K id) {
        return null;
    }

    @Override
    public List<NumberBlock> findAllByDate(Date fromDate, Date toDate) {
        return numberBlockRepository.findAllByDate(fromDate, toDate);
    }
}
