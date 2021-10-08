import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serializable;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import javax.swing.AbstractAction;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;



public class Fenetre extends JFrame implements ActionListener,Serializable{
	private static final long serialVersionUID = 1L;
	JLabel commandeFan= new JLabel("Choisir la ventilateur: ");
	
	JLabel commandeVitesse= new JLabel("Modifier la vitesse: ");
	
	JLabel resultat= new JLabel("");
	
	JPanel P2= new JPanel();
	JPanel P1= new JPanel();
	JPanel P3= new JPanel();
	JTextField vitesse= new JTextField("",20);
	
	
	JCheckBox b1,b2,b3,b4;
	ButtonGroup groupe= new ButtonGroup();
	JButton btnSet= new JButton("SET!");
	
	
	
	
	
	
	public Fenetre() {
		super("Interface Client");
		P1.setBounds(50,50,300,20);
		this.setSize(500,400);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
		this.setLayout(new GridLayout(5,2,15,15));
		
		

		
		
		b1= new JCheckBox("0");
		b1.setBounds(100,100,150,20); 
		b2= new JCheckBox("1");
		b2.setBounds(100,150,150,20);  
		b3= new JCheckBox("2");
		b3.setBounds(100,200,150,20); 
		b4= new JCheckBox("ALL");
		b3.setBounds(100,250,150,20); 
		groupe.add(b1);groupe.add(b2);groupe.add(b3);groupe.add(b4);
		
		
		P1.setLayout(new FlowLayout(1,25,15));
		P1.add(commandeFan);
		P1.add(b1);
		P1.add(b2);
		P1.add(b3);
		P1.add(b4);
		this.add(P1);
	
		
		P2.setLayout(new FlowLayout());
		P2.add(commandeVitesse);
		P2.add(vitesse);
		this.add(P2);
		
		
		P3.add(btnSet);
		this.add(P3);
		
		
		
		
		
		
		this.add(resultat);
		resultat.setHorizontalAlignment(JLabel.CENTER);
		
		
		
		
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		b4.addActionListener(this);
		
		
		btnSet.addActionListener(new Action());
		
		
		

	}
	


	
	
	
	
	public class Action extends AbstractAction {
		
		private static final long serialVersionUID = 1L;
		int number;
		
		
		@Override
		public void actionPerformed(ActionEvent e) {
			try {
			int vitesseFan= Integer.parseInt(vitesse.getText()) ;
			
			
			resultat.setForeground(Color.red);
			RemoteInter stub;
			stub = (RemoteInter) Naming.lookup("rmi://localhost:50/objetAnnuaire");
			
			
			if(vitesseFan>=0 && vitesseFan<=1200) {
				
			
			
				if(b1.isSelected()) {
					number=0;
				
					
				
				}
				else if (b2.isSelected()) {
					number=1;
					
				}
				else if (b3.isSelected()) {
					number=2;

				}
				else if(b4.isSelected()) {
					String rep= stub.creerFichierAll(vitesseFan);
					if (rep.equals("OK")) {
						resultat.setForeground(Color.green);
						resultat.setText("OK");
					}
					else {
						resultat.setText(rep);
					}
				
				
				}
				else {
					resultat.setText("Selectionner une fan!");
				}
				
				if(b1.isSelected() || b2.isSelected() || b3.isSelected() ) {
					
						String res=stub.creerFichier(number,vitesseFan);
						if(res.equals("OK")) {
							resultat.setForeground(Color.GREEN);
							resultat.setText(res);
							
						}
						else {
							resultat.setText(res);
						}
					
				}
			}
			
			else {
				resultat.setText("UNSUPPORTED ROTATION SPEED!");
			}
			
			
				
			} catch (MalformedURLException | RemoteException | NotBoundException   | NumberFormatException e1) {
				resultat.setForeground(Color.RED);
				resultat.setText("Valider la vitesse!");
			}
	
	}
	
	
}
	public static void main (String[] args) {
		Fenetre f= new Fenetre();
		f.setVisible(true);
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}





