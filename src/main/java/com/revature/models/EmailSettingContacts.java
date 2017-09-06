package com.revature.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 * 
 * @author MUTHU G.K
 *
 */

@Entity
@Table(name = "email_setting_contacts")
public class EmailSettingContacts implements Serializable {

  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "id")
  private Long id;

  @ManyToOne
  @JoinColumn(name = "EMAIL_SETTING_ID")
  private EmailSetting emailsetting;

  @ManyToOne
  @JoinColumn(name = "EMPLOYEE_ID")
  private Employee employee;

  @Column(name = "NAME")
  private String name;

  @Column(name = "MAIL_ID")
  private String mailId;

  @Transient
  private String nameT;

  @Transient
  private String mailIdT;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public EmailSetting getEmailsetting() {
    return emailsetting;
  }

  public void setEmailsetting(EmailSetting emailsetting) {
    this.emailsetting = emailsetting;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getMailId() {
    return mailId;
  }

  public void setMailId(String mailId) {
    this.mailId = mailId;
  }

  public Employee getEmployee() {
    return employee;
  }

  public void setEmployee(Employee employee) {
    this.employee = employee;
  }

  // ------------ Transient Values --------------------
  public String getNameT() {
    return nameT;
  }

  public void setNameT(String nameT) {
    this.nameT = nameT;
  }

  public String getMailIdT() {
    return mailIdT;
  }

  public void setMailIdT(String mailIdT) {
    this.mailIdT = mailIdT;
  }

  // ----------------------------------------------------

}
