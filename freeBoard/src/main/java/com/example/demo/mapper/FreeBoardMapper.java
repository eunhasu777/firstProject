package com.example.demo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.vo.FreeBoardVO;

@Mapper
public interface FreeBoardMapper {

	public List<FreeBoardVO> selectAll() throws java.lang.Exception;

	public Object updateBoard(FreeBoardVO freeBoardVO) throws java.lang.Exception;

}
