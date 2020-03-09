package com.tyut.po;

import java.util.Date;

public class Attendance {
    private Integer id;

    private Integer empId;
    private Employee emp;

    private Integer depId;
    private Department dep;

    private Date amRecord;

    private Date amRecord2;

    private String amState;

    private Date pmRecord;

    private Date pmRecord2;

    private String pmState;

    public Integer getId() {
        return id;
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

    public Date getAmRecord() {
        return amRecord;
    }

    public void setAmRecord(Date amRecord) {
        this.amRecord = amRecord;
    }

    public Date getAmRecord2() {
        return amRecord2;
    }

    public void setAmRecord2(Date amRecord2) {
        this.amRecord2 = amRecord2;
    }

    public String getAmState() {
        return amState;
    }

    public void setAmState(String amState) {
        this.amState = amState == null ? null : amState.trim();
    }

    public Date getPmRecord() {
        return pmRecord;
    }

    public void setPmRecord(Date pmRecord) {
        this.pmRecord = pmRecord;
    }

    public Date getPmRecord2() {
        return pmRecord2;
    }

    public void setPmRecord2(Date pmRecord2) {
        this.pmRecord2 = pmRecord2;
    }

    public String getPmState() {
        return pmState;
    }

    public void setPmState(String pmState) {
        this.pmState = pmState == null ? null : pmState.trim();
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
    
}