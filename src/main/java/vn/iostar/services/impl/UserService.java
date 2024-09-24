package vn.iostar.services.impl;

import java.sql.Date;

import vn.iostar.dao.IUserDao;
import vn.iostar.dao.impl.UserDao;
import vn.iostar.models.Usermodel;
import vn.iostar.services.IUserService;

public class UserService implements IUserService {
	// lấy tất cả hàm trong tầng Dao
	IUserDao userDao = new UserDao();

	@Override
	public Usermodel login(String username, String password) {

		Usermodel user = this.findByUsername(username);

		if (user != null && password.equals(user.getPassword())) {
			return user;
		}
		return null;
	}

	@Override
	public Usermodel findByUsername(String username) {

		return userDao.findByUsername(username);
	}

	@Override
	public boolean register(String username, String password, String email, String fullname, String phone) {
		if (userDao.checkExistUsername(username)) {
			return false;
		}
		if(userDao.checkExistEmail(email)) {
			return false;
		}
		if(userDao.checkExistPhone(phone)) {
			return false;
		}
		Usermodel newUser = new Usermodel();
        newUser.setUsername(username);
        newUser.setPassword(password);
        newUser.setEmail(email);
        newUser.setFullname(fullname);
        newUser.setPhone(phone);
        long millis = System.currentTimeMillis();
        Date createdate = new Date(millis);
        newUser.setCreatedate(createdate);
        userDao.insert(newUser);
		return true;
	}

	public boolean checkExistEmail(String email) {
		return userDao.checkExistEmail(email);
	}

	public boolean checkExistUsername(String username) {
		return userDao.checkExistUsername(username);
	}

	@Override
	public boolean checkExistPhone(String phone) {
		return userDao.checkExistPhone(phone);
	}

	@Override
	public void insert(Usermodel user) {
		userDao.insert(user);
	}

	public static void main(String[] args) {

		IUserService userDao = new UserService();
		System.out.println(userDao.findByUsername("phucthh"));
		// List<UserModel> list = userDao.findAll();
		// for (UserModel user : list) {
		// System.out.println(user);
		// }
	}
}