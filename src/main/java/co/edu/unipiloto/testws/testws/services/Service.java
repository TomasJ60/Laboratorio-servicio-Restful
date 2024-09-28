/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unipiloto.testws.testws.services;

import com.edu.unipiloto.testws.testws.entidad.Person;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author tomas
 */
@Path("services")
public class Service {

    private static Map<Integer, Person> personas = new HashMap<>();

    static {
        for (int i = 0; i < 10; i++) {
            Person persona = new Person();
            int id = i + 1;
            persona.setId(id);
            persona.setFullname("Amigo " + id);
            persona.setAge(new Random().nextInt(40 + 1));
            personas.put(id, persona);
        }
    }

    @GET
    @Path("/getPersonByInJson")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Person> getAllPersonaJSon() {
        return new ArrayList<Person>(personas.values());
    }

    @GET
    @Path("/getPersonByInXML")
    @Produces(MediaType.APPLICATION_XML)
    public List<Person> getAllPersonsIntXML() {
        return new ArrayList<Person>(personas.values());
    }

    @GET
    @Path("getPersonByIdJson/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Person getPersonByIdJson(@PathParam("id") int id) {
        return personas.get(id);
    }

    @POST
    @Path("/addPersonInJson")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Person addPersonInJson(Person person) {
        personas.put(new Integer(person.getId()), person);
        return person;
    }

    @GET
    @Path("/getAverageSalaryInXML")
    @Produces(MediaType.APPLICATION_XML)
    public String getAverageSalaryInXML() {
        double totalSalary = 0;
        int totalPersons = personas.size();
        double averageSalary;

        for (Person person : personas.values()) {
            totalSalary += person.getSalario();
        }

        if (totalPersons > 0) {
            averageSalary = totalSalary / totalPersons;
        }else{
            averageSalary = 0;
        }
        return "<averageSalary>" + averageSalary + "</averageSalary>";
    }

//    @GET
//    @Path("/getAverageSalaryInXML")
//    @Produces(MediaType.APPLICATION_XML)
//    public Person getAverageSalaryInXML() {
//        double totalSalary = 0;
//        int totalPersons = personas.size();
//
//        for (Person person : personas.values()) {
//            totalSalary += person.getSalario();
//        }
//
//        double averageSalary = totalPersons > 0 ? totalSalary / totalPersons : 0;
//
//        // Crear un objeto Person con el salario promedio y valores por defecto en otros campos
//        return salarioprom = averageSalary;
//        Person personaSalarioPromedio = new Person(2, "Salario Promedio", 2, averageSalary);
//
//        return personaSalarioPromedio;  // Retornamos el objeto Person
//    }
    @GET
    @Path("/getTotalSalaryInJSON")
    @Produces(MediaType.APPLICATION_JSON)
    public double getTotalSalaryInJSON() {
        double totalSalary = 0;

        for (Person person : personas.values()) {
            totalSalary += person.getSalario();
        }

        return totalSalary; // Retorna la suma
    }
}
