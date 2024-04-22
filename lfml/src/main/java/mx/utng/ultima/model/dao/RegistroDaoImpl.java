package mx.utng.ultima.model.dao;


import java.util.List;

import org.springframework.stereotype.Repository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import mx.utng.ultima.model.entity.Registro;

@Repository
public class RegistroDaoImpl implements IRegistroDao{

    //Coloco un atributo que me permitira gestionar la entidad
    @PersistenceContext
    private EntityManager em;

    @SuppressWarnings("unchecked")
    @Override
    public List<Registro> list() {
        return em.createQuery("from Registro").getResultList();
    }

    @Override
    public void save(Registro registro) {
        //Si el id es distinto a nulo o mayor que cero, quiere decir que el registro ya existe lo va a modificar
        if(registro.getId() != null && registro.getId()>0){
            em.merge(registro);
        }else{
            //Registro nuevo al usar persist
            em.persist(registro);
        }
    }

    @Override
    public Registro getById(Long id) {
        return em.find(Registro.class, id);
    }

    @Override
    public void delete(Long id) {
      Registro registro = getById(id);
      em.remove(registro);
    }
    

}
