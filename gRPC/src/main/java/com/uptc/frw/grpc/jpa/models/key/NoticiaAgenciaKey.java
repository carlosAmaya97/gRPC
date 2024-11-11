package com.uptc.frw.grpc.jpa.models.key;

import com.uptc.frw.grpc.jpa.models.Agencia;

import java.io.Serializable;

public class NoticiaAgenciaKey implements Serializable {
    private Noticia noticia;
    private Agencia agencia;
}
