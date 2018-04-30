package com.example.demo.mapper;

import com.example.demo.domain.PhonebookDomain;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface PhonebookMapper {
  //  @Select("select next value for seq_phonebook_id")
  @Select("select t from (values next value for seq_phonebook_id) s(t)")
  Long nextId();

  @Insert("insert into phonebook(id, firstname, middlename, lastname, phonenumber, email) " +
    "values(#{id}, #{firstname}, #{middlename}, #{lastname}, #{phoneNumber}, #{email})")
//  void insertRecord(long id, String firstname, String middlename, String lastname, String phoneNumber, String email);
  void insertRecord(PhonebookDomain phonebookRecord);

  @Select("select firstname, middlename, lastname, phonenumber, email from phonebook order by id")
  List<PhonebookDomain> getList();

  @Delete("delete from phonebook")
  void clear();
}
