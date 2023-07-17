package com.example.taskTwoThree.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 * The Class EmployeeEntity.
 * Reader Entity
 */
@Entity
@Table(name = "test_emp_table")
public class EmployeeEntity {

	/** The emp id. */
	@Id
	int emp_id;
	
	/** The emp name. */
	String emp_name;
	
	/** The emp sal. */
	double emp_sal;

	/**
	 * Instantiates a new employee entity.
	 */
	public EmployeeEntity() {
		super();
	}

	/**
	 * Instantiates a new employee entity.
	 *
	 * @param emp_id the emp id
	 * @param emp_name the emp name
	 * @param emp_sal the emp sal
	 */
	public EmployeeEntity(int emp_id, String emp_name, double emp_sal) {
		super();
		this.emp_id = emp_id;
		this.emp_name = emp_name;
		this.emp_sal = emp_sal;
	}

	/**
	 * Gets the emp id.
	 *
	 * @return the emp id
	 */
	public int getEmp_id() {
		return emp_id;
	}

	/**
	 * Sets the emp id.
	 *
	 * @param emp_id the new emp id
	 */
	public void setEmp_id(int emp_id) {
		this.emp_id = emp_id;
	}

	/**
	 * Gets the emp name.
	 *
	 * @return the emp name
	 */
	public String getEmp_name() {
		return emp_name;
	}

	/**
	 * Sets the emp name.
	 *
	 * @param emp_name the new emp name
	 */
	public void setEmp_name(String emp_name) {
		this.emp_name = emp_name;
	}

	/**
	 * Gets the emp sal.
	 *
	 * @return the emp sal
	 */
	public double getEmp_sal() {
		return emp_sal;
	}

	/**
	 * Sets the emp sal.
	 *
	 * @param emp_sal the new emp sal
	 */
	public void setEmp_sal(double emp_sal) {
		this.emp_sal = emp_sal;
	}

	/**
	 * To string.
	 *
	 * @return the string
	 */
	@Override
	public String toString() {
		return "EmployeeEntity [emp_id=" + emp_id + ", emp_name=" + emp_name + ", emp_sal=" + emp_sal + "]";
	}

}
