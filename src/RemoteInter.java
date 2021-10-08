
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface RemoteInter extends Remote {
	public  String creerFichier(int number, int vitesse) throws RemoteException;
	public String creerFichierAll(int vitesse) throws RemoteException;
}
