package com.qec.dao;

import java.util.List;
import com.qec.model.UserModel;

public interface UserDAO {

	public List<UserModel> returnAllUserModelForGrid(int jtStartIndex, int jtPageSize,String sortingProperty, String order, String  username);
	
	public UserModel returnUserModelById(Long userId);
	
	public List<UserModel> returnAllUserModel();
	
	public UserModel deleteUserModelById(Long userId);
	
	public Long returnAllUserModelForGridCount(String username);
}
