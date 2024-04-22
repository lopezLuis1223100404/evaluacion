package mx.utng.ultima.model.dao;


import java.util.List;

import mx.utng.ultima.model.entity.Estudiante;



public interface IEstudianteDao {
    //Estos metodos son abstractos no tienen cuerpo
    
    //Listar estudiantes
    List<Estudiante> list();

    //Guardar un estudiante
    void save(Estudiante estudiante);

    //Obterner un estudiante en especifico a partir del id
    Estudiante getById(Long id);

    //Eliminar un estudiante por el id
    void delete(Long id);
}


