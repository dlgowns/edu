package com.empmanage.sawon.service;

import java.util.ArrayList;

import com.empmanage.sawon.vo.SawonVO;

public interface SawonService {
	ArrayList<SawonVO> getAllSawon() throws Exception;

	int insertSawon(SawonVO sawonVO);

	SawonVO getOneSawon(SawonVO sawonVO);

	int updateSawon(SawonVO sawonVO);

	int deleteSawon(SawonVO sawonVO);
}
