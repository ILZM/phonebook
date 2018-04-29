package com.example.demo.service.real;

import com.example.demo.model.PhonebookRecord;
import com.example.demo.service.PhonebookService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PhonebookServiceReal implements PhonebookService {

  @Override
  public List<PhonebookRecord> getList() {
    return null;
  }
}
