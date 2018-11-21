package org.leo.ram.service;

import java.util.List;

import org.leo.ram.domain.BaseDict;

public interface BaseDictService {

	List<BaseDict> findByTypeCode(String dict_type_code);

}
