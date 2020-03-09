package com.tyut.po;

import java.util.Date;

public class Employee {
    private Integer id;

    private String empName;

    private String password;

    private String gender;

    private Date birthday;

    private Integer depId;

    private Integer impRoleId;

    private Integer rank;

    private String tel;

    private String email;

    private String info;

    private Integer impState;
    
    private Department dep;
    private Role role;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName == null ? null : empName.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender == null ? null : gender.trim();
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Integer getDepId() {
        return depId;
    }

    public void setDepId(Integer depId) {
        this.depId = depId;
    }

    public Integer getImpRoleId() {
        return impRoleId;
    }

    public void setImpRoleId(Integer impRoleId) {
        this.impRoleId = impRoleId;
    }

    public Integer getRank() {
        return rank;
    }

    public void setRank(Integer rank) {
        this.rank = rank;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel == null ? null : tel.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info == null ? null : info.trim();
    }

    public Integer getImpState() {
        return impState;
    }

    public void setImpState(Integer impState) {
        this.impState = impState;
    }

	public Department getDep() {
		return dep;
	}

	public void setDep(Department dep) {
		this.dep = dep;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", empName=" + empName + ", password=" + password + ", gender=" + gender
				+ ", birthday=" + birthday + ", depId=" + depId + ", impRoleId=" + impRoleId + ", rank=" + rank
				+ ", tel=" + tel + ", email=" + email + ", info=" + info + ", impState=" + impState + ", dep=" + dep
				+ ", role=" + role + "]";
	}
    
}