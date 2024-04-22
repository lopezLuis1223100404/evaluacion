package mx.utng.ultima.model.dao;


import java.util.List;

import mx.utng.ultima.model.entity.Publicacion;


public interface IPublicacionDao {
    //Estos metodos son abstractos no tienen cuerpo
    
    //Listar estudiantes
    List<Publicacion> list();

    //Guardar un estudiante
    void save(Publicacion publicacion);

    //Obterner un estudiante en especifico a partir del id
    Publicacion getById(Long id);

    //Eliminar un estudiante por el id
    void delete(Long id);
}


