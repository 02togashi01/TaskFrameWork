package entity;

public class Userinfo {
	private Integer usersId;
	private String usersName;
	private String telephone;
	private String password;

	public Userinfo() {
	}

	public Userinfo(Integer usersId, String usersName, String telephone) {
		this.usersId = usersId;
		this.usersName = usersName;
		this.telephone = telephone;
	}

	public Userinfo(String usersName, String telephone,String password) {
		this.usersName = usersName;
		this.telephone = telephone;
		this.password = password;
	}
	public Userinfo(Integer usersId, String usersName, String telephone,String password) {
		this.usersId = usersId;
		this.usersName = usersName;
		this.telephone = telephone;
		this.password = password;
	}

	public Integer getUsersId() {
		return usersId;
	}

	public void setUsersId(Integer usersId) {
		this.usersId = usersId;
	}

	public String getUsersName() {
		return usersName;
	}

	public void setUsersName(String usersName) {
		this.usersName = usersName;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}


}
