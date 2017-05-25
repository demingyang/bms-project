package com.yfkj.bms.domain;

import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.Date;

public class WXOrder {
    private Integer id;
    private String patientName;//患者姓名
    private Integer relation;//关系
    private Integer age;//年龄
    private Integer gender;//性别
    private String diseases;//病种
    private String contactPhoneNumber;//联系电话
    //申请人
    private String applyUserId;//申请人id
    private String applyUserName;//申请人姓名
    private String applyDeptName;//申请人部门
    private String applyPhoneNumber;//申请人电话
    private Integer companyId;//公司
    //审核人
    private String auditUserId;//审核人id
    private String auditUserName;//审核人姓名
    private String auditUserPhoneNumber;//审核人电话

    //ext
    private Date createTime;//创建时间

    private Integer commodityTypeCount;

    private Float totalPrice;

    private Integer buyer;

    private Integer currency;

    private String recvAddr;

    private Integer commodityCount;

    private Integer orderStatus;

    private String timeStamp;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getApplyUserId() {
        return applyUserId;
    }

    public void setApplyUserId(String applyUserId) {
        this.applyUserId = applyUserId == null ? null : applyUserId.trim();
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName == null ? null : patientName.trim();
    }

    public Integer getRelation() {
        return relation;
    }

    public void setRelation(Integer relation) {
        this.relation = relation;
    }

    public String getDiseases() {
        return diseases;
    }

    public void setDiseases(String diseases) {
        this.diseases = diseases == null ? null : diseases.trim();
    }


    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }


    public String getAuditUserId() {
        return auditUserId;
    }

    public void setAuditUserId(String auditUserId) {
        this.auditUserId = auditUserId == null ? null : auditUserId.trim();
    }

    public String getApplyDeptName() {
        return applyDeptName;
    }

    public void setApplyDeptName(String applyDeptName) {
        this.applyDeptName = applyDeptName == null ? null : applyDeptName.trim();
    }


    public Integer getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getCommodityTypeCount() {
        return commodityTypeCount;
    }

    public void setCommodityTypeCount(Integer commodityTypeCount) {
        this.commodityTypeCount = commodityTypeCount;
    }

    public Float getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Float totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Integer getBuyer() {
        return buyer;
    }

    public void setBuyer(Integer buyer) {
        this.buyer = buyer;
    }

    public Integer getCurrency() {
        return currency;
    }

    public void setCurrency(Integer currency) {
        this.currency = currency;
    }

    public String getRecvAddr() {
        return recvAddr;
    }

    public void setRecvAddr(String recvAddr) {
        this.recvAddr = recvAddr == null ? null : recvAddr.trim();
    }

    public Integer getCommodityCount() {
        return commodityCount;
    }

    public void setCommodityCount(Integer commodityCount) {
        this.commodityCount = commodityCount;
    }

    public Integer getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(Integer orderStatus) {
        this.orderStatus = orderStatus;
    }

    public String getContactPhoneNumber() {
        return contactPhoneNumber;
    }

    public void setContactPhoneNumber(String contactPhoneNumber) {
        this.contactPhoneNumber = contactPhoneNumber;
    }

    public String getApplyPhoneNumber() {
        return applyPhoneNumber;
    }

    public void setApplyPhoneNumber(String applyPhoneNumber) {
        this.applyPhoneNumber = applyPhoneNumber;
    }

    public String getAuditUserName() {
        return auditUserName;
    }

    public void setAuditUserName(String auditUserName) {
        this.auditUserName = auditUserName;
    }

    public String getAuditUserPhoneNumber() {
        return auditUserPhoneNumber;
    }

    public void setAuditUserPhoneNumber(String auditUserPhoneNumber) {
        this.auditUserPhoneNumber = auditUserPhoneNumber;
    }

    public String getApplyUserName() {
        return applyUserName;
    }

    public void setApplyUserName(String applyUserName) {
        this.applyUserName = applyUserName;
    }

    public String getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(String timeStamp) {
        this.timeStamp = timeStamp;
    }

    public static void main(String[] args) {

      try {
          System.out.println(URLDecoder.decode("%7B%22age%22%3A23%2C%22applyDeptName%22%3A%22%E6%81%A4%E7%97%85%E4%BA%A7%E5%93%81%E9%83%A8%22%2C%22applyPhoneNumber%22%3A%2218201095488%22%2C%22applyUserId%22%3A%22zhaoxiaoyao%40efangtec.com%22%2C%22applyUserName%22%3A%22%E8%B5%B5%E6%BD%87%E7%91%B6%22%2C%22auditUserId%22%3A%22yangdeming%40efangtec.com%22%2C%22companyId%22%3A1%2C%22contactPhoneNumber%22%3A%2213367676556%22%2C%22diseases%22%3A%22%E8%82%BE%E7%99%8C%22%2C%22gender%22%3A1%2C%22patientName%22%3A%22%E5%92%A8%E8%AF%A2%22%2C%22relation%22%3A1%7D","utf-8"));
          String str= URLEncoder.encode("GBK编码", "UTF-8");
          System.out.println(str);
          String str2= URLDecoder.decode(str, "UTF-8");
          System.out.println(str2);
      }catch (Exception e){
          e.printStackTrace();
      }
    }

}