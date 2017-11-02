package com.qec.service;
import javax.servlet.http.HttpServletRequest;
import com.qec.model.AwardsListModel;
import com.qec.common.JTableList;
public interface AwardsListService
{
    public JTableList<AwardsListModel> returnAllAwardsListForGrid(HttpServletRequest request);

    public AwardsListModel returnAwardsListById(Integer AwardsListId);
}
