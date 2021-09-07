package com.Progetto2.Progetto2.controllers;

import com.Progetto2.Progetto2.data.AtaDTO;
import com.Progetto2.Progetto2.entities.Ata;
import com.Progetto2.Progetto2.services.AtaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * AtaController è un classe che si occupa di gestire le funzionalità della classe Ata
 */
@RestController
@RequestMapping("api/professore/")
public class AtaController
{
    final AtaService ataService;
    public AtaController(AtaService ataService) {
        this.ataService = ataService;
    }

    /**
     * metodo che restituisce una entità Ata in base all'id inserito dall'utente
     * {@link com.Progetto2.Progetto2.services.AtaService#findAtaById(Integer id)}
     * @param id
     * @return ResponseEntity
     */
    @RequestMapping(value= "findA/{id}",method = RequestMethod.GET)
    public ResponseEntity<Ata> FindById(@PathVariable Integer id)
    {
        return new ResponseEntity<>(ataService.findAtaById(id), HttpStatus.OK);
    }

    /**
     * metodo che permette di visualizzare tutti tutte le istanze della classe Ata
     * {@link com.Progetto2.Progetto2.services.AtaService#findAllA()}
     * @return ResponseEntity
     */
    @RequestMapping(value= "indexP",method = RequestMethod.GET)
    public ResponseEntity<List<Ata>> ListProfessore()
    {
        return new ResponseEntity<>(ataService.findAllA(), HttpStatus.OK);
    }

    /**
     * metodo che permette di eliminare una istanza in base all'id inserito dall'utente
     * {@link com.Progetto2.Progetto2.services.AtaService#deleteRecordA(Integer id}
     * @param id
     */
    @RequestMapping(value= "deleteP/{id}",method = RequestMethod.DELETE)
    public void Delete(@PathVariable Integer id)
    {
        System.out.printf("utente eliminato");
        ataService.deleteRecordA(id);
    }

    /**
     * metodo che permette di creare una nuova istanza della classe Professore
     * {@link com.Progetto2.Progetto2.services.AtaService#saveAta(AtaDTO)}
     * @param ataDTO
     * @return ResponseEntity
     */
    @RequestMapping(value = "/addA",method = RequestMethod.POST)
    public ResponseEntity<Ata> AddAta(@RequestBody AtaDTO ataDTO)
    {
        System.out.println(ataDTO.toString());
        return new ResponseEntity<>(ataService.saveAta(ataDTO), HttpStatus.OK);
    }

    /**
     * metodo che permette di aggiornare una istanza della classe Professore in base all'id inviato dall'utente
     * {@link com.Progetto2.Progetto2.services.AtaService#UpdateAta(AtaDTO, Integer)}
     * @param ataDTO
     * @param id
     * @return ResponseEntity
     */
    @RequestMapping(value = "/updateP/{id}",method = RequestMethod.PATCH)
    public ResponseEntity<Ata> UpdateAta(@RequestBody AtaDTO ataDTO, @PathVariable Integer id)
    {
        return new ResponseEntity<>(ataService.UpdateAta(ataDTO, id), HttpStatus.OK);
    }
}