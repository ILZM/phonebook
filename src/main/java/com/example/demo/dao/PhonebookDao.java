package com.example.demo.dao;

import com.example.demo.domain.PhonebookDomain;
import org.springframework.data.repository.CrudRepository;

import javax.transaction.Transactional;

@Transactional
public interface PhonebookDao extends CrudRepository<PhonebookDomain, Long> {
}
