package com.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;

import com.dto.EmpDTO;
import com.dto.PagingDTO;
import com.exception.UserException;

public class EmpDAO {
	public PagingDTO selectAllEmp(SqlSession session, HashMap<String, Object> map, PagingDTO paging) {
		int offset = (paging.getOffset() - 1) * paging.getLimit();
		paging.setList(session.selectList("EmpMapper.selectAllEmp", map, new RowBounds(offset, paging.getLimit())));
		paging.setTotalCount(selectTotalCount(session, map));
		
		return paging;
	}
	
	public int selectTotalCount(SqlSession session, HashMap<String, Object> map) {
		
		return session.selectOne("EmpMapper.selectTotalCount", map);
	}
	
	public int insertEmp(SqlSession session, EmpDTO dto)throws UserException {
		int success = 0;
		int checkEmp = 0;
		checkEmp = selectEmpEmpno(session, dto);
		
		if(checkEmp == 1) {
			throw new UserException("사원번호 중복");
		}

		success = session.insert("EmpMapper.insertEmp", dto);

		return success;
	}
	
	public int selectEmpEmpno(SqlSession session, EmpDTO dto) {
		int checkEmp = 0;
		checkEmp = session.selectOne("EmpMapper.selectEmpEmpno", dto.getEmpno());
		
		return checkEmp;
	}

	public EmpDTO selectEmp(SqlSession session, int empno) throws UserException{
		EmpDTO dto = null;
		
		dto = session.selectOne("EmpMapper.selectEmp", empno);
		if(dto == null) {
			throw new UserException("해당하는 사원번호로 검색 불가");
		}
		
		return dto;
	}

	public List<String> selectEmpJobList(SqlSession session){
		List<String> list = null;
		
		list = session.selectList("EmpMapper.selectEmpJobList");
		
		return list;
	}
	
	public int updateEmp(SqlSession session, EmpDTO dto) {
		int success = 0;
		
		success = session.update("EmpMapper.updateEmp", dto);
		
		return success;
	}

	public int deleteEmp(SqlSession session, int empno) {
		int success = 0;
		
		success = session.delete("EmpMapper.deleteEmp", empno);
		
		return success;
	}
}
