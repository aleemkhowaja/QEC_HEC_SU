package com.qec.service;
import javax.servlet.http.HttpServletRequest;
import com.qec.model.LoginsHistoryModel;
import com.qec.common.JTableList;
public interface LoginsHistoryService
{
    public JTableList<LoginsHistoryModel> returnAllLoginsHistoryForGrid(HttpServletRequest request);

    public LoginsHistoryModel returnLoginsHistoryById(Integer LoginsHistoryId);
}
