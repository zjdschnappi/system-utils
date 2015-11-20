package com.system.utils.session;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.HibernateTemplate;

public class SessionDao {
	private HibernateTemplate hibernateTemplete;

	public void setHibernateTemplete(HibernateTemplate hibernateTemplete) {
		this.hibernateTemplete = hibernateTemplete;
	}

	public HibernateTemplate getHibernateTemplate() {
		return this.hibernateTemplete;
	}

	public SessionBean add(SessionBean sessionBean) {
		try {
			hibernateTemplete.save(sessionBean);
			return sessionBean;
		} catch (Exception e) {
			return null;
		}
	};

	public boolean delete(final SessionBean sessionBean) {
		SessionBean sessionChan = (SessionBean) hibernateTemplete
				.execute(new HibernateCallback() {
					@Override
					public Object doInHibernate(Session session)
							throws HibernateException, SQLException {
						String hql = "delete from SessionBean where sessionId = ?";
						Query query = session.createQuery(hql);
						query.setString(0, sessionBean.getSessionId());
						if (query.executeUpdate() == 1) {
							return sessionBean;
						} else {
							return null;
						}
					}
				});
		if(sessionChan == null){
			return false;
		}else{
			return true;
		}
	};

	public SessionBean update(final SessionBean sessionBean) {
		return (SessionBean) hibernateTemplete
		.execute(new HibernateCallback() {
			@Override
			public Object doInHibernate(Session session)
					throws HibernateException, SQLException {
				String hql = "update SessionBean e set e.dieTime =? where e.sessionId = ?";
				Query query = session.createQuery(hql);
				Date date = new Date();
				date.setMinutes(date.getMinutes()+20);
				query.setTimestamp(0, date);
				query.setString(1, sessionBean.getSessionId());
				if (query.executeUpdate() == 1) {
					return sessionBean;
				} else {
					return null;
				}
			}
		});
	};

	public SessionBean findBySessionId(String sessionId) {
		String hql = "from SessionBean where sessionId = ?";
		List<SessionBean> sessionBean = hibernateTemplete.find(hql,sessionId);
		if (sessionBean.size() == 0) {
			return null;
		} else {
			return sessionBean.get(0);
		}
	};
}
