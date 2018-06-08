package com.qec.service;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.qec.common.JQGridDTO;
import com.qec.dto.EmployeeTrainingDTO;
public interface EmployeeTrainingService
{
	/**
	 * return all employee Training Detail Grid data
	 * @param request
	 * @return
	 */
    public JQGridDTO<EmployeeTrainingDTO> returnAllEmployeeTrainingsForGrid(HttpServletRequest request);

    /**
     * return employee training by id
     * @param EmpTrainingsId
     * @return
     */
    public EmployeeTrainingDTO returnEmpTrainingsById(Long employeeTrainingsId);
    
    
    /**
     * insert record in Employee Training table
     * @param employeeDTO
     * @return
     */
    public String saveEmployeeTraining(MultipartHttpServletRequest request);
	
    /**
     * delete Employee Training Record
     * @param employeeDTO
     * @return
     */
	public String deleteEmployeesTraining(Long employeeTrainingsId);

	/**
	 * return EmployeeTrainingDTO by employee id
	 * @param EmployeesId
	 * @return
	 */
    public EmployeeTrainingDTO returnEmployeesTrainingById(Long employeesTrainingId);

    /**
     * return all employee training DTO models
     * @return
     */
    public List<EmployeeTrainingDTO> returnAllEmployeeTrainingModels();
    
}
