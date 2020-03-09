package com.tyut.po;

public class Department {
    private Integer id;

    private String depName;

    private String introduction;

    private Integer empcount;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDepName() {
        return depName;
    }

    public void setDepName(String depName) {
        this.depName = depName == null ? null : depName.trim();
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction == null ? null : introduction.trim();
    }

    public Integer getEmpcount() {
        return empcount;
    }

    public void setEmpcount(Integer empcount) {
        this.empcount = empcount;
    }

	@Override
	public String toString() {
		return "Department [id=" + id + ", depName=" + depName + ", introduction=" + introduction + ", empcount="
				+ empcount + "]";
	}
    
}