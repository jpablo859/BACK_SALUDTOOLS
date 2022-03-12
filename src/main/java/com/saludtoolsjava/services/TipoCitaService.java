package com.saludtoolsjava.services;

import com.saludtoolsjava.models.TipoCitaModel;

import java.util.List;

public interface TipoCitaService {

    List<TipoCitaModel> getTiposCita();

    TipoCitaModel getTipoCita(Integer id);

    TipoCitaModel postTipoCita(TipoCitaModel body);

    void deleteTipoCita(Integer id);

    String updateEstadoTipoCita(String estado, Integer id);

}
