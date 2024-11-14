package com.uptc.frw.grpc.sevice;

import com.uptc.frw.grpc.jpa.models.Implicado;
import com.uptc.frw.grpc.jpa.models.Noticia;
import com.uptc.frw.grpc.jpa.repository.ImplicadoRepository;
import com.uptc.frw.grpc.jpa.repository.NoticiaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ImplicadoService {
    @Autowired
    private ImplicadoRepository implicadoRepository;

    public List<Implicado> obtenerImpliados() {
        return implicadoRepository.findAll();
    }
    public Implicado obtenerImplicadoId(long id) {
        return implicadoRepository.findById(id).orElse(null);
    }
    public Implicado guardarImplicado(Implicado implicado) {
        return implicadoRepository.save(implicado);
    }
    public Implicado actualizarImplicado(Implicado implicado) {
        Implicado implicadoOld = obtenerImplicadoId(implicado.getIdI());
        implicadoOld.setNombreI(implicado.getNombreI());
        implicadoOld.setFechaNacimiento(implicado.getFechaNacimiento());
        implicadoOld.setCalidad(implicado.getCalidad());
        return guardarImplicado(implicado);
    }
    public void eliminarImplicado(long id) {
        implicadoRepository.deleteById(id);
    }
}
