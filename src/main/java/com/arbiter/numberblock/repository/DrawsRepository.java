package com.arbiter.numberblock.repository;

import com.arbiter.numberblock.modal.Draws;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created By Praneeth On 30/08/2019 for numberblock v1.0
 */

public interface DrawsRepository extends CrudRepository<Draws, Integer> {
    Draws findTop1ByOrderByIdDesc();

    @Query(value = "select n.id, d.date, d.game_serial as game, n.number_combination as picked, d.number_combination as winner, n.hits from number_block n, draws d where n.drawid = d.id", nativeQuery = true)
    List<Object[]> findAllNumberBlockDraws();
}
