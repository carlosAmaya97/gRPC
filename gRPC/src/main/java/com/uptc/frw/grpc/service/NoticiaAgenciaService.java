package com.uptc.frw.grpc.service;

import com.uptc.frw.grpc.jpa.models.NoticiaAgencia;
import com.uptc.frw.grpc.jpa.repository.NoticiaAgenciaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NoticiaAgenciaService {

    @Autowired
    private NoticiaAgenciaRepository  NARepository;

    public List<NoticiaAgencia> obtenerNotiAgencia() {
        return NARepository.findAll();
    }

    public NoticiaAgencia obtenerNotiAgenciaId(long id) {
        return NARepository.findById(id).orElse(null);
    }

    public NoticiaAgencia guardarNotiAgencia (NoticiaAgencia noticiaAgencia) {
        return NARepository.save(noticiaAgencia);
    }

    public NoticiaAgencia actualizaNotiAgencia(NoticiaAgencia noticiaAgencia) {
        NoticiaAgencia notiAgenciaOld = obtenerNotiAgenciaId(noticiaAgencia.getId());  //////////
        notiAgenciaOld.setIdAgencia(noticiaAgencia.getIdAgencia());
        notiAgenciaOld.setFechaAgencia(noticiaAgencia.getFechaAgencia());

        return guardarNotiAgencia(noticiaAgencia);
    }

    public void borraAgencia(long id) {
        NARepository.deleteById(id);
    }
}
