package mx.utng.ultima.model.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mx.utng.ultima.model.dao.IPublicacionDao;
import mx.utng.ultima.model.entity.Publicacion;

/*
 * Una clase service, esta basada en el patron de diseño facade.
 * Un unico punto de acceso hacia distintos DAOS (Datas and objects).
 * Dentro de la clase service podemos operar distintas clases DAO.
 */
@Service
public class PublicacionServiceImpl implements IPublicacionService{

    //Inyecta una interfaz para utilizar sus metodos
    @Autowired
    private IPublicacionDao publicacionDao;

    @Transactional(readOnly = true)
    @Override
    public List<Publicacion> list() {
        return publicacionDao.list();
    }

    @Transactional
    @Override
    public void save(Publicacion publicacion) {
        publicacionDao.save(publicacion);
    }

    @Transactional(readOnly = true)
    @Override
    public Publicacion getById(Long id) {
        return publicacionDao.getById(id);
    }

    @Transactional
    @Override
    public void delete(Long id) {
        publicacionDao.delete(id);
    }
    
}

