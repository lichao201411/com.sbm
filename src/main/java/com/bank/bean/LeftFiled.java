package com.bank.bean;

import lombok.Data;

@Data
public class LeftFiled {
	private int lfid;
	private String lfname;
	private String lflevel;
	private String lfparent;
	private int lbid;//父left bean的id
	
}
