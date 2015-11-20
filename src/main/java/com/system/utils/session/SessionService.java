package com.system.utils.session;

import java.util.Date;

public class SessionService {

	private SessionDao sessionDao;

	public SessionDao getSessionDao() {
		return sessionDao;
	}

	public void setSessionDao(SessionDao sessionDao) {
		this.sessionDao = sessionDao;
	}

	public SessionBean add(SessionBean sessionBean) throws Exception {
		if(isExistSession(sessionBean.getSessionId())){
			return sessionBean;
		}else{
			SessionBean sessionAdd = sessionDao.add(sessionBean);
			if (sessionAdd == null) {
				return null;
			} else {
				return sessionAdd;
			}
		}
	}

	public boolean isExistSession(String sessionId) {
		SessionBean sessionBean = sessionDao.findBySessionId(sessionId);
		if(sessionBean==null){
			return false;
		}else{
			return true;
		}
	}
	
	public boolean isAliveSession(String sessionId){
		SessionBean sessionBean = sessionDao.findBySessionId(sessionId);
		Date date = new Date();
		if(date.after(sessionBean.getDieTime())){
			return true;
		}else{
			return false;
		}
	}
	
	public SessionBean update(String sessionId){
		Date date = new Date();
		date.setMinutes(date.getMinutes()+20);
		SessionBean sessionBean = new SessionBean();
		sessionBean.setSessionId(sessionId);
		sessionBean.setDieTime(date);
		return sessionDao.update(sessionBean);
	}
}
