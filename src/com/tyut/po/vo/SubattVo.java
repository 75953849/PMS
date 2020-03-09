package com.tyut.po.vo;

import com.tyut.po.SubattExample;

public class SubattVo extends SubattExample{
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
	public SubattVo(int jump, int rows) {
		super();
		this.jump = jump;
		this.rows = rows;
	}
	public SubattVo() {
		super();
	}
	
}
