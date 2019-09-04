package com.arbiter.numberblock.service;

import com.arbiter.numberblock.modal.NumberBlockDrawsJsonMapper;

import java.util.List;

/**
 * Created By Praneeth On 30/08/2019 for numberblock v1.0
 */

public interface DrawsService {

    <S, T> S save(T object);

    <T, K> T update(K object);

    <T> List<T> findAll();

    <T, K> T findById(K id);

    String findTop1ByOrderByIdDesc();

    List<NumberBlockDrawsJsonMapper> findAllNumberBlockDraws();
}
