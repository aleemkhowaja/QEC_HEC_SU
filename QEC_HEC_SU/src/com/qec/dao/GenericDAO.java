/**
 * 
 */
package com.qec.dao;

import com.qec.model.Model;

/**
 * @author Alim
 *
 */
public interface GenericDAO {

	/**
	 * 
	 * @param model
	 * @throws Exception
	 */
	public void save(Model model) throws Exception;
	
	/**
	 * 
	 * @param model
	 * @throws Exception
	 */
	public void update(Model model) throws Exception;
	
	/**
	 * 
	 * @param model
	 * @throws Exception
	 */
	public void delete(Model model) throws Exception;
}
