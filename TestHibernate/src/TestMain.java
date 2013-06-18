import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
public class TestMain {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		TestMain obj = new TestMain();

		obj.saveRecord();

		obj.updateUser(12);

		obj.deleteUser(10);

		obj.getList();

		obj.getList();
	  */
		UsersHome mgr = new UsersHome();
		System.out.println(mgr.findById(1).getFName());
		
		//mgr.persist(new Users(99,"test","tetst",1,"test","test","test","test",true));
		mgr.attachDirty(new Users(122,"test1","tetst",1,"test","test","test","test",true));
		ProductHome mgr1 = new ProductHome();
		mgr1.attachDirty(new Product("Product3","Coffee",1000L));
		mgr1.attachDirty(new Product("Product4","Coffee",2000L));
	}
	
	
	public void saveRecord()
	{
		Users u = new Users(0, "Jitendra", "Zaa", 1, "jitendra.zaa", "jitendra.zaa@shivasoft.in", "test", "this is note", true);
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;
		try
		{
			transaction = session.beginTransaction();
			session.save(u);
			transaction.commit();
			System.out.println("Data Saved");
		}catch(Exception e)
		{
			e.printStackTrace();
		}finally{session.close();}

	}
	
	
	public void deleteUser(long UserId)
	{
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;
		try
		{
			transaction = session.beginTransaction();
			Users u = (Users)session.get(Users.class,UserId);
			
			u.setIsActive(false);
			//session.delete(u);
			transaction.commit();
			System.out.println("Data Deleted");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally{
			session.close();
		}
	}
	public void updateUser(long UserId)
	{
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;
		try
		{
			transaction = session.beginTransaction();
			Users u = (Users)session.get(Users.class,UserId);
			u.setFName("ShivaSoft");
			transaction.commit();
			System.out.println("Data Updated");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally{
			session.close();
		}
	}

	public void getList()
	{
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;
		try
		{
			transaction = session.beginTransaction();
			List<Users> uList = session.createQuery("from Users").list();
			for(Users u : uList)
			{
				System.out.println("First Name - "+u.getFName());
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally{
			session.close();
		}
	}
	

}
