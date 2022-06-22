package com.teste.testeCase.Controller;

import com.teste.testeCase.Services.PasswordVerificationService;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@WebMvcTest(PasswordVerificationController.class)
public class PasswordVerificationControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PasswordVerificationService verificationService;

    @Test
    void whenValidInput_thenReturns200() throws Exception {
        mockMvc.perform(get("/verification/{password}","AAAbbbCc"))
                .andExpect(status().isOk());
    }
    @Test
    void whenValidInput_thenReturns404() throws Exception {
        mockMvc.perform(get("/verification/{password}",""))
                .andExpect(status().isNotFound());
    }
    @Test
    void whenValidInput_thenReturns200True() throws Exception {
        when(verificationService.isValidPassword("AbTp9!fok")).thenReturn(true);
        MvcResult mvcResult  = mockMvc.perform(get("/verification/{password}","AbTp9!fok"))
                .andReturn();
        String response = mvcResult.getResponse().getContentAsString();
        assertThat(response).isEqualToIgnoringWhitespace(
                "true");
    }
    @Test
    void whenValidInput_thenReturns200False() throws Exception {
        when(verificationService.isValidPassword("AbTp9!fok")).thenReturn(false);
        MvcResult mvcResult  = mockMvc.perform(get("/verification/{password}","AbTp9!foA"))
                .andReturn();
        String response = mvcResult.getResponse().getContentAsString();
        assertThat(response).isEqualToIgnoringWhitespace(
                "false");
    }
}
