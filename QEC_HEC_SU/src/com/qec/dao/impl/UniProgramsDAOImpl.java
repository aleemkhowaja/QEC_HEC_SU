package com.qec.dao.impl;

import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.hibernate.sql.JoinType;
import org.springframework.stereotype.Repository;
import com.qec.dao.UniProgramsDAO;
import com.qec.model.DepartmentsModel;
import com.qec.model.UniProgramsModel;

@Repository
public class UniProgramsDAOImpl extends SessionFactoryDAOImp implements UniProgramsDAO {

	@Override
	public List<UniProgramsModel> returnAllUniProgramsModelForGrid(int jtStartIndex, int jtPageSize, String sortingProperty, String order, String programsName) {
		Session session =  getSessionFactory().getCurrentSession();
		Criteria criteria = session.createCriteria(UniProgramsModel.class, "um");
		criteria.createAlias("um.departmentsModel", "departmentsModel"); // inner join by
		criteria.setFetchMode("departmentsModel", FetchMode.JOIN);
		criteria.setMaxResults(jtPageSize);
		criteria.setFirstResult(jtStartIndex);
		if(order.equals("asc"))
		{
			// To sort records in ascending order
			criteria.addOrder(Order.asc(sortingProperty));
		}else {
			// To sort records in ascending order
			criteria.addOrder(Order.desc(sortingProperty));
		}

		if(programsName != null && !"".equals(programsName))
		{
			criteria.add( Restrictions.like("name", "%"+programsName+"%"));
		}
		criteria.add( Restrictions.eq("isDeleted", false));
		List<UniProgramsModel> results = criteria.list();
		return results;
	}

	@Override
	public UniProgramsModel returnUniProgramsModelById(Long uniProgramsId)  {
		
		Session session = getSessionFactory().getCurrentSession();
		Criteria criteria = session.createCriteria(UniProgramsModel.class);
		if(uniProgramsId != null )
		{
			criteria.add( Restrictions.eqOrIsNull("uniProgramsId", uniProgramsId));
		}
		UniProgramsModel uniProgramsModel =  (UniProgramsModel) criteria.uniqueResult();
		return uniProgramsModel;
	}

	@Override
	public List<UniProgramsModel> returnAllUniProgramsModel() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UniProgramsModel deleteUniProgramsModelById(Long programId) {
		// TODO Auto-generated method stub
		return null;
	}

}
