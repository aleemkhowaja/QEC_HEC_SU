package com.qec.model.chart;

public class ChartValuesBean extends ChartBean{
	private long countOfData;
	private int intTypeValues;
	public ChartValuesBean() {
		super();
	}
	public ChartValuesBean(long countOfData, int intTypeValues) {
		super();
		this.countOfData = countOfData;
		this.intTypeValues = intTypeValues;
	}
	public long getCountOfData() {
		return countOfData;
	}
	public void setCountOfData(long countOfData) {
		this.countOfData = countOfData;
	}
	public int getIntTypeValues() {
		return intTypeValues;
	}
	public void setIntTypeValues(int intTypeValues) {
		this.intTypeValues = intTypeValues;
	}
}
