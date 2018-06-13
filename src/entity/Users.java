package entity;

public class Users {
	private String usersId;
	private String usersName;
	private String password;

	public Users() {
	}

	public Users(String usersId, String usersName, String password) {
		this.usersId = usersId;
		this.usersName = usersName;
		this.password = password;
	}

	public String getUsersId() {
		return usersId;
	}

	public void setUsersId(String usersId) {
		this.usersId = usersId;
	}

	public String getUsersName() {
		return usersName;
	}

	public void setUsersName(String usersName) {
		this.usersName = usersName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}


}
