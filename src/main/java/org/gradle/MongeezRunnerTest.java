/**
 * 
 */
package org.gradle;

import java.net.UnknownHostException;

import org.mongeez.Mongeez;
import org.springframework.core.io.ClassPathResource;

import com.mongodb.MongoClient;

/**
 * @author mmuduganti
 *
 */
public class MongeezRunnerTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws UnknownHostException {
		Mongeez mongeez = new Mongeez();
		mongeez.setFile(new ClassPathResource("mongeez.xml"));
		mongeez.setMongo(new MongoClient("localhost", 27017));
		mongeez.setDbName("mongeeztest");
		mongeez.process(); 
	}

}
