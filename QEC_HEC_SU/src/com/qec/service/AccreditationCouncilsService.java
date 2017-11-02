package com.qec.service;
import javax.servlet.http.HttpServletRequest;

import com.qec.common.JTableList;
import com.qec.model.AccreditationCouncilModel;
public interface AccreditationCouncilsService
{
    public JTableList<AccreditationCouncilModel> returnAllAccreditationCouncilsForGrid(HttpServletRequest request);

    public AccreditationCouncilModel returnAccreditationCouncilsById(Integer AccreditationCouncilsId);
}
