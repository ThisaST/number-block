package com.arbiter.numberblock.repository;

import com.arbiter.numberblock.modal.Draws;
import org.springframework.data.repository.CrudRepository;

/**
 * Created By Praneeth On 30/08/2019 for numberblock v1.0
 */

public interface DrawsRepository extends CrudRepository<Draws, Integer> {
    Draws findTop1ByOrderByIdDesc();
}
