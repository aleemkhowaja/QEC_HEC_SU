package com.qec.service;
import javax.servlet.http.HttpServletRequest;

import com.qec.common.JTableList;
import com.qec.model.UserModel;
public interface UsersService
{
    public JTableList<UserModel> returnAllUsersForGrid(HttpServletRequest request);

    public UserModel returnUsersById(Integer UsersId);
}
