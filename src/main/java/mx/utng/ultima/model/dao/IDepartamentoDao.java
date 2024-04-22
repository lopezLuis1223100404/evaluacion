package mx.utng.ultima.model.dao;


import java.util.List;

import mx.utng.ultima.model.entity.Departamento;



public interface IDepartamentoDao {
    //Estos metodos son abstractos no tienen cuerpo
    
    //Listar estudiantes
    List<Departamento> list();

    //Guardar un estudiante
    void save(Departamento departamento);

    //Obterner un estudiante en especifico a partir del id
    Departamento getById(Long id);

    //Eliminar un estudiante por el id
    void delete(Long id);
}


