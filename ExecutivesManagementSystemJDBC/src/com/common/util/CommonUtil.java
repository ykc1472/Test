package com.common.util;

import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class CommonUtil {
	public String getCurrency(int date) {
		NumberFormat nf = NumberFormat.getCurrencyInstance(Locale.KOREA);
		String str = nf.format(date);
		return str;
	}
	public String getDate(Date d) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String formatData = sdf.format(d.getTime());
		return formatData;
	}
	public Date getDate(String cal) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date d = null;
		try {
			d = sdf.parse(cal);
		}catch(ParseException e) {
			e.printStackTrace();
		}
		
		return d;
	}
}
