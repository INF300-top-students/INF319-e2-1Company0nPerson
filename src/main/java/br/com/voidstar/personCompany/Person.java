package br.com.voidstar.personCompany;

public class Person {
    private String name;
    private String surname;
    private double salary;

    public Person() {
        this.name = "";
        this.surname = "";
        this.salary = 0.0;
    }

    public Person(String name, String surname) {
        this.name = name;
        this.surname = surname;
        this.salary = 0.0;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;

    }

    public String getSurname() {
        return this.surname;

    }

    public void setSurname(String surname) {
        this.surname = surname;

    }

    public double getSalary() {
        return this.salary;

    }

    protected void setSalary(double salary) {
        if (this.salary == 0.0 || salary == 0.0) {
            this.salary = salary;
        }
    }
}
