package com.example.onelabspringdata;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonRepository extends ElasticsearchRepository<Person,Long> {
    Person findById(long id);
    List<Person> findByName(String name);
    List<Person> findByAge(Integer age);
    List<Person> findByNameAndAge(String name,Integer age);
}
