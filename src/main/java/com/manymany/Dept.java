package com.manymany;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Dept {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="dept_name")
    private String deptName;

    @Column(name="floor")
    private int floor;

    @ManyToMany
    @JoinColumn(name="emp_id", nullable = false)
    private Set<Employee> employees;

    public Dept(String deptName, int floor) {
        this.deptName = deptName;
        this.floor = floor;
        this.employees = new HashSet<Employee>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public int getFloor() {
        return floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }

    public Set<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(Set<Employee> employees) {
        this.employees = employees;
    }
}
