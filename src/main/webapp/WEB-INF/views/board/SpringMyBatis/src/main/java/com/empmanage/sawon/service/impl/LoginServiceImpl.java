package com.empmanage.sawon.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.empmanage.sawon.service.LoginService;
import com.empmanage.sawon.service.dao.TelLoginDAO;
import com.empmanage.sawon.vo.TelLoginVO;

@Service
public class LoginServiceImpl implements LoginService {

	@Autowired
	private TelLoginDAO dao;
	
	@Override
	@Transactional
	public boolean memberInsert(TelLoginVO telLoginVO) {
		
		return dao.memberInsert(telLoginVO);
	}

	@Override
	@Transactional
	public TelLoginVO memberLogin(TelLoginVO telLoginVO) {
		// TODO Auto-generated method stub
		return dao.memberLogin(telLoginVO);
	}

	@Override
	@Transactional
	public TelLoginVO memberMypage(TelLoginVO telLoginVO) {
		// TODO Auto-generated method stub
		return dao.memberMypage(telLoginVO);
	}

	@Override
	@Transactional
	public boolean memberUpdate(TelLoginVO telLoginVO) {
		// TODO Auto-generated method stub
		return dao.memberUpdate(telLoginVO);
	}

	@Override
	@Transactional
	public boolean memberDelete(TelLoginVO telLoginVO) {
		// TODO Auto-generated method stub
		return dao.memberDelete(telLoginVO);
	}

}
