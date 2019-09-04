package com.arbiter.numberblock.modal;

import lombok.*;

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
@ToString
@EqualsAndHashCode

@Entity
@Table(name = "number_block")
public class NumberBlock {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "date", nullable = false)
    private Date date;

    @Column(name = "number_combination", nullable = false)
    private String numberCombination;

    @Column(name = "pick_type", nullable = false)
    private String pickType;

    @Column(name = "cost", nullable = false, precision = 12, scale = 2)
    private BigDecimal cost;

    @Column(name = "hits", nullable = false)
    private Integer hits;

    @Column(name = "checked", nullable = false)
    private Integer checked;

    @Column(name = "drawid")
    private Integer drawId;


    public NumberBlock(String numberCombination) {
        this.numberCombination = numberCombination;
    }
}
