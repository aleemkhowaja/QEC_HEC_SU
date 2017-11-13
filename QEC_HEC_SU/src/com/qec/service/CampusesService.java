package com.qec.service;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import com.qec.model.CampusesModel;
import com.qec.common.JTableList;
import com.qec.dto.CampusesDTO;

public interface CampusesService
{
    public JTableList<CampusesModel> returnAllCampusesForGrid(HttpServletRequest request);

    public CampusesModel returnCampusesById(Integer CampusesId);
    
    public List<CampusesDTO> returnAllCampuses();
}
