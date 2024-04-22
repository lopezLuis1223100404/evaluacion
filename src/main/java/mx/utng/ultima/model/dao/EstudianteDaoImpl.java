package mx.utng.ultima.model.dao;


import java.util.List;

import org.springframework.stereotype.Repository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import mx.utng.ultima.model.entity.Estudiante;

@Repository
public class EstudianteDaoImpl implements IEstudianteDao{

    //Coloco un atributo que me permitira gestionar la entidad
    @PersistenceContext
    private EntityManager em;

    @SuppressWarnings("unchecked")
    @Override
    public List<Estudiante> list() {
        return em.createQuery("from Estudiante").getResultList();
    }

    @Override
    public void save(Estudiante estudiante) {
        //Si el id es distinto a nulo o mayor que cero, quiere decir que el registro ya existe lo va a modificar
        if(estudiante.getId() != null && estudiante.getId()>0){
            em.merge(estudiante);
        }else{
            //Registro nuevo al usar persist
            em.persist(estudiante);
        }
    }

    @Override
    public Estudiante getById(Long id) {
        return em.find(Estudiante.class, id);
    }

    @Override
    public void delete(Long id) {
      Estudiante estudiante = getById(id);
      em.remove(estudiante);
    }
    

}
