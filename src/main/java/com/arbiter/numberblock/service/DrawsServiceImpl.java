package com.arbiter.numberblock.service;

import com.arbiter.numberblock.modal.Draws;
import com.arbiter.numberblock.repository.DrawsRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created By Praneeth On 30/08/2019 for numberblock v1.0
 */

@Slf4j
@Service
public class DrawsServiceImpl implements DrawsService {
    private final DrawsRepository drawsRepository;

    public DrawsServiceImpl(DrawsRepository drawsRepository) {
        this.drawsRepository = drawsRepository;
    }

    @Override
    public <S, T> S save(T object) {
        Draws draws = drawsRepository.save((Draws) object);
        return (S) draws;
    }

    @Override
    public <T, K> T update(K object) {
        return null;
    }

    @Override
    public <T> List<T> findAll() {
        return (List<T>) drawsRepository.findAll();
    }

    @Override
    public <T, K> T findById(K id) {
        return null;
    }

    @Override
    public String findTop1ByOrderByIdDesc() {
        return drawsRepository.findTop1ByOrderByIdDesc().getNumberCombination();
    }
}
