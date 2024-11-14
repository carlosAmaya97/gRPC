package com.uptc.frw.grpc.sevice;

import com.uptc.frw.grpc.jpa.models.Periodista;
import com.uptc.frw.grpc.jpa.repository.PeriodistaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PeriodistaService {
    @Autowired
    private PeriodistaRepository periodistaRepository;

    public List<Periodista> obtenerPeriodistas() {
        return periodistaRepository.findAll();
    }
    public Periodista obtenerPeriodistaId(long id) {
        return periodistaRepository.findById(id).orElse(null);
    }

    public Periodista guardarPeriodista(Periodista periodista) {
        return periodistaRepository.save(periodista);
    }

    public Periodista actualizarPeriodista(Periodista periodista) {
        Periodista periodistaOld = obtenerPeriodistaId(periodista.getIdP());
        periodistaOld.setNombreP(periodista.getNombreP());
        periodistaOld.setDireccion(periodista.getDireccion());
        periodistaOld.setTelefono(periodista.getTelefono());
        return guardarPeriodista(periodista);
    }

    public void eliminarPeriodista(long id) {
        periodistaRepository.deleteById(id);
    }

}
