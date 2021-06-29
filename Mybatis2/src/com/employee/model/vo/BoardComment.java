package com.employee.model.vo;

import java.util.Date;

import lombok.Data;

@Data
public class BoardComment {
	private int commentNo;
	private String commentContent;
	private String commentWriter;
	private Date commentDate;
	
}
