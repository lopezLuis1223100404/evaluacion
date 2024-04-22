package mx.utng.ultima.model.service;


import java.util.List;

import mx.utng.ultima.model.entity.Estudiante;



public interface IEstudianteService {
    List<Estudiante> list();
    void save(Estudiante estudiante);
    Estudiante getById(Long id);
    void delete(Long id);
}

