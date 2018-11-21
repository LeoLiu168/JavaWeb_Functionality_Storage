package org.leo.ram.dao.impl;

import java.util.List;

import org.leo.ram.dao.BaseDictDao;
import org.leo.ram.domain.BaseDict;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

public class BaseDictDaoImpl extends HibernateDaoSupport implements BaseDictDao {

	@SuppressWarnings("unchecked")
	@Override
	public List<BaseDict> findByTypeCode(String dict_type_code) {
		return (List<BaseDict>) this.getHibernateTemplate().find("from BaseDict where dict_type_code = ?", dict_type_code);
	}

}
