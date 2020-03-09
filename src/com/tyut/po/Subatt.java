package com.tyut.po;

import java.util.Date;

public class Subatt {
    private Integer id;

    private Integer empId;
    private Employee emp;

    private Integer depId;
    private Department dep;
    
    private Date attDate;

    private Integer attState;		
    								//   attState=1    上午迟到
								    //   attState=10    上午未迟到
    
    								//   attState=2   上午早退
    								//	 attState=20    上午未早退
								    //   attState=3    下午迟到
								    //   attState=30    下午未迟到
								    //   attState=4    下午早退
    								//   attState=40    下午未早退
    
    public Integer getId() {
        return id;
    }

    public Employee getEmp() {
		return emp;
	}

	public void setEmp(Employee emp) {
		this.emp = emp;
	}

	public Department getDep() {
		return dep;
	}

	public void setDep(Department dep) {
		this.dep = dep;
	}

	public void setId(Integer id) {
        this.id = id;
    }

    public Integer getEmpId() {
        return empId;
    }

    public void setEmpId(Integer empId) {
        this.empId = empId;
    }

    public Integer getDepId() {
        return depId;
    }

    public void setDepId(Integer depId) {
        this.depId = depId;
    }

    public Date getAttDate() {
        return attDate;
    }

    public void setAttDate(Date attDate) {
        this.attDate = attDate;
    }

    public Integer getAttState() {
        return attState;
    }

    public void setAttState(Integer attState) {
        this.attState = attState;
    }

	@Override
	public String toString() {
		return "Subatt [id=" + id + ", empId=" + empId + ", emp=" + emp + ", depId=" + depId + ", dep=" + dep
				+ ", attDate=" + attDate + ", attState=" + attState + "]";
	}


    
}