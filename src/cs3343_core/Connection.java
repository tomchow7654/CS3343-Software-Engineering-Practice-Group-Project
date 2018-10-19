package cs3343_core;

import java.util.Random;

public class Connection {
	private Node source = null;
	private Node target = null;
	private Service type = null;
	private double weight = 0.0;
	private double distance = 0.0;
	private double health = 1.0;
	private boolean enabled = true;

	public Connection(Node source, Node target, Service type) {
		this.source = source;
		this.target = target;
		this.type = type;
		source.comitConnect(this);
		Random rand = new Random();
		this.weight = rand.nextInt(50) + rand.nextDouble();
		this.distance = rand.nextInt(50) + rand.nextDouble();
	}

	public Connection(Node source, Node target, Service type, double weight, double distance) {
		this.source = source;
		this.target = target;
		this.type = type;
		source.comitConnect(this);
		this.weight = weight;
		this.distance = distance;
	}

	public Node getSource() {
		return source;
	}

	public Node getTarget() {
		return target;
	}

	public Service getService() {
		return type;
	}

	public double getWeight() {
		return weight;
	}
	
	public double getWeightedDistance() {
		return weight * distance;
	}

	public void maintainance() {
		this.health = 1;
	}

	public void use() {
		if (enabled) {
			this.health *= 1 - 0.0005;
		}
	}

	public boolean requiresMaintainance() {
		return health < 0.2;
	}

	public void on() {
		this.enabled = true;
	}

	public void off() {
		this.enabled = false;
	}
	
	public boolean equals(Connection c) {
		return this.source == c.source;
	}
	
	public String toString() {
		return String.format("%2d -> %2d %s", source.getId(), target.getId(), this.type.getService_name());
	}

}
