package com.arbiter.numberblock.modal;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Created By Praneeth On 08/07/2019 for numberblock v1.0
 */

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "number_block")
public class NumberBlock {

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "date", nullable = false)
    private Date date;

    @Column(name = "number_combination", nullable = false)
    private String numberCombination;

    @Column(name = "pick_type", nullable = false)
    private String pickType;

    @Column(name = "cost", nullable = false, precision = 12, scale = 2)
    private BigDecimal cost;
}
