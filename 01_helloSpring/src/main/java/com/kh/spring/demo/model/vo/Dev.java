package com.kh.spring.demo.model.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Dev {
	private String devName;
	private int devAge;
	private String devEmail;
	private String devGender;
	private String[] devLang;
}
