package com.arbiter.numberblock.modal;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

/**
 * Created By Praneeth On 03/09/2019 for numberblock v1.0
 */

@Getter
@Setter
@ToString
@EqualsAndHashCode
public class NumberBlockDrawsJsonMapper {
    Integer id;
    Date date;
    String game;
    String picked;
    String winner;
    Integer hits;

    public NumberBlockDrawsJsonMapper(Integer id, Date date, String game, String picked, String winner, Integer hits) {
        this.id = id;
        this.date = date;
        this.game = game;
        this.picked = picked;
        this.winner = winner;
        this.hits = hits;
    }

    public NumberBlockDrawsJsonMapper() {
    }
}
