/**
 * 
 */
package petfinder.domain;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author spyros
 *
 */

@Entity
@Table(name = "AnimalWelfare")
public class AnimalWelfare extends User {

	/**
	 * 
	 */
	public AnimalWelfare() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param FullName
	 * @param Telephone
	 * @param Email
	 */
	public AnimalWelfare(String FullName, String Telephone, String Email) {
		super(FullName, Telephone, Email);
		// TODO Auto-generated constructor stub
	}

}
