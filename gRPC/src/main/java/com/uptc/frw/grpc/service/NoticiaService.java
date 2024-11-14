package com.uptc.frw.grpc.sevice;

import com.uptc.frw.grpc.jpa.models.Noticia;
import com.uptc.frw.grpc.jpa.repository.NoticiaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NoticiaService {
    @Autowired
    private NoticiaRepository noticiaRepository;

    public List<Noticia> obtenerNoticias() {
        return noticiaRepository.findAll();
    }
    public Noticia obtenerNoticiaId(long id) {
        return noticiaRepository.findById(id).orElse(null);
    }
    public Noticia guardarNoticia(Noticia noticia) {
        return noticiaRepository.save(noticia);
    }
    public Noticia actualizarNoticia(Noticia noticia) {
        Noticia noticiaOld = obtenerNoticiaId(noticia.getIdN());
        noticiaOld.setIdR(noticia.getIdR());
        noticiaOld.setFechaN(noticia.getFechaN());
        noticiaOld.setTitular(noticia.getTitular());
        noticiaOld.setTexto(noticia.getTexto());
        return guardarNoticia(noticia);
    }
    public void eliminarNoticia(long id) {
        noticiaRepository.deleteById(id);
    }
}
