package com.eventosapp.acessingdatamysql;

import com.eventosapp.models.Convidado;
import com.eventosapp.models.Evento;
import org.springframework.data.repository.CrudRepository;

public interface ConvidadoRepository extends CrudRepository<Convidado, String> {
    Iterable<Convidado> findByEvento(Evento evento);
}