package petfinder.resource;

import javax.persistence.EntityManager;

import petfinder.persistence.JPAUtil;

public class AbstractResource {
	protected EntityManager getEntityManager() {

		return JPAUtil.getCurrentEntityManager();

	}
}
