package com.beans;

import java.util.ArrayList;

public class QueryBean {
private final String dbName;
private final String query;
public QueryBean(String dbName,String query) {
	// TODO Auto-generated constructor stub
	this.dbName = dbName;
	this.query=query;
}
public String getDbName() {
	return dbName;
}
public String getQuery() {
	return query;
}

}
