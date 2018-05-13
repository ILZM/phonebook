package com.example.demo.service;

import com.example.demo.Util;
import com.example.demo.dao.PhonebookDao;
import com.example.demo.domain.PhonebookDomain;
import com.example.demo.model.PhonebookRecord;
import com.example.demo.service.real.PhonebookServiceReal;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PhonebookServiceTest {

  @Autowired
  private PhonebookServiceReal phonebookService;

  @Autowired
  private PhonebookDao phonebookDao;

  @Test
  public void listOk() {
    phonebookDao.deleteAll();

    List<PhonebookRecord> expectedList = new ArrayList<>();
    for (int i = 0; i < 32; i++) {
      PhonebookDomain phonebookDomain = generatePhonebookDomain();
//      phonebookDomain.id = (long) i;
      phonebookDao.save(phonebookDomain);

      PhonebookRecord phonebookRecord = new PhonebookRecord();
      phonebookRecord.fullname =
        Util.getFullname(phonebookDomain.firstname, phonebookDomain.middlename, phonebookDomain.lastname);
      phonebookRecord.phoneNumber = phonebookDomain.phoneNumber;
      phonebookRecord.email = phonebookDomain.email;
      expectedList.add(phonebookRecord);
    }

    List<PhonebookRecord> realList = phonebookService.getList();

    assertThat(realList.size()).isEqualTo(expectedList.size());
    for (PhonebookRecord realRecord : realList) {
      assertThat(expectedList.stream().anyMatch(phonebookRecord ->
        phonebookRecord.fullname.equals(realRecord.fullname) &&
          phonebookRecord.phoneNumber.equals(realRecord.phoneNumber) &&
          phonebookRecord.email.equals(realRecord.email)
      )).isEqualTo(true);
    }
  }

  private PhonebookDomain generatePhonebookDomain() {
    PhonebookDomain phonebookDomain = new PhonebookDomain();
//    phonebookDomain.id = phonebookMapper.nextId();
    phonebookDomain.firstname = Util.generateString(16);
    phonebookDomain.middlename = Util.generateString(16);
    phonebookDomain.lastname = Util.generateString(16);
    phonebookDomain.phoneNumber = Util.generateString(11);
    phonebookDomain.email = Util.generateString(8);

    return phonebookDomain;
  }
}
