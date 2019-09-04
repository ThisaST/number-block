package com.arbiter.numberblock.modal;

import lombok.*;

import java.util.List;

/**
 * Created By Praneeth On 08/07/2019 for numberblock v1.0
 */

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class NumberBlockJsonMapper {
    List<NumberBlock> numberBlockList;
}
