package com.qec.model.chart;

public class ChartStringValueBean extends ChartBean {
	private long countOfData;
	private String stringTypeValues;
	
	
	
	public ChartStringValueBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ChartStringValueBean(long countOfData, String stringTypeValues) {
		super();
		this.countOfData = countOfData;
		this.stringTypeValues = stringTypeValues;
	}
	public long getCountOfData() {
		return countOfData;
	}
	public void setCountOfData(long countOfData) {
		this.countOfData = countOfData;
	}
	public String getStringTypeValues() {
		return stringTypeValues;
	}
	public void setStringTypeValues(String stringTypeValues) {
		this.stringTypeValues = stringTypeValues;
	}
	
	
	
	
	
	
}
