package com.soft.maceight.service;

import com.soft.maceight.domain.Player;
import com.soft.maceight.service.dto.PlayerDto;
import com.soft.maceight.service.error.BadRequestAlertException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@Service
@RequiredArgsConstructor
public class PlayerService {

    private final RestTemplate restTemplate;

    public List<String> getPairs(Integer sum) {

        List<Player> data = getData().getValues();

        Map<Integer, Integer> map = new HashMap<>();

        List<String> coupleString = new ArrayList<>();

        int cont = 0;
        for (Player player : data) {
            int temp = sum - player.getHIn();

            if (map.containsKey(temp)) {
                log.info(data.get(map.get(temp)) + " " + player);
                coupleString.add(getFullName(data.get(map.get(temp))) + " - " + getFullName(player));
            }
            // store index of the current element in the map
            map.put(player.getHIn(), cont);
            cont++;
        }

        if (coupleString.isEmpty()) {
            throw new BadRequestAlertException("No matches found");
        }

        return coupleString;
    }

    public PlayerDto getData() {
        ResponseEntity<PlayerDto> response = restTemplate.getForEntity("https://mach-eight.uc.r.appspot.com/", PlayerDto.class);
        if (response.getStatusCode().is2xxSuccessful()) {
            return response.getBody();
        }
        return new PlayerDto();
    }

    private String getFullName(Player player) {
        return player.getFirstName() + " " + player.getLastName();
    }
}
