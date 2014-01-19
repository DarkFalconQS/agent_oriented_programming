

import jade.wrapper.AgentController;
import jade.wrapper.ContainerController;
import jade.wrapper.StaleProxyException;
import inventory.RackAgent;
import inventory.GlobalInventoryAgent;

public class RunMe {

	public static void main(String[] args) {
		
		RunJade r=new RunJade(true,"30000");

		//RunJade r=new RunJade("193.226.37.ceva", "30000","30000");
		
		//you will need this pointer to the created container in order to be able to create agents
		ContainerController home = r.getHome();
		

		///////////////////////////////////////////////////////////////////////////
		//Hier starten we onze clients		
		try {

			AgentController a = home.createNewAgent("Rack1",RackAgent.class.getName(), new Object[0]);
			a.start();
			
			
			a = home.createNewAgent("Global",GlobalInventoryAgent.class.getName(), new Object[0]);
			a.start();
		

		} catch (StaleProxyException e) {
			e.printStackTrace();
		}
		


	}
}
