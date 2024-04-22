package mx.utng.ultima.model.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mx.utng.ultima.model.dao.IEstudianteDao;
import mx.utng.ultima.model.entity.Estudiante;
/*
 * Una clase service, esta basada en el patron de diseño facade.
 * Un unico punto de acceso hacia distintos DAOS (Datas and objects).
 * Dentro de la clase service podemos operar distintas clases DAO.
 */
@Service
public class EstudianteServiceImpl implements IEstudianteService{

    //Inyecta una interfaz para utilizar sus metodos
    @Autowired
    private IEstudianteDao estudianteDao;

    @Transactional(readOnly = true)
    @Override
    public List<Estudiante> list() {
        return estudianteDao.list();
    }

    @Transactional
    @Override
    public void save(Estudiante estudiante) {
        estudianteDao.save(estudiante);
    }

    @Transactional(readOnly = true)
    @Override
    public Estudiante getById(Long id) {
        return estudianteDao.getById(id);
    }

    @Transactional
    @Override
    public void delete(Long id) {
        estudianteDao.delete(id);
    }
    
}

