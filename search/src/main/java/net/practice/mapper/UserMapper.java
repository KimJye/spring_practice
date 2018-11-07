package net.practice.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import net.practice.dto.User;

@Mapper
public interface UserMapper {
	List<User> findAllOrderBy(@Param("count") int count, @Param("order") String order);
	List<User> findByNameOrUserid(User user);
	List<User> findByNameOrUserid2(User user);
	List<User> findByIdList(@Param("idList") int[] idList);
	void update(User user);
}
