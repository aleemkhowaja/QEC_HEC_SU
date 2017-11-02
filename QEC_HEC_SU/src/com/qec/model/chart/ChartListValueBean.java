package com.qec.model.chart;

import java.util.Date;

public class ChartListValueBean extends ChartBean {
	
	private int name;	// Represents year at Front end charts .
	private boolean showInLegend=false;
	private long data[]=new long[12];  // Represents Months at Front end charts .
	private Date date = new Date();

	public int getName() {
		return name;
	}

	public void setName(int year) {
		this.name = year;
	}

	public long[] getData() {
		return data;
	}

	public void setData(long[] countOfData) {
		this.data = countOfData;
	}

	public boolean isShowInLegend() {
		return showInLegend;
	}

	public void setShowInLegend(boolean showInLegend) {
		this.showInLegend = showInLegend;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
	
	
}
