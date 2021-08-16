package com.soft.maceight.service.dto;

import com.soft.maceight.domain.Player;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class PlayerDto {
    private List<Player> values = new ArrayList<>();
}
