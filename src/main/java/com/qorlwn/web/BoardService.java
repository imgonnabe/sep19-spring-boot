package com.qorlwn.web;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BoardService {
	@Autowired
	private BoardDAO boardDAO;

	public List<Map<String, Object>> boardlist() {
		return boardDAO.boardlist();
	}

	public int write(Map<String, Object> map) {
		map.put("bip", "172.30.1.10");
		map.put("m_id", "aaaa");
		return boardDAO.write(map);
	}

	public Map<String, Object> detail(int bno) {
		return boardDAO.detail(bno);
	}

	public int delete(int bno) {
		return boardDAO.delete(bno);
	}

	public int update(Map<String, Object> map) {
		return boardDAO.update(map);
	}

	public List<Map<String, Object>> commentlist(int bno) {
		return boardDAO.commentlist(bno);
	}

	public int cwrite(Map<String, Object> map) {
		return boardDAO.cwrite(map);
	}

	public int cdelete(int cno) {
		return boardDAO.cdelete(cno);
	}

}
