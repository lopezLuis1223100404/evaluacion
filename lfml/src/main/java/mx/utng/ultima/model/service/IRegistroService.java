package mx.utng.ultima.model.service;


import java.util.List;

import mx.utng.ultima.model.entity.Registro;



public interface IRegistroService {
    List<Registro> list();
    void save(Registro registro);
    Registro getById(Long id);
    void delete(Long id);
}

