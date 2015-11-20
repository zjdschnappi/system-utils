package com.system.utils;

import org.hibernate.dialect.MySQL5InnoDBDialect;

public class DialectForInkfish extends MySQL5InnoDBDialect{
	public DialectForInkfish() {
		 super();
		 registerHibernateType(-1, "string");
	}
}
