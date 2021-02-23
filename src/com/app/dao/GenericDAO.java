package com.app.dao;

import java.util.List;

public interface GenericDAO<E> {
	
	public E create (E e);
	
	public E update(E e);
	
	public E find(Object id);
	
	public void delete(Object id);
	
	public List<E> listAll();
	
	public long count();
}
