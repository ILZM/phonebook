package com.example.demo.mapper;

import com.example.demo.domain.PhonebookDomain;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface PhonebookMapper {
  @Select("select nextval('seq_phonebook_id')")
  Long nextId();

  @Insert("insert into phonebook(id, firstname, middlename, lastname, phonenumber, email) " +
    "values(#{id}, #{firstname}, #{middlename}, #{lastname}, #{phoneNumber}, #{email})")
  void insertRecord(PhonebookDomain phonebookRecord);

  @Select("select firstname, middlename, lastname, phonenumber, email from phonebook order by id")
  List<PhonebookDomain> getList();

  @Delete("delete from phonebook")
  void clear();
}
