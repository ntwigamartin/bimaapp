package com.bimaapp.app.bean;

import java.io.Serializable;
import java.util.List;

public interface GenericBeanI<T> extends Serializable{
    List<T> list(Object entity);

    void addOrUpdate(T entity);

    void delete(T entity);
}
