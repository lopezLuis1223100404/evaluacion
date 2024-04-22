package mx.utng.ultima.model.service;


import java.util.List;

import mx.utng.ultima.model.entity.Publicacion;

public interface IPublicacionService {
    List<Publicacion> list();
    void save(Publicacion publicacion);
    Publicacion getById(Long id);
    void delete(Long id);
}

