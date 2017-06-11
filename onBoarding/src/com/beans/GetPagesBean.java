package com.beans;

import java.util.ArrayList;

public class GetPagesBean {
private String endSiteLoginUrl;
private String siteName;
private String siteId;
private String containerType;

private ArrayList<String> navigationUrls = new ArrayList<String>();
public ArrayList<String> getNavigationUrls() {
	return navigationUrls;
}
public void setNavigationUrls(ArrayList<String> navigationUrls) {
	this.navigationUrls = navigationUrls;
}
public String getEndSiteUrl() {
	return endSiteLoginUrl;
}
public String getEndSiteLoginUrl() {
	return endSiteLoginUrl;
}
public void setEndSiteLoginUrl(String endSiteLoginUrl) {
	this.endSiteLoginUrl = endSiteLoginUrl;
}
public String getSiteId() {
	return getSiteName()+getContainerType();
}
public void setEndSiteUrl(String endSiteUrl) {
	this.endSiteLoginUrl = endSiteUrl;
}
public String getSiteName() {
	return siteName;
}
public void setSiteName(String siteName) {
	this.siteName = siteName;
}
public String getContainerType() {
	return containerType;
}
public void setContainerType(String containerType) {
	this.containerType = containerType;
}
}
