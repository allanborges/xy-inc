package com.xyincemp.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import org.hibernate.Criteria;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.transform.Transformers;

import com.xyincemp.models.PoI;
import com.xyincemp.models.dto.PoIDto;
import com.xyincemp.util.PersistenceManager;

public class PoIs {

    private EntityManager em = PersistenceManager.getInstance().getEntityManager(); 
    
    public void salva(PoIDto poIDto){
    	try{
	     	EntityTransaction trx = em.getTransaction();
	     	trx.begin();
	     	PoI poI = new PoI();
	     	poI.setCoorX(poIDto.getCoorX());
	     	poI.setCoorY(poIDto.getCoorY());
	     	poI.setNome(poIDto.getNome());
	     	em.persist(poI);
	     	trx.commit();
    	} finally{
    		em.close();
    	}
    }
    
    @SuppressWarnings("unchecked")
	public List<PoIDto> listar(){
    	Session session = getSession();
    	Criteria cri = session.createCriteria(PoI.class,"poi");
    	cri.setProjection(Projections.projectionList()
    					  .add(Projections.alias(Projections.property("coorX"), "coorX"))
    			          .add(Projections.alias(Projections.property("coorY"), "coorY"))
    			          .add(Projections.alias(Projections.property("nome"), "nome")));
    	
    	
    	
    	cri.addOrder(Order.asc("nome"));
    	
    	cri.setResultTransformer(Transformers.aliasToBean(PoIDto.class));
    	
    	List<PoIDto> poIDtos = cri.list();
    	
    	session.close();
    		
    	return poIDtos;
    }
    
  
    /**
     * Usei uma query nativa para listar os PoIs por proximidade, a lógica da query usa o Teorema de Pitagoras
     * para calcular a distância entre os PONTOS (x1,y1,x2,y2)
     * 
     * @param poiDto
     * @return
     */
    @SuppressWarnings("unchecked")
	public List<PoIDto> listarPorProximidade(PoIDto poiDto){
    	
    	Session session = getSession();
    		
    	String sqlQuery = "SELECT poi.nome As nome,poi.coorX,poi.coorY FROM PoI poi WHERE "
    					+ "round(sqrt( pow(abs(poi.coorX - :coorX2),2) + pow(abs(poi.coorY - :coorY2),2)),2) <= :distanciaMax";
    	
    	SQLQuery query = session.createSQLQuery(sqlQuery);
     	query.setParameter("coorX2", poiDto.getCoorX());
    	query.setParameter("coorY2", poiDto.getCoorY());
    	query.setParameter("distanciaMax",poiDto.getDistanciaMax());

    	query.setResultTransformer(Transformers.aliasToBean(PoIDto.class));
    	
    	List<PoIDto> poIDtos = query.list();
    	
    	session.close();
    	
    	return poIDtos;
    }
    
    public Session getSession(){
    	Session session = em.unwrap(Session.class);
    	return session;
    }

}
