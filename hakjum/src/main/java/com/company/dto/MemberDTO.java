package com.company.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class MemberDTO {
	  private Long id;
	  private String memberId;
	  private String memberPassword;
	  private String memberName;
	  private int korean;
	  private int english;
	  private int math;
	}
