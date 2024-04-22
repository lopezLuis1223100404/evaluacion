package mx.utng.ultima.model.dao;


import java.util.List;

import mx.utng.ultima.model.entity.Registro;



public interface IRegistroDao {
    //Estos metodos son abstractos no tienen cuerpo
    
    //Listar estudiantes
    List<Registro> list();

    //Guardar un estudiante
    void save(Registro registro);

    //Obterner un estudiante en especifico a partir del id
    Registro getById(Long id);

    //Eliminar un estudiante por el id
    void delete(Long id);
}


