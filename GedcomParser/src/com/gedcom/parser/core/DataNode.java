package com.gedcom.parser.core;

public class DataNode {
	
	private Integer parent = 0;
	private Integer id = 0;
	private String key = null;
	private String data = null;
	
	
	public DataNode(Integer parent, Integer id, String key, String data) {
		super();
		this.parent = parent;
		this.id = id;
		this.key = key;
		this.data = data;
	}
	
	public Integer getParent() {
		return parent;
	}
	public void setParent(Integer parent) {
		this.parent = parent;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
		
	

}
