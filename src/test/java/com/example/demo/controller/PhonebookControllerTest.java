package com.example.demo.controller;

import com.example.demo.model.PhonebookRecord;
import com.example.demo.service.real.PhonebookServiceReal;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(PhonebookController.class)
public class PhonebookControllerTest {

  @Autowired
  private MockMvc mockMvc;

  @MockBean
  private PhonebookServiceReal phonebookService;

  @Test
  public void getMessageOk() throws Exception {
    List<PhonebookRecord> phonebookRecordList = new ArrayList<>();

    when(phonebookService.getList()).thenReturn(phonebookRecordList);
    mockMvc.perform(get("/phonebook"))
      .andDo(print())
      .andExpect(status().isOk())
      .andExpect(content().json("Hello Mock"));
  }
}
