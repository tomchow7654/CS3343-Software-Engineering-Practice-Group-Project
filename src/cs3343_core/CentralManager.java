package cs3343_core;

import java.util.*;

public class CentralManager {

	private static String[] districts = { "Ariyalur", "Karur", "Nagapattinam", "Perambalur", "Pudukkottai", "Thanjavur",
			"Tiruchirappalli", "Tiruvarur", "Dharmapuri", "Coimbatore", "Erode", "Krishnagiri", "Namakkal",
			"The Nilgiris", "Salem", "Tiruppur", "Dindigul", "Kanyakumari", "Madurai", "Ramanathapuram", "Sivaganga",
			"Theni", "Thoothukudi", "Tirunelveli", "Virudhunagar", "Chennai", "Cuddalore", "Kanchipuram", "Tiruvallur",
			"Tiruvannamalai", "Vellore", "Viluppuram" };
	private static String[] water_names = { "Clever Water", "Keep Water", "Suburban Water", "Water Excite",
			"HighSpeed Water", "Letter Water", "Pyramid Water", "Provider Water", "Models Water", "Clearwater Water",
			"TopLevel Water", "Marker Water", "Vision Water", "Magnetic Water", "Evolved Water", "Party Water",
			"Tandem Water", "Ember Water", "Object Water", "Favorite Water", "StraightUp Water", "Circuit Water",
			"Artist Water", "Citywide Water" };
	private static String[] network_names = { "Incorporated Broadbrand network", "Lead Broadbrand network",
			"Aries Broadbrand network", "Avatar Broadbrand network", "Soft Broadbrand network",
			"Broadbrand network Transform", "Tone Broadbrand network", "Quark Broadbrand network",
			"Photon Broadbrand network", "ify Broadbrand network", "Senator Broadbrand network",
			"Loft Broadbrand network", "Landmark Broadbrand network", "Links Broadbrand network",
			"Mobile Broadbrand network", "Pass Broadbrand network", "Companion Broadbrand network",
			"Goddess Broadbrand network", "Oceanside Broadbrand network", "Explorer Broadbrand network",
			"Fish Broadbrand network", "Leadership Broadbrand network", "Handsome Broadbrand network",
			"Group Broadbrand network" };
	private static String[] electricity_names = { "Canary Power", "OneUp Power", "Starfish Power", "Growing Power",
			"BlueSky Power", "Under Power", "Sells Power", "Point Power", "Tube Power", "Mindful Power", "Speedy Power",
			"Unlock Power", "Driven Power", "Help Power", "YourChoice Power", "Reason Power", "Leather Power",
			"Collection Power", "Vest Power", "Technologies Power", "LowCountry Power", "Partnership Power",
			"Principal Power", "Advantage Power" };

	public static int config_nodes = 50;			//max 50
	public static int config_connections = 2000;

	private static Connection[] connections = new Connection[config_connections];
	private static Node[] nodes = new Node[config_nodes];
	private static CentralManager instance = new CentralManager();

	private CentralManager() {
	};

	public static CentralManager getInstance() {
		return instance;
	}

	public void setup() {

		Random rand = new Random();
		for (int i = 0; i < config_nodes; i++) {
			Node n = new Node(districts[rand.nextInt(districts.length)], rand.nextInt(300) + rand.nextDouble(),
					rand.nextInt(300) + rand.nextDouble());
			n.setId(i);
			nodes[i] = n;
			System.out.println(String.format("[Setup] Added Node: [%2d] %-18s (%8s, %8s)", n.getId(), n.getNode_name(),
					String.format("%3.4f", n.getLatitude()), String.format("%3.4f", n.getLongtitute())));
		}
		for (int i = 0; i < config_connections; i++) {
			int type = rand.nextInt(3) % 3;
			Service s = null;
			switch (type) {
			case 0:
				s = (Service) new Electricity(electricity_names[rand.nextInt(electricity_names.length)], 0);
				break;
			case 1:
				s = (Service) new Network(network_names[rand.nextInt(network_names.length)], 1);
				break;
			case 2:
				s = (Service) new Water(water_names[rand.nextInt(water_names.length)], 2);
				break;
			}
			int start_index = rand.nextInt(nodes.length);
			int next_index  = rand.nextInt(nodes.length);
			Connection c = new Connection(nodes[start_index], nodes[next_index], s);
			connections[i] = c;
			System.out.println("[Setup] Added connection: " + c.toString());
		}

		System.out.println("[Setup] Setup has created " + config_nodes + " nodes and " + config_connections + ".");

	}
	
	public void checkNodeConnectivity() {
		for (Node n : nodes) {
			String result = String.format("[Setup][Check] Node %2d has connected to: ", n.getId());
			if(n.getConnectionCount()>0) {
				result += String.format("(%2d) %s.", n.getConnectionCount(), n.getConnections());
			} else {
				result += "( 0) No connections.";
			}
			System.out.println(result);
		}
	}

	public static Connection[] findMST(Connection[] all_connections) {
		int[] key = new int[all_connections.length];
		Node[] parent = new Node[all_connections.length];
		Connection[] result = new Connection[all_connections.length];
		for (int i = 0; i < all_connections.length; i++) {
			key[i] = (int) Double.POSITIVE_INFINITY;
			parent[i] = null;
		}
		key[0] = 0;
		parent[0] = null;
		Node[] Q = nodes;
		Node current_node = nodes[0];
		while (Q.length > 0) {
			Node min_node = current_node.minConnection().getTarget();

		}

		for (Connection c : all_connections) {

		}
		return result;
	}

}
