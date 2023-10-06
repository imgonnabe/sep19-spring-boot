package com.qorlwn.web;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface BoardDAO {

	List<Map<String, Object>> boardlist(int pageNo);

	int write(Map<String, Object> map);

	Map<String, Object> detail(int bno);

	int delete(int bno);

	int update(Map<String, Object> map);

	List<Map<String, Object>> commentlist(int bno);

	int cwrite(Map<String, Object> map);

	int cdelete(int cno);

	Map<String, Object> login(Map<String, Object> map);

	List<Map<String, Object>> index_members();

	List<Map<String, Object>> index_cmtTop5();

}
