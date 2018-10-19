package cs3343_core;

public class Network implements Service {
	private int code = 0;
	private String service_name = "";
	private int speed = 1000;

	public Network(String service_name) {
		this.service_name = service_name;
	}
	
	public Network(String service_name, int code) {
		this.service_name = service_name;
		this.code = code;
	}

	public String getService_name() {
		return service_name;
	}

	public void setService_name(String service_name) {
		this.service_name = service_name;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getRank() {
		if (speed < 56) {
			return "DSL";
		} else if (speed < 100) {
			return "Copper";
		} else if (speed < 300) {
			return "Wi-Fi";
		} else if (speed < 1000) {
			return "Fibre";
		} else {
			return "Enterprise";
		}
	}

	public String toString() {
		if (code > 0) {
			return "" + code + " - " + service_name;
		} else {
			return service_name;
		}
	}

	public String toJSON() {
		return "{\"code\":" + code + ",\"service_name\":\"" + service_name + "\"}";
	}
}
