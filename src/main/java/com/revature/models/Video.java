package com.revature.models;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;
import java.util.List;
import java.util.Optional;

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

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.revature.utils.TypeConversionUtil;

@Entity
@Table(name = "videos")
public class Video implements Serializable {
  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "id")
  private Long id;

  private String name;

  private String title;

  @Column(name = "VIDEO_URL")
  private String url;

  @Column(name = "DURATION_IN_SEC")
  private Long duration;

  @Column(name = "thumbnail_url")
  private String thumbnailURL;

  @Column(name = "thumbnail_url_295")
  private String thumbnailURL295;

  @Column(name = "thumbnail_url_640")
  private String thumbnailURL640;

  @Column(name = "thumbnail_url_960")
  private String thumbnailURL960;

  @Column(name = "thumbnail_url_1280")
  private String thumbnailURL1280;

  private String tags;

  private String description;

  private String transcript;

  @Column(name = "IS_ACTIVE")
  private Boolean isActive;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "org_id", nullable = false)
  private Organization organization;

  @JsonIgnore
  @JoinColumn(name = "CREATED_BY")
  @ManyToOne(fetch = FetchType.LAZY)
  private SystemUser createdBy;

  @Column(name = "CREATED_ON")
  private Date createdOn;

  @JsonIgnore
  @JoinColumn(name = "MODIFIED_BY")
  @ManyToOne(fetch = FetchType.LAZY)
  private SystemUser modifiedBy;

  @Column(name = "MODIFIED_ON")
  private Date modifiedOn;

  @OneToMany(mappedBy = "video", fetch = FetchType.LAZY)
  private List<VideoContent> videoContents;

  @ManyToOne
  @JoinColumn(name = "LVL_ID")
  private Level level;

  @ManyToOne
  @JoinColumn(name = "CAT_ID")
  private Category category;

  // ----------------------------------------------------------- Transient

  @Transient
  private String createdEmp;

  @Transient
  private String updatedEmp;

  @Transient
  private String durString;

  @Transient
  private String lvlName;

  @Transient
  private String catName;

  @Transient
  private Integer displayOrderT;

  @Transient
  private Long courseContentId;

  @Transient
  private Long interhshipId;

  @Transient
  private boolean selected;

  @Transient
  private BigInteger orgId;

  /* getters and setters start */
  public Long getId() {
    return id;
  }

  public void setId(Object id) {
    this.id = TypeConversionUtil.toLong(id);
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public Category getCategory() {
    return category;
  }

  public void setCategory(Category category) {
    this.category = category;
  }

  public String getUrl() {
    return url;
  }

  public void setUrl(String url) {
    this.url = url;
  }

  public Long getDuration() {
    return duration;
  }

  public void setDuration(Long duration) {
    this.duration = duration;
  }

  public String getThumbnailURL() {
    return thumbnailURL;
  }

  public void setThumbnailURL(String thumbnailURL) {
    this.thumbnailURL = thumbnailURL;
  }

  public String getThumbnailURL295() {
    return thumbnailURL295;
  }

  public void setThumbnailURL295(String thumbnailURL295) {
    this.thumbnailURL295 = thumbnailURL295;
  }

  public String getThumbnailURL640() {
    return thumbnailURL640;
  }

  public void setThumbnailURL640(String thumbnailURL640) {
    this.thumbnailURL640 = thumbnailURL640;
  }

  public String getThumbnailURL960() {
    return thumbnailURL960;
  }

  public void setThumbnailURL960(String thumbnailURL960) {
    this.thumbnailURL960 = thumbnailURL960;
  }

  public String getThumbnailURL1280() {
    return thumbnailURL1280;
  }

  public void setThumbnailURL1280(String thumbnailURL1280) {
    this.thumbnailURL1280 = thumbnailURL1280;
  }

  public String getTags() {
    return tags;
  }

  public void setTags(String tags) {
    this.tags = tags;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public String getTranscript() {
    return transcript;
  }

  public void setTranscript(String transcript) {
    this.transcript = transcript;
  }

  public Boolean getIsActive() {
    return isActive;
  }

  public void setIsActive(Boolean isActive) {
    this.isActive = isActive;
  }

  public Organization getOrganization() {
    return organization;
  }

  public void setOrganization(Organization organization) {
    this.organization = organization;
  }

  public SystemUser getCreatedBy() {
    return createdBy;
  }

  public void setCreatedBy(SystemUser createdBy) {
    this.createdBy = createdBy;
  }

  public Date getCreatedOn() {
    return createdOn;
  }

  public void setCreatedOn(Date createdOn) {
    this.createdOn = createdOn;
  }

  public SystemUser getModifiedBy() {
    return modifiedBy;
  }

  public void setModifiedBy(SystemUser modifiedBy) {
    this.modifiedBy = modifiedBy;
  }

  public Date getModifiedOn() {
    return modifiedOn;
  }

  public void setModifiedOn(Date modifiedOn) {
    this.modifiedOn = modifiedOn;
  }

  public String getCreatedEmp() {
    return createdEmp;
  }

  public void setCreatedEmp(String createdEmp) {
    this.createdEmp = createdEmp;
  }

  public String getUpdatedEmp() {
    return updatedEmp;
  }

  public void setUpdatedEmp(String updatedEmp) {
    this.updatedEmp = updatedEmp;
  }

  public List<VideoContent> getVideoContents() {
    return videoContents;
  }

  public void setVideoContents(List<VideoContent> videoContents) {
    this.videoContents = videoContents;
  }

  public Level getLevel() {
    return level;
  }

  public void setLevel(Level level) {
    this.level = level;
  }

  public String getDurString() {
    String durString = "0h 00m 00s";
    if (duration != null) {
      long hrs = duration / (60 * 60);
      long sec2 = duration % (60 * 60);
      long min = sec2 / 60;
      long secf = sec2 % 60;
      durString = hrs + "h " + min + "m " + secf + "s";
    }
    return durString;
  }

  public void setDurString(String durString) {
    if (durString != null) {
      long sec = 0;
      String durStr[] = durString.replaceAll("[hms]", "").split(" ");
      sec = Integer.parseInt(durStr[2]);
      sec += Integer.parseInt(durStr[1]) * 60;
      sec += Integer.parseInt(durStr[0]) * 60 * 60;
      this.duration = sec;
    }
    this.durString = durString;
  }

  public String getCatName() {
    return catName;
  }

  public void setCatName(String catName) {
    this.catName = catName;
  }

  public String getLvlName() {
    return lvlName;
  }

  public void setLvlName(String lvlName) {
    this.lvlName = lvlName;
  }
  /* getters and setters end */

  /* setters for hibernate result set transformer start */
  public void setVidId(Object obj) {
    if (obj != null) {
      this.id = Long.parseLong(obj.toString());
    }
  }

  public void setDur(Object obj) {
    if (obj != null) {
      this.duration = Long.parseLong(obj.toString());
    }
  }

  public Integer getDisplayOrderT() {
    return displayOrderT;
  }

  public void setDisplayOrderT(Integer displayOrderT) {
    this.displayOrderT = displayOrderT;
  }

  public Long getCourseContentId() {
    return courseContentId;
  }

  public void setCourseContentId(Long courseContentId) {
    this.courseContentId = courseContentId;
  }

  public Long getInterhshipId() {
    return interhshipId;
  }

  public void setInterhshipId(Long interhshipId) {
    this.interhshipId = interhshipId;
  }

  public boolean isSelected() {
    return selected;
  }

  public void setSelected(boolean selected) {
    this.selected = selected;
  }

  /* setters for hibernate result set transformer end */
  public void setActiveSts(Object obj) {
    isActive = Optional.ofNullable(obj).map(o -> "1".equals(o.toString())).orElse(false);
  }

  public BigInteger getOrgId() {
    return orgId;
  }

  public void setOrgId(BigInteger orgId) {
    this.orgId = orgId;
  }

  @Override
  public int hashCode() {
    Integer result = null;
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
