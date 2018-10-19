package cs3343_core;

public class Node {
	private double latitude = 0.0;
	private double longtitute = 0.0;
	private String node_name = "";
	private int id = 0;
	private int counter = 0;
	private int limit = 0;
	private Connection[] connections = new Connection[CentralManager.getInstance().config_connections];

	public Node(String node_name, double latitude, double longtitute) {
		this.node_name = node_name;
		this.latitude = latitude;
		this.longtitute = longtitute;
	}

	public double getLatitude() {
		return latitude;
	}

	public double getLongtitute() {
		return longtitute;
	}

	public String getNode_name() {
		return node_name;
	}

	public int call() {
		return ++counter;
	}

	public int getLimit() {
		return limit;
	}

	public int getQuota() {
		return limit - counter;
	}

	public boolean isLimitReached() {
		return limit <= counter;
	}

	public void comitConnect(Connection c) {
		this.connections[this.getConnectionCount()] = c;
	}

	public String toString() {
		return this.node_name + " (" + this.latitude + "," + this.longtitute + ")";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Connection minConnection() {
		Connection result = null;
		double reference = Double.POSITIVE_INFINITY;
		for (Connection c : this.connections) {
			if (c.getWeight() < reference) {
				result = c;
				reference = c.getWeight();
			}
		}
		return result;
	}

	public int getConnectionCount() {
		int count = 0;
		for (Connection c : this.connections) {
			if (c != null) {
				count++;
			}
		}
		return count;
	}

	public String getConnections() {
		String result = "";
		boolean first = true;
		for (Connection c : this.connections) {
			if (c != null) {
				result += (first?"":", ") + c.getTarget().getId();
				first = false;
			}
		}
		return result;
	}

}
