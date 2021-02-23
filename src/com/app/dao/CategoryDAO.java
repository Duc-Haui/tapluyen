package com.app.dao;

import java.util.List;

import com.app.entity.Category;

public class CategoryDAO extends JpaDAO<Category> implements GenericDAO<Category> {

	@Override
	public Category create(Category e) {
		return super.create(e);
	}

	@Override
	public Category update(Category e) {
		return super.update(e);
	}

	@Override
	public Category find(Object categoryId) {
		return super.find(Category.class, categoryId);
	}

	@Override
	public void delete(Object categoryId) {
		super.delete(Category.class, categoryId);
	}

	@Override
	public List<Category> listAll() {
		return super.findWithNameQuery("Category.findAll");
	}

	@Override
	public long count() {
		return super.count("Category.countAll");
	}

}
