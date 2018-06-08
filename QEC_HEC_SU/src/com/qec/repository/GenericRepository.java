/**
 * 
 */
package com.qec.repository;

import com.qec.model.Model;

/**
 * @author Alim
 *
 */
public interface GenericRepository {

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
