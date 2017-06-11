package com.ams.vo;

public class SearchApartmentVO 
{
	private String flatType;
	private String[] blockID;
	private int minimumRent;
	private int maximumRent;
	private int minimumAdvance;
	private int maximumAdvance;
	private String flatCategory;
	

	public String getFlatType() {
		return flatType;
	}
	public void setFlatType(String flatType) {
		this.flatType = flatType;
	}
	
	public String[] getBlockID() {
		return blockID;
	}

	public void setBlockID(String[] blockID) {
		this.blockID = blockID;
	}
	public int getMinimumRent() {
		return minimumRent;
	}
	public void setMinimumRent(int minimumRent) {
		this.minimumRent = minimumRent;
	}
	public int getMaximumRent() {
		return maximumRent;
	}
	public void setMaximumRent(int maximumRent) {
		this.maximumRent = maximumRent;
	}
	public int getMinimumAdvance() {
		return minimumAdvance;
	}
	public void setMinimumAdvance(int minimumAdvance) {
		this.minimumAdvance = minimumAdvance;
	}
	public int getMaximumAdvance() {
		return maximumAdvance;
	}
	public void setMaximumAdvance(int maximumAdvance) {
		this.maximumAdvance = maximumAdvance;
	}
	public String getFlatCategory() {
		return flatCategory;
	}
	public void setFlatCategory(String flatCategory) {
		this.flatCategory = flatCategory;
	}
	

}
