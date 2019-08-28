package com.example.dosan.service;

import java.util.HashMap;
import java.util.Map;

import com.example.dosan.repository.ProductRepository;
import com.example.dosan.repository.ShareDao;
import com.example.dosan.util.CommonUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    @Autowired
    private ProductRepository repository;

    @Autowired
    private ShareDao dao;

    @Autowired
    private CommonUtil commonUtil;

    public Object getList(Object dataMap) {
        String sqlMapId = "product.list";

        Object resultObject = new HashMap<>();
        // ((Map<String, Object>) resultObject).put("resultList", dao.getList(sqlMapId,
        // dataMap));
        ((Map<String, Object>) resultObject).put("resultList", repository.findAll());

        return resultObject;
    }

    public Object getObject(Object dataMap) {
        String sqlMapId = "product.read";

        Object resultObject = dao.getObject(sqlMapId, dataMap);

        return resultObject;
    }

    public Object saveObject(Map<String, Object> dataMap) {
        String uniqueSequence = (String) dataMap.get("NAME");

        if ("".equals(uniqueSequence)) {
            uniqueSequence = commonUtil.getUniqueSequence();
        }
        dataMap.put("NAME", uniqueSequence);

        String sqlMapId = "product.insert";

        Integer resultKey = (Integer) dao.saveObject(sqlMapId, dataMap);

        Object resultObject = this.getObject(dataMap);

        return resultObject;
    }

    public Object updateObject(Map<String, Object> dataMap) {
        String sqlMapId = "product.update";

        Integer resultKey = (Integer) dao.saveObject(sqlMapId, dataMap);

        Object resultObject = this.getObject(dataMap);

        return resultObject;

    }

    public Object deleteObject(Object dataMap) {
        String sqlMapId = "product.delete";

        Integer resultKey = (Integer) dao.deleteObject(sqlMapId, dataMap);

        Object resultObject = this.getList(dataMap);

        return resultObject;
    }
}
