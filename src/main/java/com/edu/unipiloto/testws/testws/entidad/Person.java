/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.edu.unipiloto.testws.testws.entidad;

import java.util.HashMap;
import java.util.Map;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 *
 * @author tomas
 */

@XmlRootElement(name = "persona")
@XmlType(propOrder = {"id", "fullname", "age", "salario"})

public class Person {
    private int id;
    private String fullname;
    private int age;
    private double salario;
    private static final double salarioMinimo = 6000;

    
    public Person(){}
    
    public Person(int id, String fullname, int age, double salario) {
        this.id = id;
        this.fullname = fullname;
        this.age = age;
        this.salario = salario;
    }
    
    @XmlElement
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @XmlElement
    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    @XmlElement
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
        this.salario = calculateSalary(age);
    }
    
    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }
    
    private double calculateSalary(int age) {
        return (age * salarioMinimo) / 3;
    }
}
