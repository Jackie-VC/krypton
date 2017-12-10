package com.assignment.cryptocurrency.model.entity;

import com.assignment.cryptocurrency.general.Model;
import com.assignment.cryptocurrency.util.enums.CoinType;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "exchange")
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class Exchange extends Model {

  private CoinType originType;
  private CoinType destType;
  private BigDecimal originAmount;
  private BigDecimal destAmount;
  private BigDecimal originPrice;
  private BigDecimal destPrice;
  private Integer userId;
  private Date createTime;

  public CoinType getOriginType() {
    return originType;
  }

  public void setOriginType(CoinType originType) {
    this.originType = originType;
  }

  public CoinType getDestType() {
    return destType;
  }

  public void setDestType(CoinType destType) {
    this.destType = destType;
  }

  @Basic
  @Column(name = "origin_amount", nullable = true, precision = 0)
  public BigDecimal getOriginAmount() {
    return originAmount;
  }

  public void setOriginAmount(BigDecimal originAmount) {
    this.originAmount = originAmount;
  }

  @Basic
  @Column(name = "dest_amount", nullable = false, precision = 0)
  public BigDecimal getDestAmount() {
    return destAmount;
  }

  public void setDestAmount(BigDecimal destAmount) {
    this.destAmount = destAmount;
  }

  @Basic
  @Column(name = "origin_price", nullable = false, precision = 0)
  public BigDecimal getOriginPrice() {
    return originPrice;
  }

  public void setOriginPrice(BigDecimal originPrice) {
    this.originPrice = originPrice;
  }

  @Basic
  @Column(name = "dest_price", nullable = false, precision = 0)
  public BigDecimal getDestPrice() {
    return destPrice;
  }

  public void setDestPrice(BigDecimal destPrice) {
    this.destPrice = destPrice;
  }

  @Basic
  @Column(name = "user_id", nullable = false)
  public Integer getUserId() {
    return userId;
  }

  public void setUserId(Integer userId) {
    this.userId = userId;
  }

  public Date getCreateTime() {
    return createTime;
  }

  public void setCreateTime(Date createTime) {
    this.createTime = createTime;
  }
}