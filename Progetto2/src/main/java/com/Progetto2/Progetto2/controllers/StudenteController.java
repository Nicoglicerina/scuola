package com.Progetto2.Progetto2.controllers;

import com.Progetto2.Progetto2.data.StudenteDTO;
import com.Progetto2.Progetto2.entities.Studente;
import com.Progetto2.Progetto2.services.StudenteService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * StudenteController è una classe che si occupa di gestire le funzionalità della classe Studente
 */
@RestController
@RequestMapping("api/studente/")
public class StudenteController
{
    final StudenteService studenteService;

    /**
     * metodo che richiama al package service e richiama il metodo "findStudenteById()" e trova l'entità designata in base all'id
     * {@link com.Progetto2.Progetto2.services.StudenteService#findStudenteById(Integer id)}
     */
    public StudenteController(StudenteService studenteService) {
        this.studenteService = studenteService;
    }
    @RequestMapping(value= "find/{id}",method = RequestMethod.GET)
    public ResponseEntity<Studente> FindById(@PathVariable Integer id)
    {
        return new ResponseEntity<>(studenteService.findStudenteById(id), HttpStatus.OK);
    }

    /**
     * metodo che richiama il package service e richiama il metodo "findALL()" e restituisce tutte le istanze di una entità
     * {@link com.Progetto2.Progetto2.services.StudenteService#findAllS()}
     */
    @RequestMapping(value= "index",method = RequestMethod.GET)
    public ResponseEntity<List<Studente>> ListStudenti()
    {
        return new ResponseEntity<>(studenteService.findAllS(), HttpStatus.OK);
    }

    /**
     * metodo che richiama il package service e richiama il metodo "deleteRecord()" per eliminare una istanza in base all'id
     * {@link com.Progetto2.Progetto2.services.StudenteService#deleteRecordS(Integer id)}
     * @param id
     */
    @RequestMapping(value= "delete/{id}",method = RequestMethod.DELETE)
    public void Delete(@PathVariable Integer id)
    {
        System.out.printf("utente eliminato");
        studenteService.deleteRecordS(id);
    }

    /**
     * metodo che richiama il package service e richiama il metodo "saveStudente()" per aggiungere una nuova istanza della classe al database
     * {@link com.Progetto2.Progetto2.services.StudenteService#saveStudente(StudenteDTO)}
     * @param studenteDTO
     * @return ResponseEntity<>
     */
    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public ResponseEntity<Studente> AddStudente(@RequestBody StudenteDTO studenteDTO)
    {
        System.out.println(studenteDTO.toString());
        return new ResponseEntity<>(studenteService.saveStudente(studenteDTO), HttpStatus.OK);
    }

    /**
     * metodo che richiama il package service e richiama al metodo "UpdateStudente()" per aggiornare gli attributi di una istanza
     * {@link com.Progetto2.Progetto2.services.StudenteService#UpdateStudente(StudenteDTO, Integer)}
     * @param studenteDTO
     * @param id
     * @return ResponseEntity<>
     */
    @RequestMapping(value = "/update/{id}",method = RequestMethod.PATCH)
    public ResponseEntity<Studente> UpdateStudente(@RequestBody StudenteDTO studenteDTO, @PathVariable Integer id)
    {
        return new ResponseEntity<>(studenteService.UpdateStudente(studenteDTO, id), HttpStatus.OK);
    }
}
