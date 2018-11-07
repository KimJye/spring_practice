package net.skhu.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import net.skhu.dto.Book;

@Mapper
public interface BookMapper {

	List<Book> findAll();
	List<Book> findAllWithCategoryPublisher();
	Book findOne(int id);
	void insert(Book book);
	void update(Book book);
	void delete(int id);
}
