package service;

import java.sql.Connection;
import java.util.Collections;
import java.util.List;

import dao.UsersDao;
import entity.Userinfo;
import entity.Users;
import utill.Dbutill;

public class UsersService {

	public Users authentication(String id, String pass) {
		try (Connection conn = Dbutill.getConnection()) {
			UsersDao userDao = new UsersDao(conn);
			Users user = userDao.findByIdAndPass(id, pass);

			return user;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}
	public List<Userinfo> authenticationID(Integer iId) {
		try (Connection conn = Dbutill.getConnection()) {
			UsersDao userDao = new UsersDao(conn);
			 return userDao.findBySELECTID(iId);

			//return userinfo;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	public List<Userinfo> authenticationname(String name) {
		try (Connection conn = Dbutill.getConnection()) {
			UsersDao userDao = new UsersDao(conn);
			 return userDao.findBySELECTname(name);

			//return userinfo;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	public List<Userinfo> authenticationtel(String tel) {
		try (Connection conn = Dbutill.getConnection()) {
			UsersDao userDao = new UsersDao(conn);
			 return userDao.findBySELECTtel(tel);

			//return userinfo;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	public List<Userinfo> authenticationnameANDtel(String name,String tel) {
		try (Connection conn = Dbutill.getConnection()) {
			UsersDao userDao = new UsersDao(conn);
			 return userDao.findBySELECTnameANDtel(name,tel);

			//return userinfo;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	public List<Userinfo> authenticationidANDtel(Integer iId,String tel) {
		try (Connection conn = Dbutill.getConnection()) {
			UsersDao userDao = new UsersDao(conn);
			 return userDao.findBySELECTidANDtel(iId,tel);

			//return userinfo;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	public List<Userinfo> authenticationidANDname(Integer iId,String name) {
		try (Connection conn = Dbutill.getConnection()) {
			UsersDao userDao = new UsersDao(conn);
			 return userDao.findBySELECTidANDname(iId,name);

			//return userinfo;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	public List<Userinfo> authenticationidANDnameANDtel(Integer iId,String name,String tel) {
		try (Connection conn = Dbutill.getConnection()) {
			UsersDao userDao = new UsersDao(conn);
			 return userDao.findBySELECTidANDnameANDtel(iId,name,tel);

			//return userinfo;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	public List<Userinfo> authenticationID_DELETE(Integer iId) {
		try (Connection conn = Dbutill.getConnection()) {
			UsersDao userDao = new UsersDao(conn);
			 return userDao.findBySELECTID_DELETE(iId);

			//return userinfo;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}
	public List<Userinfo> authenticationID_UPDATE(Integer iId) {
		try (Connection conn = Dbutill.getConnection()) {
			UsersDao userDao = new UsersDao(conn);
			 return userDao.findBySELECTID_UPDATE(iId);

			//return userinfo;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	public List<Userinfo> authenticationID_UPDATE_LAST(Integer iId,Userinfo updateinfo) {
		try (Connection conn = Dbutill.getConnection()) {
			UsersDao userDao = new UsersDao(conn);
			 return userDao.findBySELECTID_UPDATE_LAST(iId,updateinfo);

			//return userinfo;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	public List<Userinfo> find() {
		try (Connection conn = Dbutill.getConnection()) {
			UsersDao userDao = new UsersDao(conn);
			return userDao.findAll();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return Collections.emptyList();
	}

	public int register(Userinfo usersinfo) {
		try (Connection conn = Dbutill.getConnection()) {
			UsersDao userDao = new UsersDao(conn);
			return userDao.insert(usersinfo);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return 0;
	}

}
