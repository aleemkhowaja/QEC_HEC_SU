package com.qec.service;
import javax.servlet.http.HttpServletRequest;
import com.qec.model.GoogleCitationModel;
import com.qec.common.JTableList;
public interface GoogleCitationService
{
    public JTableList<GoogleCitationModel> returnAllGoogleCitationForGrid(HttpServletRequest request);

    public GoogleCitationModel returnGoogleCitationById(Integer GoogleCitationId);
}
