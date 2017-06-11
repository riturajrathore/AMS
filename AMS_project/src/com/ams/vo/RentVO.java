package com.ams.vo;

public class RentVO {
	private String rent;
	private String main1;
	public String tenant_id;
	public String getRent() {
		return rent;
	}
	public String getTenant_id() {
		return tenant_id;
	}
	public void setTenant_id(String tenant_id) {
		this.tenant_id = tenant_id;
	}
	public void setRent(String rent) {
		this.rent = rent;
	}
	public String getMain1() {
		return main1;
	}
	public void setMain1(String main1) {
		this.main1 = main1;
	}

}
