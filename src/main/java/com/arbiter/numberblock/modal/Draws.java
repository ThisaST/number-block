package com.arbiter.numberblock.modal;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

/**
 * Created By Praneeth On 30/08/2019 for numberblock v1.0
 */

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode

@Entity
@Table(name = "draws")
public class Draws {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "date", nullable = false)
    private Date date;

    @Column(name = "number_combination", nullable = false)
    private String numberCombination;

    @Column(name = "game_serial")
    private String gameSerial;

}
