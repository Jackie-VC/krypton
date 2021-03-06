package com.assignment.cryptocurrency.model.entity;

import com.assignment.cryptocurrency.general.Model;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * Created by Jackie on 06/12/2017.
 */
@Entity
@JsonNaming(value = PropertyNamingStrategy.SnakeCaseStrategy.class)
@Table(name = "voucher")
public class Voucher extends Model {

  private String code;
  private String type;
  private Date startDate;
  private Date endDate;
  @Column(name = "user_id")
  private Integer userId;
  private Integer limits;
  private String status;

  public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public Date getStartDate() {
    return startDate;
  }

  public void setStartDate(Date startDate) {
    this.startDate = startDate;
  }

  public Date getEndDate() {
    return endDate;
  }

  public void setEndDate(Date endDate) {
    this.endDate = endDate;
  }

  public Integer getUserId() {
    return userId;
  }

  public void setUserId(Integer userId) {
    this.userId = userId;
  }

  public Integer getLimits() {
    return limits;
  }

  public void setLimits(Integer limit) {
    this.limits = limit;
  }

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }
}
