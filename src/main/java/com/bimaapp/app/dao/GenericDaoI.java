package com.bimaapp.app.dao;

import java.io.Serializable;
import java.util.List;

import com.bimaapp.database.MysqlDatabase;

public interface GenericDaoI <T> extends Serializable {

  List<T> list(Object entity);

    void addOrUpdate(T entity);

    void delete(T entity);

    MysqlDatabase getDatabase();

    void setDatabase(MysqlDatabase database);

}
