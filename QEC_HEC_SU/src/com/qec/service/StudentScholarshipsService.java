package com.qec.service;
import javax.servlet.http.HttpServletRequest;
import com.qec.model.StudentScholarshipsModel;
import com.qec.common.JTableList;
public interface StudentScholarshipsService
{
    public JTableList<StudentScholarshipsModel> returnAllStudentScholarshipsForGrid(HttpServletRequest request);

    public StudentScholarshipsModel returnStudentScholarshipsById(Integer StudentScholarshipsId);
}
