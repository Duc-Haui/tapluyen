import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.app.dao.UsersDAO;
import com.app.entity.Users;

public class UsersTest {
	private static EntityManagerFactory entityManagerFactory;
	private static UsersDAO usersDAO;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		entityManagerFactory = Persistence.createEntityManagerFactory("db");
		usersDAO = new UsersDAO();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		entityManagerFactory.close();
	}

	@Test
	public void testCreate() {
		Users users = new Users();
		users.setEmail("danghong997@gmail.com");
		users.setPassword("password11");
		users.setFullName("fuullName");
		
		users = usersDAO.create(users);
		assertTrue(users.getId()>0);
		
		
	}
	
	@Test
	public void testUpdate() {
		Integer id = 72;
		Users users = usersDAO.find(id);
		users.setEmail("emailemail");
		
		users = usersDAO.update(users);
		
		String exp = "emailemail";
		String act = users.getEmail();
		assertEquals(exp, act);
	}
	
	@Test
	public void testDelete() {
		Integer id = 72;
		usersDAO.delete(id);
		Users users = usersDAO.find(id);
		assertNull(users);
	}
	
	@Test
	public void testListAll() {
		List<Users> lst = usersDAO.listAll();
		for (Users users : lst) {
			System.out.println("id : " + users.getId() + " " + "full name : " + users.getFullName());
		}
	}
	
	@Test
	public void testCount() {
		Long result = usersDAO.count();
		System.out.println(result);
	}
	
	@Test
	public void testFindByEmail() {
		String email = "duc111111111@gmail.com";
		Users users = usersDAO.findByEmail(email);
		assertNotNull(users);
	}

	@Test
	public void testLogin() {
		String email = "duc@gmail.com";
		String password = "duc123";
		
		boolean result = usersDAO.checkLogin(email, password);
		assertTrue(result);
	}
	
}
