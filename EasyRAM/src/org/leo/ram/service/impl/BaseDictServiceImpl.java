package org.leo.ram.service.impl;

import java.util.List;

import org.leo.ram.dao.BaseDictDao;
import org.leo.ram.domain.BaseDict;
import org.leo.ram.service.BaseDictService;

public class BaseDictServiceImpl implements BaseDictService {
	
	//注入Dao
	private BaseDictDao baseDictDao;

	public void setBaseDictDao(BaseDictDao baseDictDao) {
		this.baseDictDao = baseDictDao;
	}

	@Override
	public List<BaseDict> findByTypeCode(String dict_type_code) {
		return baseDictDao.findByTypeCode(dict_type_code);
	}

}
