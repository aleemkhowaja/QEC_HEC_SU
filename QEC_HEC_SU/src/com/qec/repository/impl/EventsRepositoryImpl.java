package com.qec.repository.impl;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.sql.JoinType;
import org.springframework.stereotype.Repository;

import com.qec.model.EventsModel;
import com.qec.model.UniProgramsModel;
import com.qec.model.UserModel;
import com.qec.repository.EventsRepository;


@Repository
public class EventsRepositoryImpl extends SessionFactoryRepositoryImp implements EventsRepository {

	@Override
	public List<EventsModel> returnAllEventsModelForGrid(int jtStartIndex, int jtPageSize, String sortingProperty,String order, String eventTitle) throws Exception 
	{
		Session session =  getSessionFactory().getCurrentSession();
		Criteria criteria = session.createCriteria(EventsModel.class, "em");
		criteria.createAlias("em.departmentsModel", "departmentsModel", JoinType.LEFT_OUTER_JOIN); // left outer join by
		criteria.createAlias("em.userModel", "userModel", JoinType.LEFT_OUTER_JOIN); // left outer join by
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

		if(eventTitle != null && !"".equals(eventTitle))
		{
			criteria.add( Restrictions.like("eventTitle", "%"+eventTitle+"%"));
		}
		criteria.add( Restrictions.eq("isDeleted", false));
		List<EventsModel> results = criteria.list();
		return results;
	}

	@Override
	public EventsModel returnEventsModelById(Long eventsId) throws Exception 
	{
		Session session = getSessionFactory().getCurrentSession();
		Criteria criteria = session.createCriteria(EventsModel.class);
		if(eventsId != null )
		{
			criteria.add( Restrictions.eqOrIsNull("eventsId", eventsId));
		}
		EventsModel eventsModel =  (EventsModel) criteria.uniqueResult();
		return eventsModel;
	}

	@Override
	public List<EventsModel> returnAllEventsModelModel() throws Exception 
	{
		return null;
	}

	@Override
	public EventsModel deleteEventsModelById(Long eventsId) throws Exception
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Long returnAllEventsModelForGridCount(String eventTitle) throws Exception 
	{
		Session session = getSessionFactory().getCurrentSession();
		Criteria criteria = session.createCriteria(EventsModel.class, "em");
		
		if(eventTitle != null && !"".equals(eventTitle))
		{
			criteria.add( Restrictions.like("eventTitle", "%"+eventTitle+"%"));
		}
		criteria.add( Restrictions.eq("isDeleted", false));
		criteria.setProjection(Projections.rowCount());
		Long records = (Long)criteria.uniqueResult();
		return records;
	}

}
