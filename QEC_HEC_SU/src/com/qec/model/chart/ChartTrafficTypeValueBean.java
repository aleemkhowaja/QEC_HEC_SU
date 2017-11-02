package com.qec.model.chart;

public class ChartTrafficTypeValueBean extends ChartBean {
	private Integer lightWeigth;
	private Integer heavyWeigth;
	private Integer aadt;
	private Integer link; 
	public ChartTrafficTypeValueBean(Integer lightWeigth, Integer heavyWeigth, Integer aadt,Integer link) {
		super();
		this.lightWeigth = lightWeigth;
		this.heavyWeigth = heavyWeigth;
		this.aadt = aadt;
		this.link= link;
	}
	public Integer getLightWeigth() {
		return lightWeigth;
	}
	public void setLightWeigth(Integer lightWeigth) {
		this.lightWeigth = lightWeigth;
	}
	public Integer getHeavyWeigth() {
		return heavyWeigth;
	}
	public void setHeavyWeigth(Integer heavyWeigth) {
		this.heavyWeigth = heavyWeigth;
	}
	public Integer getAadt() {
		return aadt;
	}
	public void setAadt(Integer aadt) {
		this.aadt = aadt;
	}
	public Integer getLink() {
		return link;
	}
	public void setLink(Integer link) {
		this.link = link;
	}
	
	
	
	
	
	
}
