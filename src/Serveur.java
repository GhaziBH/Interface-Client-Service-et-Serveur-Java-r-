
import java.io.Serializable;
import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

public class Serveur implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static void main(String [] args) {
		try {
			Service objet= new Service();
			LocateRegistry.createRegistry(50);
			Naming.rebind("rmi://localhost:50/objetAnnuaire", objet);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
}
