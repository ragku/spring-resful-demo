package com.ragku.restful.entity;

import java.util.Date;

import com.alibaba.fastjson.annotation.JSONField;

public class World {

	private String id;
	
	private String word;
	
	@JSONField(format="yyyy-MM-dd HH:mm:ss")
	private Date time;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getWord() {
		return word;
	}

	public void setWord(String word) {
		this.word = word;
	}

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }
	
}
