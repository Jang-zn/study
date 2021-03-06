package com.bs.spring.board.model.vo;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Board {
	private int boardNo;
	private String boardTitle;
	private String boardWriter;
	private String boardContent;
	private Date boardDate;
	private int boardReadcount;
	private List<Attachment> attachments;
}
