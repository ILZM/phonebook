package com.example.demo.controller;

import com.example.demo.model.PhonebookRecord;
import com.example.demo.service.real.PhonebookServiceReal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class PhonebookController {

  @Autowired
  private PhonebookServiceReal phonebookService;

  @GetMapping("phonebook")
  public String getPage() {
    return "phonebook.html";
  }

  @GetMapping(path = "api/getPhonebookRecordList", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
  @ResponseBody
  public List<PhonebookRecord> getList() {
    return phonebookService.getList();
  }
}
