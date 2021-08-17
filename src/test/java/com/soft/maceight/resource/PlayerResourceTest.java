package com.soft.maceight.resource;

import com.soft.maceight.MacEightApplication;
import com.soft.maceight.domain.Player;
import com.soft.maceight.service.PlayerService;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(classes = MacEightApplication.class)
@AutoConfigureMockMvc
class PlayerResourceTest {

    @Autowired
    private MockMvc mockMvc;

    @Mock
    private PlayerService service;

    @Test
    void getListPlayers() throws Exception {
        List<String> response = Arrays.asList("AAA", "BBB");
        when(service.getPairs(139)).thenReturn(response);

        mockMvc.perform(get("/api/pairs/139"))
                .andExpect(status().is2xxSuccessful())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));
    }

    @Test
    void getEmptyPlayers() throws Exception {
        when(service.getPairs(139)).thenReturn(new ArrayList<>());

        mockMvc.perform(get("/api/pairs/{sum}", Integer.MAX_VALUE))
                .andExpect(status().is4xxClientError());

    }
}
