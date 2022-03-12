package com.saludtoolsjava.services.impl;

import com.saludtoolsjava.dao.TipoCitaDao;
import com.saludtoolsjava.models.TipoCitaModel;
import com.saludtoolsjava.services.TipoCitaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;

@Service
@Transactional
public class TipoCitaServiceImpl implements TipoCitaService {

    @Autowired
    private TipoCitaDao tipoCitaDao;

    @Override
    public List<TipoCitaModel> getTiposCita() {
        return tipoCitaDao.findAll();
    }

    @Override
    public TipoCitaModel getTipoCita(Integer id) {
        return tipoCitaDao.findById(id).orElse(null);
    }

    @Override
    public TipoCitaModel postTipoCita(TipoCitaModel body) {
        if (body.getId() != null) {
            body.setUpdatedAt(new Date());
        } else {
            body.setEstado("Activa");
            body.setCreatedAt(new Date());
        }
        return tipoCitaDao.save(body);
    }

    @Override
    public void deleteTipoCita(Integer id) {
        tipoCitaDao.deleteById(id);
    }

    @Override
    public String updateEstadoTipoCita(String estado, Integer id) {
        if (estado.equals("Activa")) {
            estado = "Inactiva";
        } else {
            estado = "Activa";
        }
        tipoCitaDao.updateEstadoTipoCita(estado, id);
        return estado;
    }
}
