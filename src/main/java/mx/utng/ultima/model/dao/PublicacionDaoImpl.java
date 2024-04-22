package mx.utng.ultima.model.dao;


import java.util.List;

import org.springframework.stereotype.Repository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import mx.utng.ultima.model.entity.Publicacion;

@Repository
public class PublicacionDaoImpl implements IPublicacionDao{

    //Coloco un atributo que me permitira gestionar la entidad
    @PersistenceContext
    private EntityManager em;

    @SuppressWarnings("unchecked")
    @Override
    public List<Publicacion> list() {
        return em.createQuery("from Publicacion").getResultList();
    }

    @Override
    public void save(Publicacion publicacion) {
        //Si el id es distinto a nulo o mayor que cero, quiere decir que el registro ya existe lo va a modificar
        if(publicacion.getId() != null && publicacion.getId()>0){
            em.merge(publicacion);
        }else{
            //Registro nuevo al usar persist
            em.persist(publicacion);
        }
    }

    @Override
    public Publicacion getById(Long id) {
        return em.find(Publicacion.class, id);
    }

    @Override
    public void delete(Long id) {
      Publicacion publicacion = getById(id);
      em.remove(publicacion);
    }
    

}
