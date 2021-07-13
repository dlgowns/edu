package com.empmanage.sawon.service.dao;

import com.empmanage.sawon.vo.TelLoginVO;

public interface TelLoginDAO {

	boolean memberInsert(TelLoginVO telLoginVO);
	TelLoginVO memberLogin(TelLoginVO telLoginVO);
	TelLoginVO memberMypage(TelLoginVO telLoginVO);
	boolean memberUpdate(TelLoginVO telLoginVO);
	boolean memberDelete(TelLoginVO telLoginVO);
	
	
}
