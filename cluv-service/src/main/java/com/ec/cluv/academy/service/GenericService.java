package com.ec.cluv.academy.service;

import java.util.List;

public interface GenericService<T, V> {

	T create(T obj) throws Exception;

	List<T> findAll();

	T findById(V id);

	//T update(T obj) throws InvocationTargetException, IllegalAccessException;

	boolean delete(V id);
}
