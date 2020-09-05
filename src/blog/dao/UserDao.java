package blog.dao;



import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import blog.model.User;
import blog.utility.HibernateConnectionManager;

public class UserDao implements UserDaoInterface {
	
	 
	HibernateConnectionManager hcm = new HibernateConnectionManager();
	SessionFactory sessionFactory = hcm.getSessionFactory();
	@Override
	public int signup(User user) {
		 Session session = sessionFactory.openSession();
	        Transaction transaction = session.beginTransaction(); 
	       try {  session.save(user);
	         transaction.commit();
	        session.close();
	        return 1;
	       }catch(Exception e) {
	    	   e.printStackTrace();
	    	   return 0;
	       }
//	        if(session.save(user)!=null)
//	        	{
//	        		 transaction.commit();
//	        		 session.close();
//	        		return 1;
//	        	}
//	        	else {
//	        		 return 0;  
//	        	}
	        
		
	}

	@Override
	public boolean loginUser(User user) {
		Session session = this.sessionFactory.openSession();
        Transaction tx = null;
      
        try {
            tx = session.getTransaction();
            tx.begin();
            Query query = session.createQuery("from User where email='"+user.getEmail()+"'"+"and password ='"+user.getPassword()+"'");
            user = (User)query.uniqueResult();
            tx.commit();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
        return true;
	}
	
	
	

	
	
	
	
	
	
	
	
	
	
	
	
}
