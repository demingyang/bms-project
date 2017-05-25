package com.yfkj.bms.domain;

public class WXCompany {
    private Integer id;

    private Integer employesCount;

    private String name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getEmployesCount() {
        return employesCount;
    }

    public void setEmployesCount(Integer employesCount) {
        this.employesCount = employesCount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }
}