package com.example.dosan.service;

import java.util.HashMap;
import java.util.Map;

import com.example.dosan.repository.ManageRepository;
import com.example.dosan.repository.ShareDao;
import com.example.dosan.util.CommonUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ManageService {

    @Autowired
    private ManageRepository repository;

    @Autowired
    private ShareDao dao;

    @Autowired
    private CommonUtil commonUtil;

    public Object getList(Object dataMap) {
        String sqlMapId = "manage.list";

        Object resultObject = dao.getList(sqlMapId, dataMap);

        return resultObject;
    }

    public Object getObject(Object dataMap) {
        String sqlMapId = "manage.read";

        Object resultObject = dao.getObject(sqlMapId, dataMap);

        return resultObject;
    }

    public Object saveObject(Map<String, Object> dataMap) {
        String uniqueSequence = (String) dataMap.get("ACCOUNT_NUM");

        if ("".equals(uniqueSequence)) {
            uniqueSequence = commonUtil.getUniqueSequence();
        }
        dataMap.put("ACCOUNT_NUM", uniqueSequence);

        String sqlMapId = "manage.insert";

        Integer resultKey = (Integer) dao.saveObject(sqlMapId, dataMap);

        Object resultObject = this.getObject(dataMap);

        return resultObject;
    }

    public Object updateObject(Map<String, Object> dataMap) {
        String sqlMapId = "manage.edit";

        Integer resultKey = (Integer) dao.saveObject(sqlMapId, dataMap);

        Object resultObject = this.getObject(dataMap);

        return resultObject;

    }

    public Object deleteObject(Object dataMap) {
        String sqlMapId = "manage.delete";

        Integer resultKey = (Integer) dao.deleteObject(sqlMapId, dataMap);

        Object resultObject = this.getList(dataMap);

        return resultObject;
    }
}
