package mx.utng.ultima.model.service;


import java.util.List;

import mx.utng.ultima.model.entity.DepartamentoVentas;



public interface IDepartamentoVentasService {
    List<DepartamentoVentas> list();
    void save(DepartamentoVentas departamentoVentas);
    DepartamentoVentas getById(Long id);
    void delete(Long id);
}

