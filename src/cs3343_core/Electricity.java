package cs3343_core;

public class Electricity implements Service{
	private int code = 0;
	private String service_name = "";
	private int voltage = 220;

	public Electricity(String service_name) {
		this.service_name = service_name;
	}
	
	public Electricity(String service_name, int code) {
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

	public int getVoltage() {
		return voltage;
	}

	public void setVoltage(int voltage) {
		this.voltage = voltage;
	}
}
