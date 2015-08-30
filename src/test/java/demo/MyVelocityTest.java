package demo;

import static org.junit.Assert.assertNotNull;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class MyVelocityTest {

	private MyVelocity testInstance;
	
	@Before
	public void setUp() {
		this.testInstance = new MyVelocity();
	}
	
	@After
	public void tearDown() {
		this.testInstance = null;
	}
	
	@Test
	public void testGetVelocityName() {
		this.testInstance.setName("Leo");
		assertNotNull(this.testInstance.getVelocityName());
	}
}
