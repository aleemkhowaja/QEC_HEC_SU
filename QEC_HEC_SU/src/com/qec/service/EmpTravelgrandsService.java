package com.qec.service;
import javax.servlet.http.HttpServletRequest;
import com.qec.model.EmpTravelgrandsModel;
import com.qec.common.JTableList;
public interface EmpTravelgrandsService
{
    public JTableList<EmpTravelgrandsModel> returnAllEmpTravelgrandsForGrid(HttpServletRequest request);

    public EmpTravelgrandsModel returnEmpTravelgrandsById(Integer EmpTravelgrandsId);
}
