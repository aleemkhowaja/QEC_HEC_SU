package com.qec.service;
import javax.servlet.http.HttpServletRequest;
import com.qec.model.CitationChapterModel;
import com.qec.common.JTableList;
public interface CitationChapterService
{
    public JTableList<CitationChapterModel> returnAllCitationChapterForGrid(HttpServletRequest request);

    public CitationChapterModel returnCitationChapterById(Integer CitationChapterId);
}
