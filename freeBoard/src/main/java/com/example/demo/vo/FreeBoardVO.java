package com.example.demo.vo;

import org.apache.ibatis.type.Alias;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@ToString
@EqualsAndHashCode(callSuper=false)
@Alias("freeBoardVO")
public class FreeBoardVO {
	
	private Integer boardId;	// 작성자아이디
	private String writer;		// 작성자
	private String title;		// 제목
	private String content;	// 내용
	private String update;		// 작성일
}
