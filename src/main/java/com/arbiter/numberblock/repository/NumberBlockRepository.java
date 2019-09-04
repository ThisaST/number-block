package com.arbiter.numberblock.repository;

import com.arbiter.numberblock.modal.NumberBlock;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Date;
import java.util.List;

/**
 * Created By Praneeth On 08/07/2019 for numberblock v1.0
 */

public interface NumberBlockRepository extends CrudRepository<NumberBlock, Integer> {

    @Query(value = "from NumberBlock n where n.checked = 0 and DATE(n.date) between ?2 and ?1")
    List<NumberBlock> findAllByDate(Date fromDate, Date toDate);
}
