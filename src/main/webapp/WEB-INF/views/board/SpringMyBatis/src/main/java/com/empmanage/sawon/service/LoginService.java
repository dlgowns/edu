package com.empmanage.sawon.service;

import com.empmanage.sawon.vo.TelLoginVO;

public interface LoginService {

	boolean memberInsert(TelLoginVO telLoginVO);
	TelLoginVO memberLogin(TelLoginVO telLoginVO);
	TelLoginVO memberMypage(TelLoginVO telLoginVO);
	boolean memberUpdate(TelLoginVO telLoginVO);
	boolean memberDelete(TelLoginVO telLoginVO);
}
