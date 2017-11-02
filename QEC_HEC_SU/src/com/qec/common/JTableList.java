package com.qec.common;

import java.io.Serializable;
import java.util.List;

public class JTableList<L> implements Serializable {

	private static final long serialVersionUID = 6695625930049463695L;

	private String Result = "ERROR";
	private List<L> Records;
	private List<JTableCombo> Options; 
	private long TotalRecordCount;
//	private GenericModel model;
	//private GenericModel Record;
	public String Message;

	public String getResult() {
		return Result;
	}

	public void setResult(String result) {
		Result = result;
	}

	public List<L> getRecords() {
		return Records;
	}

	public void setRecords(List<L> records) {
		Records = records;
	}

	public List<JTableCombo> getOptions() {
		return Options;
	}

	public void setOptions(List<JTableCombo> options) {
		Options = options;
	}

	public long getTotalRecordCount() {
		return TotalRecordCount;
	}

	public void setTotalRecordCount(long totalRecordCount) {
		TotalRecordCount = totalRecordCount;
	}

/*	public GenericModel getModel() {
		return model;
	}

	public void setModel(GenericModel model) {
		this.model = model;
	}

	public GenericModel getRecord() {
		return Record;
	}

	public void setRecord(GenericModel record) {
		Record = record;
	}*/

	public String getMessage() {
		return Message;
	}

	public void setMessage(String message) {
		Message = message;
	}

}
