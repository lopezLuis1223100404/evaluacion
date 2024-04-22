package mx.utng.ultima.model.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mx.utng.ultima.model.dao.IDepartamentoDao;
import mx.utng.ultima.model.entity.Departamento;

/*
 * Una clase service, esta basada en el patron de diseño facade.
 * Un unico punto de acceso hacia distintos DAOS (Datas and objects).
 * Dentro de la clase service podemos operar distintas clases DAO.
 */
@Service
public class DepartamentoServiceImpl implements IDepartamentoService{

    //Inyecta una interfaz para utilizar sus metodos
    @Autowired
    private IDepartamentoDao departamentoDao;

    @Transactional(readOnly = true)
    @Override
    public List<Departamento> list() {
        return departamentoDao.list();
    }

    @Transactional
    @Override
    public void save(Departamento departamento) {
        departamentoDao.save(departamento);
    }

    @Transactional(readOnly = true)
    @Override
    public Departamento getById(Long id) {
        return departamentoDao.getById(id);
    }

    @Transactional
    @Override
    public void delete(Long id) {
        departamentoDao.delete(id);
    }
    
}

