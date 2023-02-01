package com.company.models;

public class Record {

    private String product;
    private String issue;
    private String company;
    private String state;
    private String zip_code;
    private String complaint_id;

    public Record() {
    }

    public Record(String product, String issue, String company, String state, String zip_code, String complaint_id) {
        this.product = product;
        this.issue = issue;
        this.company = company;
        this.state = state;
        this.zip_code = zip_code;
        this.complaint_id = complaint_id;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public String getIssue() {
        return issue;
    }

    public void setIssue(String issue) {
        this.issue = issue;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZip_code() {
        return zip_code;
    }

    public void setZip_code(String zip_code) {
        this.zip_code = zip_code;
    }

    public String getComplaint_id() {
        return complaint_id;
    }

    public void setComplaint_id(String complaint_id) {
        this.complaint_id = complaint_id;
    }

    @Override
    public String toString() {
        return "Record{" +
                "product='" + product + '\'' +
                ", issue='" + issue + '\'' +
                ", company='" + company + '\'' +
                ", state='" + state + '\'' +
                ", zip_code='" + zip_code + '\'' +
                ", complaint_id='" + complaint_id + '\'' +
                '}';
    }
}
