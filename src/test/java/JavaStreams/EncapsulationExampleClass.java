package JavaStreams;

public class EncapsulationExampleClass {
	
	private int id;
	private String name;
	private boolean flag;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public boolean isFlag() {
		return flag;
	}
	public void setFlag(boolean flag) {
		this.flag = flag;
	}
	public EncapsulationExampleClass(int id, String name, boolean flag) {
		this.id = id;
		this.name = name;
		this.flag = flag;
	}
	
	
}
