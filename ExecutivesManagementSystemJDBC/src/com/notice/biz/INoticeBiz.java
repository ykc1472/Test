package com.notice.biz;

import java.util.ArrayList;

import com.notice.entity.Notice;

public interface INoticeBiz {
	public abstract ArrayList<Notice> selectAllNotice();

	public abstract Notice selectDetailNotice(String noticeNum);

	public abstract void noticeUpdate(Notice notice);

	public abstract void noticeDelete(String inputNum);

}
