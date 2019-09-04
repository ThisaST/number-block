package com.arbiter.numberblock.service;

import com.arbiter.numberblock.modal.NumberBlock;

import java.util.Date;
import java.util.List;

/**
 * Created By Praneeth On 08/07/2019 for numberblock v1.0
 */

public interface NumberBlockService {

    <S, T> S save(T object);

    <S, T> S update(T object);

    <T> List<T> findAll();

    <T, K> T findById(K id);

    List<NumberBlock> findAllByDate(Date fromDate, Date toDate);

}
