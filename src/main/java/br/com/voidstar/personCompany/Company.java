package br.com.voidstar.personCompany;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Company {

    private String name;
    private Set<Person> employees = new HashSet<>();

    public Company() {
        this.name = "";
    }

    public Company(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumberOfEmployees() {
        int count = 0;
        for (Person employee : employees) {
            if (employee.getSalary() > 0) {
                count++;
            }
        }
        return count;
    }

    public void hire(Person person, double salary) {
        if (!employees.contains(person) && person.getSalary() == 0.0) {
            person.setSalary(salary);
            employees.add(person);
        }
    }

    public void dismiss(Person person) {
        if (employees.contains(person)) {
            person.setSalary(0.0);
        }
    }

    public double payroll() {
        double total = 0;
        for (Person employee : employees) {
            total += employee.getSalary();
        }
        return total;
    }
}
