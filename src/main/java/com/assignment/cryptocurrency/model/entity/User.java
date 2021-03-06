package com.assignment.cryptocurrency.model.entity;

import com.assignment.cryptocurrency.general.Model;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * Created by Jackie on 04/12/2017.
 */
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
@Entity
@Table(name = "user")
public class User extends Model {

  private String firstName;

  private String lastName;

  private String username;

  private String password;

  private String email;

  private String mobile;

  private String status;

  private Date createTime;

  private Date updateTime;

  @OneToMany(cascade = CascadeType.ALL, fetch= FetchType.LAZY)
  @JoinColumn(name = "user_id")
  private List<Wallet> walletList = new ArrayList<>();

  @OneToMany(cascade = CascadeType.ALL, fetch= FetchType.LAZY)
  @JoinColumn(name = "user_id")
  private List<Exchange> exchangeList;

  @OneToMany(cascade = CascadeType.ALL, fetch= FetchType.LAZY)
  @JoinColumn(name = "origin_user_id")
  private List<Transfer> transferList;

  @OneToMany(cascade = CascadeType.ALL, fetch= FetchType.LAZY)
  @JoinColumn(name = "user_id")
  private List<Voucher> voucherList;

  public Date getCreateTime() {
    return createTime;
  }

  public void setCreateTime(Date creatTime) {
    this.createTime = creatTime;
  }

  public Date getUpdateTime() {
    return updateTime;
  }

  public void setUpdateTime(Date updateTime) {
    this.updateTime = updateTime;
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getMobile() {
    return mobile;
  }

  public void setMobile(String mobile) {
    this.mobile = mobile;
  }

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public List<Wallet> getWalletList() {
    return walletList;
  }

  public void setWalletList(List<Wallet> walletList) {
    this.walletList = walletList;
  }

  public List<Exchange> getExchangeList() {
    return exchangeList;
  }

  public void setExchangeList(
      List<Exchange> exchangeList) {
    this.exchangeList = exchangeList;
  }

  public List<Transfer> getTransferList() {
    return transferList;
  }

  public void setTransferList(
      List<Transfer> transferList) {
    this.transferList = transferList;
  }

  public List<Voucher> getVoucherList() {
    return voucherList;
  }

  public void setVoucherList(
      List<Voucher> voucherList) {
    this.voucherList = voucherList;
  }
}
