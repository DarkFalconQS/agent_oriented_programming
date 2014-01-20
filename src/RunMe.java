
import inventory.GlobalInventoryAgent;
import inventory.RackAgent;
import jade.wrapper.AgentController;
import jade.wrapper.ContainerController;
import jade.wrapper.StaleProxyException;
import order.OrderPickerAgent;

/**
 * Aceasta este o clasa principala . Modificati-o pentru a rula agentii vostri.
 *
 */
public class RunMe {

	public static void main(String[] args) {
		
		//double click the  RunJade constructor to see the java doc asociated with it (that includes the parameter significance)
		
		//pentru a rula un container auxiliar comenteaza urmatoarea linie
		RunJade r=new RunJade(true,"30000");// asta porneste un main container pe masina curenta portul 30000

		//pentru a rula un container auxiliar: decomenteaza linia urmatoare si scrie ip-ul MainContainer-ului (asa cum e acum nu va merge sigur din cauza lui "ceva")
		//RunJade r=new RunJade("193.226.37.ceva", "30000","30000");
		
		/**
		daca rulati un container auxiliar si in MainContainer ati rulat aceiasi agenti va aparea o eroare "name-clash" 
		aceasta se datoreaza faptului ca ati incercat sa creati 2 agenti cu acelasi nume unul in MainContainer si unul in Containerul auxiliar (mai exact "a1" si "a2")
		SOLUTIE: aveti grija ca numele sa fie unice in intreaga platforma.
		*/
		
		//you will need this pointer to the created container in order to be able to create agents
		ContainerController home = r.getHome();
		

		///////////////////////////////////////////////////////////////////////////
		//crearea propriu-zisa a unui agent		
		try {

			AgentController a = home.createNewAgent("Rack1",RackAgent.class.getName(), new Object[0]);
			a.start();
			
			
			a = home.createNewAgent("Global",GlobalInventoryAgent.class.getName(), new Object[0]);
			a.start();

                        
                        a = home.createNewAgent("OrderPicker",OrderPickerAgent.class.getName(), new Object[0]);
			a.start();

		} catch (StaleProxyException e) {
			e.printStackTrace();
		}
		


	}
}
