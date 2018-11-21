package org.leo.ram.dao;

import java.util.List;

import org.leo.ram.domain.BaseDict;

public interface BaseDictDao {

	List<BaseDict> findByTypeCode(String dict_type_code);

}
