package mx.utng.ultima.model.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mx.utng.ultima.model.dao.IDepartamentoVentasDao;
import mx.utng.ultima.model.entity.DepartamentoVentas;

/*
 * Una clase service, esta basada en el patron de diseño facade.
 * Un unico punto de acceso hacia distintos DAOS (Datas and objects).
 * Dentro de la clase service podemos operar distintas clases DAO.
 */
@Service
public class DepartamentoVentasServiceImpl implements IDepartamentoVentasService{

    //Inyecta una interfaz para utilizar sus metodos
    @Autowired
    private IDepartamentoVentasDao departamentoDao;

    @Transactional(readOnly = true)
    @Override
    public List<DepartamentoVentas> list() {
        return departamentoDao.list();
    }

    @Transactional
    @Override
    public void save(DepartamentoVentas departamento) {
        departamentoDao.save(departamento);
    }

    @Transactional(readOnly = true)
    @Override
    public DepartamentoVentas getById(Long id) {
        return departamentoDao.getById(id);
    }

    @Transactional
    @Override
    public void delete(Long id) {
        departamentoDao.delete(id);
    }
    
}

