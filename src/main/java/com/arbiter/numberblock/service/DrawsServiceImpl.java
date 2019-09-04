package com.arbiter.numberblock.service;

import com.arbiter.numberblock.modal.Draws;
import com.arbiter.numberblock.modal.NumberBlockDrawsJsonMapper;
import com.arbiter.numberblock.repository.DrawsRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
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
        log.info("drawsRepository.findTop1ByOrderByIdDesc().getNumberCombination() {}", drawsRepository.findTop1ByOrderByIdDesc());
        Draws draws = drawsRepository.findTop1ByOrderByIdDesc();
        return ((draws == null) || (draws.getNumberCombination() == null) || (draws.getNumberCombination().isEmpty())) ? "00-00-00-00-00-00" : draws.getNumberCombination();
    }

    @Override
    public List<NumberBlockDrawsJsonMapper> findAllNumberBlockDraws() {
        List<NumberBlockDrawsJsonMapper> mapperList = new ArrayList<>();
        drawsRepository.findAllNumberBlockDraws().forEach(val -> {
            NumberBlockDrawsJsonMapper mapper = new NumberBlockDrawsJsonMapper();
            mapper.setId((Integer) val[0]);
            mapper.setDate((Date) val[1]);
            mapper.setGame((String) val[2]);
            mapper.setPicked((String) val[3]);
            mapper.setWinner((String) val[4]);
            mapper.setHits((Integer) val[5]);
            mapperList.add(mapper);
        });

        return mapperList;
    }
}
