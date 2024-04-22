package mx.utng.ultima.model.dao;


import java.util.List;

import mx.utng.ultima.model.entity.DepartamentoVentas;



public interface IDepartamentoVentasDao {
    //Estos metodos son abstractos no tienen cuerpo
    
    //Listar estudiantes
    List<DepartamentoVentas> list();

    //Guardar un estudiante
    void save(DepartamentoVentas departamentoVentas);

    //Obterner un estudiante en especifico a partir del id
    DepartamentoVentas getById(Long id);

    //Eliminar un estudiante por el id
    void delete(Long id);
}


