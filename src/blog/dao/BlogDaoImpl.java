package blog.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import blog.model.Blog;
import blog.utility.ConnectionManager;
import blog.utility.HibernateConnectionManager;

public class BlogDaoImpl implements BlogDaoInterface  {
	

	private SessionFactory sessionfactory=HibernateConnectionManager.getSessionFactory();
	
	@Override
	public void insertBlog(Blog blog) throws SQLException {
		Session session=this.sessionfactory.openSession();
		Transaction t=session.beginTransaction();
		session.save(blog);
		t.commit();
		session.close();
	}

	@Override
	public Blog selectBlog(int blogId) {
		Session session=this.sessionfactory.openSession();
		Blog blog=session.get(Blog.class,blogId);
		session.close();
		return blog;
	}

	@Override
	public List<Blog> selectALLBlogs() {
		Session session=this.sessionfactory.openSession();
		CriteriaBuilder builder=session.getCriteriaBuilder();
		CriteriaQuery<Blog> query=builder.createQuery(Blog.class);
		Root<Blog> root=query.from(Blog.class);
		query.select(root);
		Query<Blog> q=session.createQuery(query);
		List<Blog> listblog=q.getResultList();
		
		return listblog;
		
	}

	
	public void deleteBlog(int id) throws SQLException {
		Session session=this.sessionfactory.openSession();
		Transaction t=session.beginTransaction();
		Blog blog=session.get(Blog.class, id);
		session.delete(blog);
		t.commit();
		session.close();
		
		
		
	}

	public void updateBlog(Blog blog) throws SQLException, Exception {
		Session session=this.sessionfactory.openSession();
		Transaction t=session.beginTransaction();
		session.update(blog);
		t.commit();
		session.close();
		
		
	}

	
	

}
