package com.example.demo.domain;

import javax.persistence.*;

@Entity
@Table(name = "phonebook")
public class PhonebookDomain {

  @Id
  @Column(name = "id")
  @SequenceGenerator(name = "identifier", sequenceName = "seq_phonebook_id", allocationSize = 1)
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "identifier")
  public Long id;

  @Column(name = "firstname")
  public String firstname;

  @Column(name = "middlename")
  public String middlename;

  @Column(name = "lastname")
  public String lastname;

  @Column(name = "phonenumber")
  public String phoneNumber;

  @Column(name = "email")
  public String email;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getFirstname() {
    return firstname;
  }

  public void setFirstname(String firstname) {
    this.firstname = firstname;
  }

  public String getMiddlename() {
    return middlename;
  }

  public void setMiddlename(String middlename) {
    this.middlename = middlename;
  }

  public String getLastname() {
    return lastname;
  }

  public void setLastname(String lastname) {
    this.lastname = lastname;
  }

  public String getPhoneNumber() {
    return phoneNumber;
  }

  public void setPhoneNumber(String phoneNumber) {
    this.phoneNumber = phoneNumber;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }
}
