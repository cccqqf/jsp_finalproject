package bean;

public class Message {
	private String id;
	private String name;
	private String say;
	public Message(String id,String name,String say) {
		
		this.name=name;
		this.say=say;
		this.id=id;
	}
	public Message() {
		super();
	}
	public Message(String name,String say) {
		this.name=name;
		this.say=say;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSay() {
		return say;
	}
	public void setSay(String say) {
		this.say = say;
	}
}
