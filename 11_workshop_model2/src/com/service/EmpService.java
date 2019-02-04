package com.service;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.config.MySqlSessionFactoty;
import com.dao.EmpDAO;
import com.dto.EmpDTO;
import com.dto.PagingDTO;
import com.exception.UserException;

public class EmpService {
	public PagingDTO selectAllEmp(HashMap<String, Object> map, PagingDTO paging){
		SqlSession session = MySqlSessionFactoty.getSession();
		EmpDAO dao = new EmpDAO();

		paging = dao.selectAllEmp(session, map, paging);
		
		if(session != null)
			session.close();
		
		return paging;
	}

	public int insertEmp(EmpDTO dto){
		SqlSession session = MySqlSessionFactoty.getSession();
		EmpDAO dao = new EmpDAO();
		int success = 0;
		
		try {
			success = dao.insertEmp(session, dto);
			session.commit();
		} catch (UserException e) {
			System.out.println(e);
			session.rollback();
		} finally {
			if(session != null)
				session.close();
		} 
			
		return success;
	}

	public EmpDTO SelectEmp(int empno){
		SqlSession session = MySqlSessionFactoty.getSession();
		EmpDAO dao = new EmpDAO();
		EmpDTO dto = null;
		
		try {
			dto = dao.selectEmp(session, empno);
			
		} catch (UserException e) {
			System.out.println(e);
			
		} finally {
			if(session != null)
				session.close();
		} 
		
		return dto;
	}

	public List<String> selectEmpJobList(){
		SqlSession session = MySqlSessionFactoty.getSession();
		EmpDAO dao = new EmpDAO();
		List<String> list = null;
		
		list = dao.selectEmpJobList(session);
		
		if(session != null)
			session.close();
		
		return list;
	}
	
	public int updateEmp(EmpDTO dto) {
		int success = 0;
		SqlSession session = MySqlSessionFactoty.getSession();
		EmpDAO dao = new EmpDAO();
		
		success = dao.updateEmp(session, dto);
		
		if(success == 1) {
			session.commit();
		} else {
			session.rollback();
		}
		
		if(session != null)
			session.close();
		
		return success;
	}
	
	public int deleteEmp(int empno) {
		int success = 0;
		SqlSession session = MySqlSessionFactoty.getSession();
		EmpDAO dao = new EmpDAO();
		
		success = dao.deleteEmp(session, empno);
		
		if(success == 1) {
			session.commit();
		} else {
			session.rollback();
		}
		
		if(session != null)
			session.close();

		return success;
	}
	
}
