package mx.utng.ultima.model.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import mx.utng.ultima.model.dao.IRegistroDao;
import mx.utng.ultima.model.entity.Registro;
/*
 * Una clase service, esta basada en el patron de diseño facade.
 * Un unico punto de acceso hacia distintos DAOS (Datas and objects).
 * Dentro de la clase service podemos operar distintas clases DAO.
 */
@Service
public class RegistroServiceImpl implements IRegistroService{

    //Inyecta una interfaz para utilizar sus metodos
    @Autowired
    private IRegistroDao registroDao;

    @Transactional(readOnly = true)
    @Override
    public List<Registro> list() {
        return registroDao.list();
    }

    @Transactional
    @Override
    public void save(Registro registro) {
        registroDao.save(registro);
    }

    @Transactional(readOnly = true)
    @Override
    public Registro getById(Long id) {
        return registroDao.getById(id);
    }

    @Transactional
    @Override
    public void delete(Long id) {
        registroDao.delete(id);
    }
    
}

