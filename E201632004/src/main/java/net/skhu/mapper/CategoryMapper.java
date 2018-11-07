package net.skhu.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import net.skhu.dto.Category;

@Mapper
public interface CategoryMapper {
	List<Category> findAll();
	void insert(Category category);
	void update(Category category);
	void delete(int id);
}
