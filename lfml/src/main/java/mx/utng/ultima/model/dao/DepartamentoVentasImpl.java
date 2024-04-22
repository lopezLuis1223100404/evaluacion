package mx.utng.ultima.model.dao;


import java.util.List;

import org.springframework.stereotype.Repository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import mx.utng.ultima.model.entity.DepartamentoVentas;

@Repository
public class DepartamentoVentasImpl implements IDepartamentoVentasDao{

    //Coloco un atributo que me permitira gestionar la entidad
    @PersistenceContext
    private EntityManager em;

    @SuppressWarnings("unchecked")
    @Override
    public List<DepartamentoVentas> list() {
        return em.createQuery("from DepartamentoVentas").getResultList();
    }

    @Override
    public void save(DepartamentoVentas departamento) {
        //Si el id es distinto a nulo o mayor que cero, quiere decir que el registro ya existe lo va a modificar
        if(departamento.getId() != null && departamento.getId()>0){
            em.merge(departamento);
        }else{
            //Registro nuevo al usar persist
            em.persist(departamento);
        }
    }

    @Override
    public DepartamentoVentas getById(Long id) {
        return em.find(DepartamentoVentas.class, id);
    }

    @Override
    public void delete(Long id) {
      DepartamentoVentas departamento = getById(id);
      em.remove(departamento);
    }
    

}
