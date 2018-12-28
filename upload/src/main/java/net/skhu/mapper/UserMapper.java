package net.skhu.mapper;

import org.apache.ibatis.annotations.Mapper;

import net.skhu.model.User;

@Mapper
public interface UserMapper {
	int findOne(String userId); //존재하지 않으면 0
	void insert(User u);
	User login(String userId);
	void update(User u);
}