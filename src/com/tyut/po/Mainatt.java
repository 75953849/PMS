package com.tyut.po;

public class Mainatt {
    private Integer id;

    private Integer empId;
    private Employee emp;

    private Integer depId;
    private Department dep;
    
    private Integer amDate1Id;
    private Subatt subatt1;
    
    private Integer amDate2Id;
    private Subatt subatt2;
    
    private Integer amState;	//	1.上午上班空（都空）      2.上午下班为空     0。正常

    private Integer pmDate1Id;
    private Subatt subatt3;

    private Integer pmDate2Id;
    private Subatt subatt4;

    private Integer pmState;

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

    public Integer getAmDate1Id() {
        return amDate1Id;
    }

    public void setAmDate1Id(Integer amDate1Id) {
        this.amDate1Id = amDate1Id;
    }

    public Integer getAmDate2Id() {
        return amDate2Id;
    }

    public void setAmDate2Id(Integer amDate2Id) {
        this.amDate2Id = amDate2Id;
    }

    public Integer getAmState() {
        return amState;
    }

    public void setAmState(Integer amState) {
        this.amState = amState;
    }

    public Integer getPmDate1Id() {
        return pmDate1Id;
    }

    public void setPmDate1Id(Integer pmDate1Id) {
        this.pmDate1Id = pmDate1Id;
    }

    public Integer getPmDate2Id() {
        return pmDate2Id;
    }

    public void setPmDate2Id(Integer pmDate2Id) {
        this.pmDate2Id = pmDate2Id;
    }

    public Integer getPmState() {
        return pmState;
    }

    public void setPmState(Integer pmState) {
        this.pmState = pmState;
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

	public Subatt getSubatt1() {
		return subatt1;
	}

	public void setSubatt1(Subatt subatt1) {
		this.subatt1 = subatt1;
	}

	public Subatt getSubatt2() {
		return subatt2;
	}

	public void setSubatt2(Subatt subatt2) {
		this.subatt2 = subatt2;
	}

	public Subatt getSubatt3() {
		return subatt3;
	}

	public void setSubatt3(Subatt subatt3) {
		this.subatt3 = subatt3;
	}

	public Subatt getSubatt4() {
		return subatt4;
	}

	public void setSubatt4(Subatt subatt4) {
		this.subatt4 = subatt4;
	}
    
}