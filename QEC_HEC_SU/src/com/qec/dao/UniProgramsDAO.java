package com.qec.dao;

import java.util.List;
import com.qec.model.UniProgramsModel;

public interface UniProgramsDAO  {
	
	/**
	 * 
	 * @param jtStartIndex
	 * @param jtPageSize
	 * @param sortingProperty
	 * @param order
	 * @param programsName
	 * @return List<UniProgramsModel>
	 */
	public List<UniProgramsModel> returnAllUniProgramsModelForGrid(int jtStartIndex, int jtPageSize,String sortingProperty, String order, String  programsName);
	
	/**
	 * 
	 * @param programId
	 * @return UniProgramsModel
	 */
	public UniProgramsModel returnUniProgramsModelById(Long programId);
	
	/**
	 * 
	 * @return List<UniProgramsModel>
	 */
	public List<UniProgramsModel> returnAllUniProgramsModel();

	
	
	public UniProgramsModel deleteUniProgramsModelById(Long programId);
}
