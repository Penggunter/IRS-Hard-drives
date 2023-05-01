package com.example.irs_hard_drives.data;

public class HardDiskData {
    private String name;
    private String company;
    private String size;
    private String description;

    HardDiskData(){}
    public HardDiskData(String name, String company, String size, String description){
        this.name = name;
        this.company = company;
        this.size = size;
        this.description = description;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getCompany() {
        return company;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getSize() {
        return size;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
