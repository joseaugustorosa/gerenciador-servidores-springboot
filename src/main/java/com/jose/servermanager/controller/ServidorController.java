package com.jose.servermanager.controller;

import com.jose.servermanager.model.Servidor;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class ServidorController {

    @GetMapping("/ativo")
    String ativo(){
        return "Servidor ativo";
    }
    private List<Servidor> listaServidor = new ArrayList<Servidor>();
    public  ServidorController(){
        listaServidor.addAll(
                List.of(
                        new Servidor(1,"Serviços Web", "Servidor utilizado para executar os serviços do website"
                                , 128, true)
                               )
        );
    }

    @GetMapping("/servidores")
    Iterable<Servidor> getServidores() {
        return listaServidor;
    }
    @GetMapping("/servidores/{id}")
    Optional<Servidor> getServidoresPorId(@PathVariable int id) {
        for (Servidor servidor : listaServidor) {
            if (servidor.getId() == id) {
                return Optional.of(servidor);
            }
        }
        return Optional.empty();
    }
    @PostMapping("/servidores")
    Servidor postServidor(@RequestBody Servidor servidor) {
        Integer maxId = null;
        for (Servidor item : listaServidor) {
            if (maxId == null || item.getId() > maxId) {
                maxId = item.getId();
            }
        }
        servidor.setId(maxId + 1);
        listaServidor.add(servidor);
        return servidor;
    }
    @PutMapping("/servidores/{id}")
    Servidor putServidor(@PathVariable int id, @RequestBody Servidor servidor) {
        int ServidorIndex = -1;
        for (Servidor a : listaServidor) {
            if (a.getId() == id){
                ServidorIndex = listaServidor.indexOf(a);
                listaServidor.set(ServidorIndex, servidor);
            }
        }
        return (ServidorIndex == -1) ? postServidor(servidor) : servidor;
    }
    @DeleteMapping("/servidores/{id}")
    void deleteServidor(@PathVariable int id) {
        listaServidor.removeIf(servidor -> servidor.getId() == id);
    }


}
