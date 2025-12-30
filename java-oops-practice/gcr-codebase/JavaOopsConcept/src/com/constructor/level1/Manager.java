/*
 * Program Name : Manager
 * Description  : Subclass demonstrating inheritance.
 */

package com.constructor.level1;

class Manager extends Employee {
    Manager(int employeeID, String department, double salary) {
        super(employeeID, department, salary);
    }

    void display() {
        System.out.println(employeeID + " | " + department + " | " + getSalary());
    }
}
