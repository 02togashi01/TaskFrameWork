package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entity.Userinfo;
import entity.Users;

public class UsersDao {
//ログイン用
	private static final String SQL_SELECT_ID_AND_PASS = "SELECT admin_id, admin_name, password FROM admin WHERE admin_id = ? AND password = ?";
//全検索
	private static final String SQL_SELECT_ALL = "SELECT user_id, user_name, telephone FROM user_info";
//１つで検索
	private static final String SQL_SELECT_ID = "SELECT user_id, user_name, telephone FROM user_info WHERE user_id = ?";
	private static final String SQL_SELECT_NAME = "SELECT user_id, user_name, telephone FROM user_info WHERE user_name = ?";
	private static final String SQL_SELECT_TEL = "SELECT user_id, user_name, telephone FROM user_info WHERE telephone = ?";
//２つで検索
	private static final String SQL_SELECT_NAME_AND_TEL = "SELECT user_id, user_name, telephone FROM user_info WHERE user_name=? AND telephone = ?";
	private static final String SQL_SELECT_ID_AND_TEL = "SELECT user_id, user_name, telephone FROM user_info WHERE user_id=? AND telephone = ?";
	private static final String SQL_SELECT_ID_AND_NAME = "SELECT user_id, user_name, telephone FROM user_info WHERE user_id=? AND user_name = ?";
//３つで検索
	private static final String SQL_SELECT_ID_AND_NAME_AND_TEL = "SELECT user_id, user_name, telephone FROM user_info WHERE user_id=? AND user_name = ? AND telephone = ?";
//DELETEする
	private static final String SQL_SELECT_DELETE = "DELETE FROM user_info WHERE user_id = ?";
//INSERTする
	private static final String SQL_INSERT = "INSERT INTO user_info (user_name,telephone, password) VALUES (?, ?, ?)";
//UPDATEするものを探す
	private static final String SQL_SELECT_ID_UPDATE = "SELECT user_id, user_name, telephone,password FROM user_info WHERE user_id = ?";
//UPDATEする
	private static final String SQL_UPDATE = "UPDATE user_info SET user_name = ?, telephone = ?,password = ? WHERE user_id = ?" ;



	private Connection connection;

	public UsersDao(Connection connection) {
		this.connection = connection;
	}

