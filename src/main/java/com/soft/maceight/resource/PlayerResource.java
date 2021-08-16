package com.soft.maceight.resource;

import com.soft.maceight.domain.Player;
import com.soft.maceight.service.PlayerService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
@AllArgsConstructor
public class PlayerResource {

    private final PlayerService service;

    @GetMapping("/pairs/{sum}")
    public ResponseEntity<List<Player>> getPairs(@PathVariable Integer sum) {
        return ResponseEntity.ok(service.getPairs(sum));
    }

}
