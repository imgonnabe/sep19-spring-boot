package com.qorlwn.web;

import java.util.List;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
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
	
	@PostMapping("/write")
	public String write(@RequestBody Map<String, Object> map) {
		System.out.println(map);
		int result = boardService.write(map);
		JSONObject json = new JSONObject();
		json.put("result", result);
		return json.toString();
	}
	
	@GetMapping("/detail")
	public String detail(@RequestParam(name = "bno", required = true) int bno) {
		Map<String, Object> detail = boardService.detail(bno);
		JSONObject json = new JSONObject();
		json.put("detail", detail);
		System.out.println(json.toString());
		return json.toString();
	}
	
	@PostMapping("/delete")
	public String delete(@RequestParam(name = "bno", required = true) int bno) {
		System.out.println(bno);
		int result = boardService.delete(bno);
		JSONObject json = new JSONObject();
		json.put("result", result);
		return json.toString();
	}
	
	@PatchMapping("/update")
	public String update(@RequestBody Map<String, Object> map) {
		System.out.println(map);
		int result = boardService.update(map);
		JSONObject json = new JSONObject();
		json.put("result", result);
		return json.toString();
	}
	
	@GetMapping("/comments")
	public String comments(@RequestParam(name = "bno", required = true) int bno) {
		List<Map<String, Object>> list = boardService.commentlist(bno);
		JSONObject json = new JSONObject();
		JSONArray arr2 = new JSONArray(list);
		json.put("arr2", arr2);
		System.out.println(json.toString());
		return json.toString();
	}
	
	@PostMapping("/cwrite")
	public String cwrite(@RequestBody Map<String, Object> map) {
		System.out.println(map);
		int result = boardService.cwrite(map);
		JSONObject json = new JSONObject();
		json.put("result", result);
		return json.toString();
	}
	
	@PostMapping("/cdelete")
	public String cdelete(@RequestParam(name = "cno", required = true) int cno) {
		System.out.println(cno);
		int result = boardService.cdelete(cno);
		JSONObject json = new JSONObject();
		json.put("result", result);
		return json.toString();
	}
}
