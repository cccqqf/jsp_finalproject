package bean;

public class Message {
	private String username;
	private String name;
	private String say;
	public Message(String username,String name,String say) {
		
		this.name=name;
		this.say=say;
		this.username=username;
	}
	public Message() {
		super();
	}
	public Message(String username,String say) {
		this.username=username;
		this.say=say;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String id) {
		this.username = id;
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
