
package petfinder.service;

import javax.persistence.EntityManager;

import org.junit.After;
import org.junit.Before;

import petfinder.persistence.Initializer;
import petfinder.persistence.JPAUtil;

public abstract class PetfinderServiceTest {

	Initializer dataHelper;
	protected EntityManager em;

	public PetfinderServiceTest() {
		super();
	}

	protected void beforeDatabasePreparation(){}
	
	protected void afterDatabasePreparation(){}

	@Before
	public final void setUp() {
		beforeDatabasePreparation();
		dataHelper = new Initializer();
		dataHelper.prepareData();
		em = JPAUtil.getCurrentEntityManager();
		afterDatabasePreparation();
	}

	protected void afterTearDown(){}
	
	@After
	public final void tearDown() {
		em.close();
		afterTearDown();
	}

}