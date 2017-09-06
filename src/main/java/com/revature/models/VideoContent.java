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
import javax.servlet.http.Part;

@Entity
@Table(name = "video_contents")
public class VideoContent implements Serializable {
  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "id")
  private Long id;

  @Column(name = "content_type")
  private String type;

  private String name;

  private String description;

  @Column(name = "unique_name")
  private String fileUniqueName;

  @Column(name = "file_name")
  private String fileName;

  private String url;

  @Column(name = "is_tutorials_lnk")
  private Boolean isTutorialsLnk;

  @ManyToOne
  @JoinColumn(name = "video_id")
  private Video video;

  @Transient
  private byte[] file;

  @Transient
  private Part part;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public String getFileUniqueName() {
    return fileUniqueName;
  }

  public void setFileUniqueName(String fileUniqueName) {
    this.fileUniqueName = fileUniqueName;
  }

  public String getFileName() {
    return fileName;
  }

  public void setFileName(String fileName) {
    this.fileName = fileName;
  }

  public byte[] getFile() {
    return file;
  }

  public void setFile(byte[] file) {
    this.file = file;
  }

  public String getUrl() {
    return url;
  }

  public void setUrl(String url) {
    this.url = url;
  }

  public Boolean getIsTutorialsLnk() {
    return isTutorialsLnk;
  }

  public void setIsTutorialsLnk(Boolean isTutorialsPtLnk) {
    this.isTutorialsLnk = isTutorialsPtLnk;
  }

  public Video getVideo() {
    return video;
  }

  public void setVideo(Video video) {
    this.video = video;
  }

  public Part getPart() {
    return part;
  }

  public void setPart(Part part) {
    this.part = part;
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
