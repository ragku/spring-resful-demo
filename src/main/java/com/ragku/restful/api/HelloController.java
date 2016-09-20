package com.ragku.restful.api;

import java.util.Date;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;
import com.ragku.restful.entity.World;

@RestController
@RequestMapping("/hello")
public class HelloController {

	@GetMapping
	public World say(@RequestParam("word") String word) {
	    World w = new World();
	    w.setId("1");
	    w.setWord("hello~" + word);
	    w.setTime(new Date());
	    return w;
	}
	
	@PostMapping
	public void addHelo(@RequestBody World world) {
	    System.out.println(JSONObject.toJSONString(world));
	}
}
