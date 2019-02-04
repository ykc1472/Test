package com.config;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

// Configuration.xml
// sqlSessionFactory 얻기
// DeptService에서 사용
public class MySqlSessionFactoty {
	private static SqlSessionFactory sqlSessionFactory = null;

	static {
		String resource = "com/config/Configuration.xml";
		InputStream inputStream = null;
		try {
			inputStream = Resources.getResourceAsStream(resource);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
	}

	public static SqlSession getSession() {
		// new 하지 않고 사용이 할 수 있도록 static으로 선언한다.
		// 로딩에 커넥션까지 다 한 것이다.
		return sqlSessionFactory.openSession();
	}
}
