package com.qorlwn.web;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController // view가 없을 때
@RequestMapping("/api")
public class BoardController {
	@Autowired
	private BoardService boardService;
	
	@GetMapping("/board")
	public String board(@RequestParam(name = "pageNo", required = false, defaultValue = "1") int pageNo) {
		System.out.println(pageNo);
		List<Map<String, Object>> list = boardService.boardlist(pageNo);
		JSONObject json = new JSONObject();
		JSONArray arr = new JSONArray(list);
		json.put("arr", arr);
		json.put("pageNo", pageNo);
		json.put("totalcount", list.get(0).get("totalcount"));
		System.out.println(list.get(0).get("totalcount"));
		// System.out.println(json.toString());
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
	
	@PostMapping("/login")
	public String login(@RequestBody Map<String, Object> map, HttpServletRequest request) {
		System.out.println(map);
		Map<String, Object> result = boardService.login(map);
		HttpSession session = request.getSession();
		String count = String.valueOf(result.get("count"));
		if(count.equals("1")) {
			session.setAttribute("m_name", result.get("m_name"));
			session.setAttribute("m_id", result.get("m_id"));
		}
		System.out.println(result);
		System.out.println("session에 " + session.getAttribute("m_name"));
		JSONObject json = new JSONObject();
		json.put("result", result);
		return json.toString();
	}
	
	   @GetMapping("/index")
	   public String index() {
	      JSONObject json = new JSONObject();
	      // 최신글
	      List<Map<String, Object>> list = boardService.boardlist(1);
	      JSONArray jsonList = new JSONArray(list);
	      json.put("list", jsonList);
	      
	      // 가입자
	      List<Map<String, Object>> index_members = boardService.index_members();
	      JSONArray members = new JSONArray(index_members);
	      json.put("members", members);
	      
	      // 댓글 많은 순
	      List<Map<String, Object>> index_cmtTop5 = boardService.index_cmtTop5();
	      JSONArray cmtTop5 = new JSONArray(index_cmtTop5);
	      json.put("cmtTop5", cmtTop5);
	      return json.toString();
	   }
}
