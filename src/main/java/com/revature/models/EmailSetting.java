package com.revature.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlRootElement;

import org.apache.log4j.Logger;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

@Entity
@Table(name = "email_settings")
@XmlRootElement
public class EmailSetting implements Serializable {

  private static final long serialVersionUID = 1L;

  private static final transient Logger log = Logger.getLogger(EmailSetting.class);

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "id")
  private Long id;

  @Column(name = "REDIRECT_MAIL_ID")
  private String redirectEmailIds;

  @Column(name = "STATUS")
  private Boolean status;

  @Column(name = "IS_REDIRECT_ENABLED")
  private Boolean redirectStatus;

  @ManyToOne
  @JoinColumn(name = "EMAIL_NOTIFICATION")
  private SeedEmailNotification notification;

  @OneToMany(mappedBy = "emailsetting", fetch = FetchType.EAGER)
  @Cascade({CascadeType.ALL})
  private List<EmailSettingContacts> emailSettingContacts = new ArrayList<>();


  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "ORG_ID")
  private Organization organization;

  // Page variables
  @Transient
  private boolean cheackBox;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getRedirectEmailIds() {
    return redirectEmailIds;
  }

  public void setRedirectEmailIds(String redirectEmailIds) {
    this.redirectEmailIds = redirectEmailIds;
  }

  public Boolean getStatus() {
    return status;
  }

  public void setStatus(Boolean status) {
    this.status = status;
  }

  public Boolean getRedirectStatus() {
    return redirectStatus;
  }

  public void setRedirectStatus(Boolean redirectStatus) {
    this.redirectStatus = redirectStatus;
  }

  public SeedEmailNotification getNotification() {
    return notification;
  }

  public void setNotification(SeedEmailNotification notification) {
    this.notification = notification;
  }

  public List<EmailSettingContacts> getEmailSettingContacts() {
    return emailSettingContacts;
  }

  public void setEmailSettingContacts(List<EmailSettingContacts> emailSettingContacts) {
    this.emailSettingContacts = emailSettingContacts;
  }


  public Organization getOrganization() {
    return organization;
  }

  public void setOrganization(Organization organization) {
    this.organization = organization;
  }

  /**
   * To get the redirect emails as List
   * 
   * @return List<String>
   */
  public List<String> getRedirectEmails() {

    try {
      boolean isRedirectEnabled = getRedirectStatus() != null && getRedirectStatus();
      boolean isValidRedirectEmails =
          redirectEmailIds != null && redirectEmailIds.trim().length() > 0;

      if (isRedirectEnabled && isValidRedirectEmails) {
        return Arrays.asList(getRedirectEmailIds().split(","));
      }

    } catch (Exception e) {
      log.error(e.getMessage(), e);
    }

    return new ArrayList<>();
  }

  // ------------------- Transient Variables ------------------------------
  public boolean isCheackBox() {
    return cheackBox;
  }

  public void setCheackBox(boolean cheackBox) {
    this.cheackBox = cheackBox;
  }

  @Override
  public int hashCode() {
    Integer result;
    if (getId() != null) {
      result = Integer.parseInt(getId().toString());
    } else {
      result = new String().hashCode();
    }
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    boolean result = false;
    if (obj != null && this.hashCode() == obj.hashCode()) {
      result = true;
    }
    return result;
  }

}
