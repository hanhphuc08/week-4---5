package vn.iostar.dao;
import java.util.List;

import vn.iostar.models.Usermodel;


public interface IUserDao {
	
	List<Usermodel> findAll();
	
	Usermodel findOne(int id);
	
	Usermodel findByUsername(String username);
	
	void insert(Usermodel user);
	boolean checkExistEmail(String email);
	boolean checkExistUsername(String username);
	boolean checkExistPhone(String phone);

}
