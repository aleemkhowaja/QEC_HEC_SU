package com.qec.service;
import javax.servlet.http.HttpServletRequest;
import com.qec.model.ProgramHistoryModel;
import com.qec.common.JTableList;
public interface ProgramHistoryService
{
    public JTableList<ProgramHistoryModel> returnAllProgramHistoryForGrid(HttpServletRequest request);

    public ProgramHistoryModel returnProgramHistoryById(Integer ProgramHistoryId);
}
