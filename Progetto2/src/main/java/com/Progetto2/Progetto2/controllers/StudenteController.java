package com.Progetto2.Progetto2.controllers;

import com.Progetto2.Progetto2.entities.Studente;
import com.Progetto2.Progetto2.services.StudenteService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/studente/")
public class StudenteController
{
    final StudenteService studenteService;

    public StudenteController(StudenteService studenteService) {
        this.studenteService = studenteService;
    }
    @RequestMapping(value= "find/{id}",method = RequestMethod.GET)
    public ResponseEntity<Studente> FindById(@PathVariable Integer id)
    {
        return new ResponseEntity<>(studenteService.findStudenteById(id), HttpStatus.OK);
    }
    @RequestMapping(value= "index",method = RequestMethod.GET)
    public ResponseEntity<List<Studente>> ListStudenti()
    {
        return new ResponseEntity<>(studenteService.findAll(), HttpStatus.OK);
    }
    @RequestMapping(value= "delete/{id}",method = RequestMethod.GET)
    public void Delete(@PathVariable Integer id)
    {
        System.out.printf("utente eliminato");
        studenteService.deleteRecord(id);
    }
}
