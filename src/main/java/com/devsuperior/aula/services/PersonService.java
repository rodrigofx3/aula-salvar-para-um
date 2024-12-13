package com.devsuperior.aula.services;

import com.devsuperior.aula.dto.PersonDTO;
import com.devsuperior.aula.dto.PersonDepartamentDTO;
import com.devsuperior.aula.entities.Department;
import com.devsuperior.aula.entities.Person;
import com.devsuperior.aula.repositories.DepartmentRepository;
import com.devsuperior.aula.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonService {

    @Autowired
    private PersonRepository repository;
    @Autowired
    private DepartmentRepository departmentRepository;

    public PersonDepartamentDTO insert(PersonDepartamentDTO person) {

        Person entity = new Person();

        entity.setName(person.getName());
        entity.setSalary(person.getSalary());

        Department department = departmentRepository.getReferenceById(person.getDepartment().getId());

        department.setId(person.getDepartment().getId());

        entity.setDepartment(department);

        entity = repository.save(entity);

        return new PersonDepartamentDTO(entity);
    }

    public PersonDTO insert(PersonDTO person) {

        Person entity = new Person();

        entity.setName(person.getName());
        entity.setSalary(person.getSalary());
        entity.setDepartment(departmentRepository.getReferenceById(person.getDepartmentId()));

        entity = repository.save(entity);

        return new PersonDTO(entity);
    }


}
