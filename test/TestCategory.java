import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.fail;

import java.util.List;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.app.dao.CategoryDAO;
import com.app.entity.Category;

public class TestCategory {
	private static EntityManagerFactory entityManagerFactory;
	private static CategoryDAO categoryDAO;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		entityManagerFactory = Persistence.createEntityManagerFactory("db");
		categoryDAO = new CategoryDAO();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		entityManagerFactory.close();
	}

	@Test
	public void testCreateCategory() {
		Category category = new Category();
		category.setName("sach IT4");
		category = categoryDAO.create(category);
		assertNotNull(category.getCategoryId() > 0);
	}

	@Test
	public void testUpdateCategory() {
		Integer id = 51;
		Category category = categoryDAO.find(id);
		category.setName("name");
		category = categoryDAO.update(category);
		String act = "name";
		String exp = category.getName();
		assertEquals(exp, act);
	}

	@Test
	public void testFindObject() {
		Integer id = 1;
		Category category = categoryDAO.find(id);
		assertNotNull(category);
	}

	@Test
	public void testDeleteObject() {
		Integer id = 33;
		categoryDAO.delete(id);
	}

	@Test
	public void testListAll() {
		List<Category> lst = categoryDAO.listAll();
		for(Category category : lst) {
			System.out.println(category.getName() + " " + category.getCategoryId());
		}
	}

	@Test
	public void testCount() {
		long result = categoryDAO.count();
		System.out.println(result);
	}

}
