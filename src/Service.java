
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Serializable;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class Service extends UnicastRemoteObject
implements RemoteInter,Serializable{


	private static final long serialVersionUID = 1L;


	protected Service() throws RemoteException {
		super();
	}
	

	public String creerFichier(int number, int vitesse) {
		String reponse= "";
		try {
		
		PrintWriter out= new PrintWriter(new FileWriter("C:\\Users\\Ghazi\\Desktop\\ProjetJava\\opt\\sensors\\fan"+number+".txt",true));
		out.println("la vanne "+number+" est de vitesse: "+vitesse);
		out.close();
		reponse="it's OK";
		return reponse;
		
		}
		catch (Exception e){
			reponse="SERVER ERROR!";
			return reponse;
			
		}
	}
	
	
	
	public String creerFichierAll(int vitesse) {
		String reponse="";
		try {
			PrintWriter out0= new PrintWriter(new FileWriter("C:\\Users\\Ghazi\\Desktop\\ProjetJava\\opt\\sensors\\fan0.txt",true));
			PrintWriter out1= new PrintWriter(new FileWriter("C:\\Users\\Ghazi\\Desktop\\ProjetJava\\opt\\sensors\\fan1.txt",true));
			PrintWriter out2= new PrintWriter(new FileWriter("C:\\Users\\Ghazi\\Desktop\\ProjetJava\\opt\\sensors\\fan2.txt",true));
			
			out0.println("Vanne 0 est de vitesse: "+vitesse);
			out1.println("Vanne 1 est de vitesse: "+vitesse);
			out2.println("Vanne 2 est de vitesse: "+vitesse);

			
			
			out0.close();
			out1.close();
			out2.close();
			
			reponse="it's OK";
			return reponse;

		} catch (IOException e) {
			reponse="SERVER ERROR!";
			return reponse;
			
			
		}

		
	}

}
