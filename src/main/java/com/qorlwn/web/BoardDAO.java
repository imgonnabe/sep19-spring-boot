package com.qorlwn.web;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface BoardDAO {

	List<Map<String, Object>> boardlist();

	int write(Map<String, Object> map);

	Map<String, Object> detail(int bno);

	int delete(int bno);

	int update(Map<String, Object> map);

}