	public Users findByIdAndPass(String id, String pass) {
		try (PreparedStatement stmt = connection.prepareStatement(SQL_SELECT_ID_AND_PASS)) {
			stmt.setString(1, id);
			stmt.setString(2, pass);

			ResultSet rs = stmt.executeQuery();

			if (rs.next()) {
				return new Users(rs.getString("admin_id"), rs.getString("admin_name"), rs.getString("password"));
			} else {
				return null;
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public List<Userinfo> findBySELECTID(Integer iId) {
		List<Userinfo> list = new ArrayList<Userinfo>();
		try (PreparedStatement stmt = connection.prepareStatement(SQL_SELECT_ID )) {
			stmt.setLong(1, iId);
			//stmt.setString(2, name);
			//stmt.setString(3, tel);


			ResultSet rs = stmt.executeQuery();

			if (rs.next()) {
				Userinfo u = new Userinfo(rs.getInt("user_id"), rs.getString("user_name"),rs.getString("telephone"));
				list.add(u);
			} else {
				return null;
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return list;
	}

	public List<Userinfo> findBySELECTname(String name) {
		List<Userinfo> list = new ArrayList<Userinfo>();
		try (PreparedStatement stmt = connection.prepareStatement(SQL_SELECT_NAME )) {
			stmt.setString(1, name);
			//stmt.setString(2, name);
			//stmt.setString(3, tel);


			ResultSet rs = stmt.executeQuery();

			if (rs.next()) {
				Userinfo u = new Userinfo(rs.getInt("user_id"), rs.getString("user_name"),rs.getString("telephone"));
				list.add(u);
			} else {
				return null;
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return list;
	}

	public List<Userinfo> findBySELECTtel(String tel) {
		List<Userinfo> list = new ArrayList<Userinfo>();
		try (PreparedStatement stmt = connection.prepareStatement(SQL_SELECT_TEL )) {
			stmt.setString(1, tel);
			//stmt.setString(2, name);
			//stmt.setString(3, tel);


			ResultSet rs = stmt.executeQuery();

			if (rs.next()) {
				Userinfo u = new Userinfo(rs.getInt("user_id"), rs.getString("user_name"),rs.getString("telephone"));
				list.add(u);
			} else {
				return null;
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return list;
	}

	public List<Userinfo> findBySELECTnameANDtel(String name,String tel) {
		List<Userinfo> list = new ArrayList<Userinfo>();
		try (PreparedStatement stmt = connection.prepareStatement(SQL_SELECT_NAME_AND_TEL )) {
			stmt.setString(1, name);
			stmt.setString(2, tel);
			//stmt.setString(3, tel);


			ResultSet rs = stmt.executeQuery();

			if (rs.next()) {
				Userinfo u = new Userinfo(rs.getInt("user_id"), rs.getString("user_name"),rs.getString("telephone"));
				list.add(u);
			} else {
				return null;
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return list;
	}

	public List<Userinfo> findBySELECTidANDtel(Integer iId,String tel) {
		List<Userinfo> list = new ArrayList<Userinfo>();
		try (PreparedStatement stmt = connection.prepareStatement(SQL_SELECT_ID_AND_TEL )) {
			stmt.setInt(1, iId);
			stmt.setString(2, tel);
			//stmt.setString(3, tel);


			ResultSet rs = stmt.executeQuery();

			if (rs.next()) {
				Userinfo u = new Userinfo(rs.getInt("user_id"), rs.getString("user_name"),rs.getString("telephone"));
				list.add(u);
			} else {
				return null;
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return list;
	}

	public List<Userinfo> findBySELECTidANDname(Integer iId,String name) {
		List<Userinfo> list = new ArrayList<Userinfo>();
		try (PreparedStatement stmt = connection.prepareStatement(SQL_SELECT_ID_AND_NAME )) {
			stmt.setInt(1, iId);
			stmt.setString(2, name);
			//stmt.setString(3, tel);


			ResultSet rs = stmt.executeQuery();

			if (rs.next()) {
				Userinfo u = new Userinfo(rs.getInt("user_id"), rs.getString("user_name"),rs.getString("telephone"));
				list.add(u);
			} else {
				return null;
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return list;
	}

	public List<Userinfo> findBySELECTidANDnameANDtel(Integer iId,String name,String tel) {
		List<Userinfo> list = new ArrayList<Userinfo>();
		try (PreparedStatement stmt = connection.prepareStatement(SQL_SELECT_ID_AND_NAME_AND_TEL )) {
			stmt.setInt(1, iId);
			stmt.setString(2, name);
			stmt.setString(3, tel);


			ResultSet rs = stmt.executeQuery();

			if (rs.next()) {
				Userinfo u = new Userinfo(rs.getInt("user_id"), rs.getString("user_name"),rs.getString("telephone"));
				list.add(u);
			} else {
				return null;
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return list;
	}

	public List<Userinfo> findBySELECTID_DELETE(Integer iId) {
		List<Userinfo> list = new ArrayList<Userinfo>();
		try (PreparedStatement stmt = connection.prepareStatement(SQL_SELECT_DELETE)) {
			stmt.setLong(1, iId);
			//stmt.setString(2, name);
			//stmt.setString(3, tel);


			ResultSet rs = stmt.executeQuery();

			if (rs.next()) {

				Userinfo u = new Userinfo(rs.getInt("user_id"), rs.getString("user_name"),rs.getString("telephone"));
				list.add(u);
			} else {
				return null;
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return list;
	}

	public List<Userinfo> findBySELECTID_UPDATE_LAST(Integer iId,Userinfo updateinf) {
		List<Userinfo> list = new ArrayList<Userinfo>();
		try (PreparedStatement stmt = connection.prepareStatement(SQL_UPDATE)) {
			stmt.setString(1, updateinf.getUsersName());
			stmt.setString(2, updateinf.getTelephone());
			stmt.setString(3, updateinf.getPassword());
			stmt.setLong(4, iId);



			ResultSet rs = stmt.executeQuery();

			if (rs.next()) {

				Userinfo u = new Userinfo(rs.getInt("user_id"), rs.getString("user_name"),rs.getString("telephone"));
				list.add(u);
			} else {
				return null;
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return list;
	}
	public List<Userinfo> findBySELECTID_UPDATE(Integer iId) {
		List<Userinfo> list = new ArrayList<Userinfo>();
		try (PreparedStatement stmt = connection.prepareStatement(SQL_SELECT_ID_UPDATE )) {
			stmt.setLong(1, iId);
			//stmt.setString(2, name);
			//stmt.setString(3, tel);


			ResultSet rs = stmt.executeQuery();

			if (rs.next()) {
				Userinfo u = new Userinfo(rs.getInt("user_id"), rs.getString("user_name"),rs.getString("telephone"),rs.getString("password"));
				list.add(u);
			} else {
				return null;
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return list;
	}

	public List<Userinfo> findAll() {
		List<Userinfo> list = new ArrayList<Userinfo>();

		try (PreparedStatement stmt = connection.prepareStatement(SQL_SELECT_ALL)) {
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				Userinfo u = new Userinfo(rs.getInt("user_id"), rs.getString("user_name"),rs.getString("telephone"));
				list.add(u);
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

		return list;
	}

	public int insert(Userinfo usersinfo) {
		try (PreparedStatement stmt = connection.prepareStatement(SQL_INSERT)) {
			stmt.setString(1, usersinfo.getUsersName());
			stmt.setString(2, usersinfo.getTelephone());
			stmt.setString(3, usersinfo.getPassword());

			return stmt.executeUpdate();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
