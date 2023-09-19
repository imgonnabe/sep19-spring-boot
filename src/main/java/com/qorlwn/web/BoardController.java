package com.qorlwn.web;

import java.util.List;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
public class BoardController {
	@Autowired
	private BoardService boardService;
	
	@GetMapping("/board")
	public String board() {
		List<Map<String, Object>> list = boardService.boardlist();
		JSONObject json = new JSONObject();
		JSONArray arr = new JSONArray(list);
		json.put("arr", arr);
		System.out.println(json.toString());
		return json.toString();
	}
}
