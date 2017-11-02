package com.qec.service;
import javax.servlet.http.HttpServletRequest;
import com.qec.model.CitationBookModel;
import com.qec.common.JTableList;
public interface CitationBookService
{
    public JTableList<CitationBookModel> returnAllCitationBookForGrid(HttpServletRequest request);

    public CitationBookModel returnCitationBookById(Integer CitationBookId);
}
