package org.example.springlab;

import org.example.springlab.controllers.GroupController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class GroupTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void createGroupTest() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.post("/group")
                .accept(MediaType.APPLICATION_JSON)
                .content("{\n" +
                        "  \"name\": \"string\"\n" +
                        "}")
        ).andExpect(
                content().string(containsString("6"))
        ).andExpect(
                status().isCreated()
        ).andDo(print());
    }
}
