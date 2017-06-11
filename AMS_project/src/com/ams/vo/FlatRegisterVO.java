package com.ams.vo;

public class FlatRegisterVO 
{
	private String flatTypeId;
	private String blockName;
	private String floorNo;
	private String flatNo;
	private String ownerId;
	private String ownerName;
	private String contact;
	private String yearOfConst;
	private String rent;
	private String advancInMonth;
	private String address;
	private String status;
	private String proof;
	private int totalFlats;
	private int totalFloors;
	private String flatCategory;
	
	public String getFlatCategory() {
		return flatCategory;
	}
	public void setFlatCategory(String flatCategory) {
		this.flatCategory = flatCategory;
	}
	public int getTotalFlats() {
		return totalFlats;
	}
	public void setTotalFlats(int totalFlats) {
		this.totalFlats = totalFlats;
	}
	public int getTotalFloors() {
		return totalFloors;
	}
	public void setTotalFloors(int totalFloors) {
		this.totalFloors = totalFloors;
	}
	public String getOwnerId() {
		return ownerId;
	}
	public void setOwnerId(String ownerId) {
		this.ownerId = ownerId;
	}
	public String getFlatTypeId(){
		return flatTypeId;
	}
	public void setFlatTypeId(String flatTypeId) {
		this.flatTypeId = flatTypeId;
	}
	
	public String getBlockName() {
		return blockName;
	}
	public void setBlockName(String blockName) {
		this.blockName = blockName;
	}
	public String getFloorNo() {
		return floorNo;
	}
	public void setFloorNo(String floorNo) {
		this.floorNo = floorNo;
	}
	public String getFlatNo() {
		return flatNo;
	}
	public void setFlatNo(String flatNo) {
		this.flatNo = flatNo;
	}
	public String getOwnerName() {
		return ownerName;
	}
	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	public String getYearOfConst() {
		return yearOfConst;
	}
	public void setYearOfConst(String yearOfConst) {
		this.yearOfConst = yearOfConst;
	}
	public String getRent() {
		return rent;
	}
	public void setRent(String rent) {
		this.rent = rent;
	}
	public String getAdvancInMonth() {
		return advancInMonth;
	}
	public void setAdvancInMonth(String advancInMonth) {
		this.advancInMonth = advancInMonth;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getProof() {
		return proof;
	}
	public void setProof(String proof) {
		this.proof = proof;
	}
	
	
}
