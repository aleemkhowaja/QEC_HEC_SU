package com.qec.repository;

import java.util.List;
import com.qec.dto.UserDTO;
import com.qec.model.UserModel;

public interface UserRepository {

	/**
	 * return all user models for grid
	 * @param jtStartIndex
	 * @param jtPageSize
	 * @param sortingProperty
	 * @param order
	 * @param username
	 * @return
	 */
	public List<UserModel> returnAllUserModelForGrid(int jtStartIndex, int jtPageSize,String sortingProperty, String order, String  username);
	
	/**
	 * return userModel by user properties
	 * @param userId
	 * @return
	 */
	public UserModel returnUserModelByUserProperties(UserDTO userId);
	
	/**
	 * return all user models
	 * @return
	 */
	public List<UserModel> returnAllUserModel();
	
	/**
	 * delete user model by id
	 * @param userId
	 * @return
	 */
	public UserModel deleteUserModelById(Long userId);
	
	/**
	 * return count od userModels for Grid 
	 * @param username
	 * @return
	 */
	public Long returnAllUserModelForGridCount(String username);
	
	/**
	 * check duplicate User bu username
	 * @param userDTO
	 * @return
	 */
	public UserModel returnCheckDuplicateByUserProperties(UserDTO userDTO);
}
