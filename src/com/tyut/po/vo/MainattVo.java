package com.tyut.po.vo;

import com.tyut.po.MainattExample;

public class MainattVo extends MainattExample{
	private int jump = -2;
	private int rows = -1;
	public int getJump() {
		return jump;
	}
	public void setJump(int jump) {
		this.jump = jump;
	}
	public int getRows() {
		return rows;
	}
	public void setRows(int rows) {
		this.rows = rows;
	}
	public MainattVo(int jump, int rows) {
		super();
		this.jump = jump;
		this.rows = rows;
	}
	public MainattVo() {
		super();
	}
	

}
