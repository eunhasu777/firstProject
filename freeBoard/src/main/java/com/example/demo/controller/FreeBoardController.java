package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.service.FreeBoardService;
import com.example.demo.vo.FreeBoardVO;

@Controller
@RequestMapping("/freeBoard")
public class FreeBoardController {
	
	@Autowired
	private FreeBoardService freeBoardService; 
	
	@GetMapping("/selectAll")
	public ModelAndView selectAll() throws java.lang.Exception {
		
		ModelAndView mav = new ModelAndView();
		List<FreeBoardVO> resultList = new ArrayList<>();
		
		try {
			resultList = freeBoardService.selectAll();
		} catch (java.lang.Exception e) {
			e.printStackTrace();
		}
		mav.setViewName("freeBoard");
		mav.addObject("result", resultList);
		return mav;
	}  
	
//	@GetMapping("/selectOne")
//	public ModelAndView selectOne(FreeBoardVO freeBoardVO) throws java.lang.Exception {
//		
//		ModelAndView mav = new ModelAndView();
//		Map<String, Object> resultMap = new HashMap<>();
//		
//		resultMap = feeBoard
//		
//		return null;
//	}
	
	@GetMapping("/updateBoard")
	public ModelAndView updateBoard(FreeBoardVO freeBoardVO) throws java.lang.Exception {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("updateBoard");
		return mav;
	}
	
	@PostMapping("/saveData")
	public ModelAndView saveData(@RequestParam FreeBoardVO freeBoardVO) throws java.lang.Exception {
		ModelAndView mav = new ModelAndView();
		freeBoardService.updateBoard(freeBoardVO);
		mav.setViewName("freeBoard");
		return mav;
	}
}

