

import jade.wrapper.AgentController;
import jade.wrapper.ContainerController;
import jade.wrapper.StaleProxyException;
<<<<<<< HEAD
import inventory.RackAgent;
import inventory.GlobalInventoryAgent;
=======
import order.OrderPickerAgent;
>>>>>>> 85f218b22889d595110f6c9e68e40cb5d94b929d

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
<<<<<<< HEAD
		
=======
                        
                        a = home.createNewAgent("Global",OrderPickerAgent.class.getName(), new Object[0]);
			a.start();
>>>>>>> 85f218b22889d595110f6c9e68e40cb5d94b929d

		} catch (StaleProxyException e) {
			e.printStackTrace();
		}
		


	}
}
