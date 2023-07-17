package com.example.taskTwoThree.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

//Writer Entity

@Entity
@Table(name = "test_Writer_EmpTable")
public class DBWriterEntity {

	@Id
	int emp_id;
	String emp_name;
	double emp_sal;

	public DBWriterEntity() {
		super();

	}

	public DBWriterEntity(int emp_id, String emp_name, double emp_sal) {
		super();
		this.emp_id = emp_id;
		this.emp_name = emp_name;
		this.emp_sal = emp_sal;
	}

	public int getEmp_id() {
		return emp_id;
	}

	public void setEmp_id(int emp_id) {
		this.emp_id = emp_id;
	}

	public String getEmp_name() {
		return emp_name;
	}

	public void setEmp_name(String emp_name) {
		this.emp_name = emp_name;
	}

	public double getEmp_sal() {
		return emp_sal;
	}

	public void setEmp_sal(double emp_sal) {
		this.emp_sal = emp_sal;
	}

}
