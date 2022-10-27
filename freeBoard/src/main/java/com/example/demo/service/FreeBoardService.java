package com.example.demo.service;

import java.util.List;

import com.example.demo.vo.FreeBoardVO;

public interface FreeBoardService {

	public List<FreeBoardVO> selectAll() throws java.lang.Exception;

	public void updateBoard(FreeBoardVO freeBoardVO) throws java.lang.Exception;

	

}
