package com.qec.service;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import com.qec.common.JQGridDTO;
import com.qec.dto.UniProgramsDTO;
import com.qec.model.DepartmentsModel;
import com.qec.model.UniProgramsModel;

public interface UniProgramsService
{
	/**
	 * return List for Grid
	 * @param request
	 * @return JQGridDTO<UniProgramsModel>
	 */
	public JQGridDTO<UniProgramsDTO> returnAllUniProgramsModelForGrid(HttpServletRequest request);
	
	/**
	 * add/update program in database
	 * @param uniProgramsModel
	 */
	public String saveUniProgramsModel(UniProgramsDTO uniProgramsDTO);
	
	/**
	 * return UniProgramsModel from database by program Id
	 * @param programId
	 * @return UniProgramsModel
	 */
	public UniProgramsModel returnUniProgramsModelById(Integer programId);
	
	/**
	 * return all programs from database
	 * @return List<UniProgramsModel>
	 */ 
	public List<UniProgramsModel> returnAllUniProgramsModel();
	
	
	/**
	 * 
	 * @param uniProgramsId
	 * @return
	 */
	public UniProgramsDTO getUniProgramsModelById(Long uniProgramsId);
	
	/**
	 * 
	 * @param uniProgramsDTO
	 * @return
	 */
	public String deleteUniProgramsModel(UniProgramsDTO uniProgramsDTO);
	
}