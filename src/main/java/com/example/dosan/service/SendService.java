package com.example.dosan.service;

import java.util.HashMap;
import java.util.Map;

import com.example.dosan.repository.SendRepository;
import com.example.dosan.repository.ShareDao;
import com.example.dosan.util.CommonUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SendService {

	@Autowired
	private SendRepository repository;

	@Autowired
	private ShareDao dao;

	@Autowired
	private CommonUtil commonUtil;

	public Object getList(Object dataMap) {
		String sqlMapId = "send.list";

		Object resultObject = new HashMap<>();
		// ((Map<String, Object>) resultObject).put("resultList", dao.getList(sqlMapId,
		// dataMap));
		((Map<String, Object>) resultObject).put("resultList", repository.findAll());

		return resultObject;
	}

	public Object getObject(Object dataMap) {
		String sqlMapId = "send.read";

		Object resultObject = dao.getObject(sqlMapId, dataMap);

		return resultObject;
	}

	public Object saveObject(Map<String, Object> dataMap) {
		String uniqueSequence = (String) dataMap.get("ACCOUNT_NUM");

		if ("".equals(uniqueSequence)) {
			uniqueSequence = commonUtil.getUniqueSequence();
		}
		dataMap.put("ACCOUNT_NUM", uniqueSequence);

		String sqlMapId = "send.insert";

		Integer resultKey = (Integer) dao.saveObject(sqlMapId, dataMap);

		Object resultObject = this.getObject(dataMap);

		return resultObject;
	}

	public Object updateObject(Map<String, Object> dataMap) {
		String sqlMapId = "send.update";

		Integer resultKey = (Integer) dao.saveObject(sqlMapId, dataMap);

		Object resultObject = this.getObject(dataMap);

		return resultObject;

	}

	public Object deleteObject(Object dataMap) {
		String sqlMapId = "send.delete";

		Integer resultKey = (Integer) dao.deleteObject(sqlMapId, dataMap);

		Object resultObject = this.getList(dataMap);

		return resultObject;
	}
}
