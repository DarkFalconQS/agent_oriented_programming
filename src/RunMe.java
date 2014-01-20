
import inventory.GlobalInventoryAgent;
import inventory.RackAgent;
import jade.wrapper.AgentController;
import jade.wrapper.ContainerController;
import jade.wrapper.StaleProxyException;
import order.OrderPickerAgent;

/**
 * This is the main class. Modify it to run your agents.
 *
 */
public class RunMe {

	public static void main(String[] args) {
		
		//double click the  RunJade constructor to see the java doc asociated with it (that includes the parameter significance)
		
		//Booster to run a comment next line
		RunJade r=new RunJade(true,"30000");// this starts a main container on the current car port 30000

		// to run a Booster: uncomment the next line and enter the ip's MainContainer (as it certainly will not work now because of "something") 
                // R = new RunJade RunJade ("193.226.37.ceva", "30000", "30000");

		/**
		If you run a MainContainer Booster and you run the same agents will appear an error "name-clash" 
                This is because you tried to create two agents with the same name in MainContainer one and one booster (ie "a1" and "a2") 
                SOLUTION: Make sure that names be unique across the platform.
		*/
		
		//you will need this pointer to the created container in order to be able to create agents
		ContainerController home = r.getHome();
		

		///////////////////////////////////////////////////////////////////////////
		//actual creation of an agent		
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
