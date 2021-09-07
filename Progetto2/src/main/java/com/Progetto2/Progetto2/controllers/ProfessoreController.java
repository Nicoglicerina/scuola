package com.Progetto2.Progetto2.controllers;

import com.Progetto2.Progetto2.data.ProfessoreDTO;
import com.Progetto2.Progetto2.entities.Professore;
import com.Progetto2.Progetto2.services.ProfessoreService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * ProfessoreController è un classe che si occupa di gestire le funzionalità della classe Professore
 */
@RestController
@RequestMapping("api/professore/")
public class ProfessoreController
{
    final ProfessoreService professoreService;
    public ProfessoreController(ProfessoreService professoreService) {
        this.professoreService = professoreService;
    }

    /**
     * metodo che restituisce una entità Professore in base all'id inserito dall'utente
     * {@link com.Progetto2.Progetto2.services.ProfessoreService#findProfessoreById(Integer id)}
     * @param id
     * @return ResponseEntity
     */
    @RequestMapping(value= "findP/{id}",method = RequestMethod.GET)
    public ResponseEntity<Professore> FindById(@PathVariable Integer id)
    {
        return new ResponseEntity<>(professoreService.findProfessoreById(id), HttpStatus.OK);
    }

    /**
     * metodo che permette di visualizzare tutti tutte le istanze della classe Professore
     * {@link com.Progetto2.Progetto2.services.ProfessoreService#findAllP()}
     * @return ResponseEntity
     */
    @RequestMapping(value= "indexP",method = RequestMethod.GET)
    public ResponseEntity<List<Professore>> ListProfessore()
    {
        return new ResponseEntity<>(professoreService.findAllP(), HttpStatus.OK);
    }

    /**
     * metodo che permette di eliminare una istanza in base all'id inserito dall'utente
     * {@link com.Progetto2.Progetto2.services.ProfessoreService#deleteRecordP(Integer id}
     * @param id
     */
    @RequestMapping(value= "deleteP/{id}",method = RequestMethod.DELETE)
    public void Delete(@PathVariable Integer id)
    {
        System.out.printf("utente eliminato");
        professoreService.deleteRecordP(id);
    }

    /**
     * metodo che permette di creare una nuova istanza della classe Professore
     * {@link com.Progetto2.Progetto2.services.ProfessoreService#saveProfessore(ProfessoreDTO)}
     * @param professoreDTO
     * @return ResponseEntity
     */
    @RequestMapping(value = "/addP",method = RequestMethod.POST)
    public ResponseEntity<Professore> AddProfessore(@RequestBody ProfessoreDTO professoreDTO)
    {
        System.out.println(professoreDTO.toString());
        return new ResponseEntity<>(professoreService.saveProfessore(professoreDTO), HttpStatus.OK);
    }

    /**
     * metodo che permette di aggiornare una istanza della classe Professore in base all'id inviato dall'utente
     * {@link com.Progetto2.Progetto2.services.ProfessoreService#UpdateProfessore(ProfessoreDTO, Integer id)}
     * @param professoreDTO
     * @param id
     * @return ResponseEntity
     */
    @RequestMapping(value = "/updateP/{id}",method = RequestMethod.PATCH)
    public ResponseEntity<Professore> UpdateProfessore(@RequestBody ProfessoreDTO professoreDTO, @PathVariable Integer id)
    {
        return new ResponseEntity<>(professoreService.UpdateProfessore(professoreDTO, id), HttpStatus.OK);
    }
}
