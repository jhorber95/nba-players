package com.soft.maceight.service;

import com.soft.maceight.domain.Player;
import com.soft.maceight.service.dto.PlayerDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PlayerService {

    private final RestTemplate restTemplate;

    public List<Player> getPairs(Integer sum) {

        List<Player> pairs = new ArrayList<>();
        PlayerDto data = getData();

        HashSet<Integer> s = new HashSet<>();
        for (Player player : data.getValues()) {

            int temp = sum - player.getHIn();

            if (s.contains(temp)) {
                pairs.add(player);
            }
            s.add(player.getHIn());
        }
        return pairs;
    }

    public PlayerDto getData() {
        ResponseEntity<PlayerDto> response = restTemplate.getForEntity("https://mach-eight.uc.r.appspot.com/", PlayerDto.class);
        if (response.getStatusCode().is2xxSuccessful()) {
            return response.getBody();
        }
        return new PlayerDto();
    }
}
