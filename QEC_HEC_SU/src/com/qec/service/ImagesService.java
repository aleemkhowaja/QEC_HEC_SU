package com.qec.service;
import javax.servlet.http.HttpServletRequest;
import com.qec.model.ImagesModel;
import com.qec.common.JTableList;
public interface ImagesService
{
    public JTableList<ImagesModel> returnAllImagesForGrid(HttpServletRequest request);

    public ImagesModel returnImagesById(Integer ImagesId);
}
