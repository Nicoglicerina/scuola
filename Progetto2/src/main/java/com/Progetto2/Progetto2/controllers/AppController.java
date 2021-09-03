package com.Progetto2.Progetto2.controllers;

import com.Progetto2.Progetto2.entities.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;


@RestController

public class AppController
{
    @RequestMapping( value = "index", method = RequestMethod.GET)

    public @ResponseBody

    String test()
    {
        return "ciao";
    }

    @RequestMapping( value = "test1", method = RequestMethod.GET)
    public ResponseEntity<Test> Ciao()
    {
        Test t= new Test();
        t.nome="Luigi";
        t.cognome="Belo";
        return new ResponseEntity<>(t, HttpStatus.OK);
    }

    @RequestMapping( value = "list", method = RequestMethod.GET)
    public ResponseEntity<List> hola()
    {
        List<Test> testes= new ArrayList<>();
        Test t= new Test("", "");
        testes.add(t);
        testes.add(t);
        return new ResponseEntity<>(testes, HttpStatus.OK);
    }
}
