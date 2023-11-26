package com.bimaapp.app.bean;

import java.util.List;

import javax.ejb.EJB;

import com.bimaapp.app.dao.GenericDao;
import com.bimaapp.app.dao.GenericDaoI;
import com.bimaapp.database.MysqlDatabase;

public abstract class GenericBean<T> implements GenericBeanI<T>{

    @EJB
    MysqlDatabase database;

    private final GenericDaoI<T> genericDao = new GenericDao<>();

    @Override
    public void addOrUpdate(T entity) {
        genericDao.setDatabase(database);
        genericDao.addOrUpdate(entity);
        
    }

    @Override
    public void delete(T entity) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public List<T> list(Object entity) {
        genericDao.setDatabase(database);
        return genericDao.list(entity);
    }

    
    public GenericDaoI<T> getDao() {
        genericDao.setDatabase(database);
        return (GenericDaoI<T>) genericDao;
    }
    

    
}
