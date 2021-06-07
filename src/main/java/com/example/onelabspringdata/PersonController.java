package com.example.onelabspringdata;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class PersonController {
    private final PersonRepository personRepository;
    private Long id = 0l;

    @Autowired
    public PersonController(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @RequestMapping(value = "/all")
    public List<Person> getAllPersons(){
        List<Person> list = new ArrayList<>();
        personRepository.findAll().forEach(list::add);
        return list;
    }

    @RequestMapping(value = "/persons")
    public void save(@RequestParam("name")String name,@RequestParam("age") int age) {
        Person person = new Person(name,age);
        person.setId(id++);
//        System.out.println(person.getId() + " " + person.getName() + " "+ person.getAge());
        personRepository.save(person);
    }

    @RequestMapping(value = "/getbyname")
    public List<Person> findByName(@RequestParam("name")String name) {
        return personRepository.findByName(name);
    }

    @RequestMapping(value = "/getbyage")
    public List<Person> findByAge(@RequestParam("age") int age) {
        return personRepository.findByAge(age);
    }

    @RequestMapping(value = "/getbyid")
    public Person findById(@RequestParam("id")long id) {
        return personRepository.findById(id);
    }

    @RequestMapping(value = "/getbynameandage")
    public List<Person> getByNameAndAge(@RequestParam("name")String name,@RequestParam("age") int age) {
        return personRepository.findByNameAndAge(name,age);
    }
}
