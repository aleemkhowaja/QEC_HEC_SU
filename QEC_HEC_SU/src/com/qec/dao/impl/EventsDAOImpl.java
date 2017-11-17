package com.qec.dao.impl;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import com.qec.dao.EventsDAO;
import com.qec.model.EventsModel;
import com.qec.model.UniProgramsModel;


@Repository
public class EventsDAOImpl extends SessionFactoryDAOImp implements EventsDAO {

	@Override
	public List<EventsModel> returnAllEventsModelForGrid(int jtStartIndex, int jtPageSize, String sortingProperty,String order, String eventTitle) throws Exception 
	{
		Session session =  getSessionFactory().getCurrentSession();
		Criteria criteria = session.createCriteria(EventsModel.class, "em");
		criteria.createAlias("em.departmentsModel", "departmentsModel"); // inner join by
		criteria.setFetchMode("departmentsModel", FetchMode.JOIN);
		criteria.createAlias("em.userModel", "userModel"); // inner join by
		criteria.setFetchMode("userModel", FetchMode.JOIN);
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
		Criteria criteria = session.createCriteria(EventsModel.class);
		
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
