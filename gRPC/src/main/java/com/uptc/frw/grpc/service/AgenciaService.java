package com.uptc.frw.grpc.service;

import com.uptc.frw.grpc.jpa.models.Agencia;
import com.uptc.frw.grpc.jpa.repository.AgenciaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AgenciaService {

    @Autowired
    private AgenciaRepository  agenciaRepository;

    public List<Agencia> obtenerAgencia() {
        return agenciaRepository.findAll();
    }

    public Agencia obtenerAgenciaId(long id) {
        return agenciaRepository.findById(id).orElse(null);
    }

    public Agencia guardarAgencia (Agencia agencia) {
        return agenciaRepository.save(agencia);
    }

    public Agencia actualizaAgencia(Agencia agencia) {

        Agencia agenciaOld = obtenerAgenciaId(agencia.getId());
        agenciaOld.setAgencia(agencia.getAgencia());
        agenciaOld.setAnioCreacion(agencia.getAnioCreacion());

        return guardarAgencia(agencia);
    }

    public void borraAgencia(long id) {
        agenciaRepository.deleteById(id);
    }
}
