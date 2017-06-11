package com.ams.vo;

public class ApartmentVO 
{
	
	private String block_name;
	private int floor_no;
	private int flat_no;
	private String type;
	private double rent;
	private double advance_amt;
	private int year_of_construction;
	private String vacant_from;
	private String owner_name;
	private String owner_contact;
	private String flatCategory;
	private static boolean noResults=false;
	
	private String flat_id;
	public static boolean isNoResults() {
		return noResults;
	}
	public static void setNoResults(boolean noResults) {
		ApartmentVO.noResults = noResults;
	}
	public String getFlat_id() {
		return flat_id;
	}
	public void setFlat_id(String flat_id) {
		this.flat_id = flat_id;
	}	
	public String getBlock_name() {
		return block_name;
	}
	public void setBlock_name(String block_name) {
		this.block_name = block_name;
	}
	public int getFloor_no() {
		return floor_no;
	}
	public void setFloor_no(int floor_no) {
		this.floor_no = floor_no;
	}
	public int getFlat_no() {
		return flat_no;
	}
	public void setFlat_no(int flat_no) {
		this.flat_no = flat_no;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public double getRent() {
		return rent;
	}
	public void setRent(double rent) {
		this.rent = rent;
	}
	public double getAdvance_amt() {
		return advance_amt;
	}
	public void setAdvance_amt(double advance_amt) {
		this.advance_amt = advance_amt;
	}
	public int getYear_of_construction() {
		return year_of_construction;
	}
	public void setYear_of_construction(int year_of_construction) {
		this.year_of_construction = year_of_construction;
	}
	public String getVacant_from() {
		return vacant_from;
	}
	public void setVacant_from(String vacant_from) {
		this.vacant_from = vacant_from;
	}
	public String getOwner_name() {
		return owner_name;
	}
	public void setOwner_name(String owner_name) {
		this.owner_name = owner_name;
	}
	public String getOwner_contact() {
		return owner_contact;
	}
	public void setOwner_contact(String owner_contact) {
		this.owner_contact = owner_contact;
	}
	public String getFlatCategory() {
		return flatCategory;
	}
	public void setFlatCategory(String flatCategory) {
		this.flatCategory = flatCategory;
	}
	
	
	
	
}
