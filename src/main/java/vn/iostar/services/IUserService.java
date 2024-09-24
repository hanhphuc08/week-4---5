package vn.iostar.services;

import vn.iostar.models.Usermodel;

public interface IUserService {
	void insert(Usermodel user);

	boolean register(String email, String password, String username, String fullname, String phone);

	boolean checkExistEmail(String email);

	boolean checkExistUsername(String username);

	boolean checkExistPhone(String phone);

	Usermodel login(String username, String password);

	Usermodel findByUsername(String username);
}
