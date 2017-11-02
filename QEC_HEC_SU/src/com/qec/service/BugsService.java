package com.qec.service;
import javax.servlet.http.HttpServletRequest;
import com.qec.model.BugsModel;
import com.qec.common.JTableList;
public interface BugsService
{
    public JTableList<BugsModel> returnAllBugsForGrid(HttpServletRequest request);

    public BugsModel returnBugsById(Integer BugsId);
}
