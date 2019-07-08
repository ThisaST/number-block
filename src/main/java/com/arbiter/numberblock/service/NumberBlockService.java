package com.arbiter.numberblock.service;

import java.util.List;

/**
 * Created By Praneeth On 08/07/2019 for numberblock v1.0
 */

public interface NumberBlockService {

    <S, T> S save(T object);

    <T, K> T update(K object);

    <T> List<T> findAll();

    <T, K> T findById(K id);

}
