package com.example.demo.service.real;

import com.example.demo.Util;
import com.example.demo.dao.PhonebookDao;
import com.example.demo.domain.PhonebookDomain;
import com.example.demo.model.PhonebookRecord;
import com.example.demo.service.PhonebookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PhonebookServiceReal implements PhonebookService {

  @Autowired
  private PhonebookDao phonebookDao;

  @Override
  public List<PhonebookRecord> getList() {
    Iterable<PhonebookDomain> domainList = phonebookDao.findAll();

    List<PhonebookRecord> recordList = new ArrayList<>();
    for (PhonebookDomain domain : domainList) {
      PhonebookRecord record = new PhonebookRecord();
      record.fullname = Util.getFullname(domain.firstname, domain.middlename, domain.lastname);
      record.phoneNumber = domain.phoneNumber;
      record.email = domain.email;

      recordList.add(record);
    }

    return recordList;
  }
}
