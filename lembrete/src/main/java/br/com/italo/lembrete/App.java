package br.com.italo.lembrete;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


public class App 
{
	
	private static EntityManagerFactory entityManagerFactory;
	
    public static void main( String[] args )
    {
    	entityManagerFactory = Persistence.createEntityManagerFactory("hibernatejpa");
    	
    	//insert();
    	//listAll();
    	//findId();
    	//findTitulo();
    	//update();
    	//delete();
    	
    }
    
	public static void insert() {
    	Lembrete lembrete = new Lembrete();
    	lembrete.setTitulo("Ir ao Banco");
    	lembrete.setDescricao("Hoje, 9h30");
    	
    	EntityManager em = entityManagerFactory.createEntityManager();
    	    
    	try {
    		em.getTransaction().begin();
    	    em.persist(lembrete);
    	    em.getTransaction().commit();
    	} catch (Exception e) {
    	    em.getTransaction().rollback();
    	    
    	    System.out.println("INSERT: " + e.getMessage());
    	} finally {
    	    em.close();
    	}
	}
    
    public static void listAll() {
    	List<Lembrete> lembretes = null;
    	     
    	EntityManager em = entityManagerFactory.createEntityManager();
    	      
    	try {
    		lembretes = em.createQuery("from Lembrete").getResultList();
    	} catch (Exception e) {
    		System.out.println("LIST ALL: " + e.getMessage());
    	} finally {
    		em.close();
    	}
    	
    	if (lembretes != null) {
    		lembretes.forEach(System.out::println);
    	}
    }
    
    public static void findId() {
        EntityManager em = entityManagerFactory.createEntityManager();
        
        Lembrete lembrete = null;
        
        try {
        	lembrete = em.find(Lembrete.class, 1L);
        	System.out.println(lembrete);
        } catch(Exception e) {
        	e.getMessage();
        } finally {
        	em.close();
        }   
    }
    
    public static void findTitulo() {
    	List<Lembrete> lembretes = null;
    	  
    	EntityManager em = entityManagerFactory.createEntityManager();
    
    	try {
    		lembretes = em.createQuery("from Lembrete l where l.titulo LIKE '%comprar%'").getResultList();
    	} catch (Exception e) {
    		System.out.println("LIST ALL: " + e.getMessage());
    	} finally {
    		em.close();
    	}
    	
    	if (lembretes != null) {
    		lembretes.forEach(System.out::println);
    	}
    }
    
    public static void update() {
    	EntityManager em = entityManagerFactory.createEntityManager();
    	
    	try {
    		Lembrete lembrete = em.find(Lembrete.class, 1L);
    	
    		lembrete.setTitulo("Comprar café");
    		lembrete.setDescricao("Hoje, 8h22");
    	
    		em.getTransaction().begin();
    		em.merge(lembrete);
    		em.getTransaction().commit();
    	} catch (Exception e) {
    		em.getTransaction().rollback();
    		System.out.println("UPDATE: " + e.getMessage());
    	} finally {
    		em.close();
    	}
    }
    
    public static void delete() {
    	EntityManager em = entityManagerFactory.createEntityManager();      
    	try {
    		Lembrete lembrete = em.find(Lembrete.class, 1l);
    		
    		em.getTransaction().begin();
    		em.remove(lembrete);
    		em.getTransaction().commit();
    	} catch (Exception e) {
    		em.getTransaction().rollback();
    		System.out.println("DELETE: " + e.getMessage());
    	} finally {
    		em.close();
    	}
    }
    
}