package com.qec.service;
import javax.servlet.http.HttpServletRequest;
import com.qec.model.PromotionsModel;
import com.qec.common.JTableList;
public interface PromotionsService
{
    public JTableList<PromotionsModel> returnAllPromotionsForGrid(HttpServletRequest request);

    public PromotionsModel returnPromotionsById(Integer PromotionsId);
}
