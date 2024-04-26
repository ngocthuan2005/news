package TinTuc.Entity;

public class User extends BaseEntity{
	private String name;
	private String email;
	private String password;
	private int id_role;
	private String mobile;
	private String email_accuracy;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getId_role() {
		return id_role;
	}
	public void setId_role(int id_role) {
		this.id_role = id_role;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getEmail_accuracy() {
		return email_accuracy;
	}
	public void setEmail_accuracy(String email_accuracy) {
		this.email_accuracy = email_accuracy;
	}
}
