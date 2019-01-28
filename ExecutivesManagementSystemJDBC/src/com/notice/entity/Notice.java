package com.notice.entity;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.common.util.CommonUtil;

public class Notice {
	private int no;
	private String title;
	private String content;
	private String name;
	private String writeday;

	public Notice() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Notice(int no, String title, String content, String name, String writeday) {
		super();
		this.no = no;
		this.title = title;
		this.content = content;
		this.name = name;
		this.writeday = writeday;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getWriteday() {
		return writeday;
	}

	public void setWriteday(String writeday) {
		this.writeday = writeday;
	}

	@Override
	public String toString() {
		CommonUtil common = new CommonUtil();
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date d = null;
		try {
			d = sdf.parse(writeday);
		}catch(ParseException e) {
			e.printStackTrace();
		}
		
		return no + "\t" + title + "\t\t"+ name + "\t\t" + common.getDate(d);
	}
	
}
