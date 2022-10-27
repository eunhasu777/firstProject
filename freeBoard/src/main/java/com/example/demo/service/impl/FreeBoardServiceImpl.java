package com.example.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.mapper.FreeBoardMapper;
import com.example.demo.service.FreeBoardService;
import com.example.demo.vo.FreeBoardVO;


@Service
public class FreeBoardServiceImpl implements FreeBoardService{

	@Autowired
	FreeBoardMapper freeBoardMapper;
	
	@Override
	public List<FreeBoardVO> selectAll() throws java.lang.Exception {
		return freeBoardMapper.selectAll();
	}

	@Override
	public void updateBoard(FreeBoardVO freeBoardVO) throws Exception {
		freeBoardMapper.updateBoard(freeBoardVO);
	}

}
