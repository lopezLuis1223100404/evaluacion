package mx.utng.ultima.model.service;


import java.util.List;

import mx.utng.ultima.model.entity.Departamento;



public interface IDepartamentoService {
    List<Departamento> list();
    void save(Departamento departamento);
    Departamento getById(Long id);
    void delete(Long id);
}

