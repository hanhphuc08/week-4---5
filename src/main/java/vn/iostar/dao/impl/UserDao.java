package vn.iostar.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import vn.iostar.configs.DBConnectSQL;
import vn.iostar.dao.IUserDao;
import vn.iostar.models.Usermodel;

public class UserDao implements IUserDao {

	public Connection conn = null;
	public PreparedStatement ps = null;
	public ResultSet rs = null;

	@Override
	public List<Usermodel> findAll() {
		String sql = "select * from users";
		List<Usermodel> list = new ArrayList<>(); // Tạo 1 List để truyền dữ liệu
		try {
			conn = new DBConnectSQL().getConnection(); // kết nối database
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();

			while (rs.next() /* Next từng DÒNG tới cuối bảng */) {
				list.add(new Usermodel(rs.getInt("id"), rs.getString("username"), rs.getString("password"),
						rs.getString("email"), rs.getString("phone"), rs.getString("images"), rs.getString("fullname"),
						rs.getInt("roleid"), rs.getDate("createDate"))); // Add vào
			}
			return list;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();

		}

		return null;
	}

	@Override
	public Usermodel findOne(int id) {
		String sql = "SELECT * FROM users WHERE id = ? ";

		try {
			conn = new DBConnectSQL().getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			while (rs.next()) {
				Usermodel user = new Usermodel();
				user.setId(rs.getInt("id"));
				user.setUsername(rs.getString("username"));
				user.setPassword(rs.getString("password"));
				user.setFullname(rs.getString("fullname"));
				user.setImages(rs.getString("images"));
				user.setEmail(rs.getString("email"));
				user.setRoleid(rs.getInt("roleid"));
				return user;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void insert(Usermodel user) {

		String sql = "INSERT INTO users (email, username, fullname, password, images, roleid,phone,createdate) VALUES (?,?,?,?,?,?,?,?)";
		try {
			conn = new DBConnectSQL().getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, user.getEmail());
			ps.setString(2, user.getUsername());
			ps.setString(3, user.getFullname());
			ps.setString(4, user.getPassword());
			ps.setString(5, user.getImages());
			ps.setInt(6, user.getRoleid());
			ps.setString(7, user.getPhone());
			ps.setDate(8, user.getCreatedate());
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		

	}

	@Override
	public Usermodel findByUsername(String username) {
		String sql = "SELECT * FROM users WHERE username = ? ";

		try {
			conn = new DBConnectSQL().getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, username);
			rs = ps.executeQuery();
			while (rs.next()) {
				Usermodel user = new Usermodel();
				user.setId(rs.getInt("id"));
				user.setUsername(rs.getString("username"));
				user.setPassword(rs.getString("password"));
				user.setFullname(rs.getString("fullname"));
				user.setImages(rs.getString("images"));
				user.setEmail(rs.getString("email"));
				user.setRoleid(rs.getInt("roleid"));
				return user;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean checkExistEmail(String email) {
		boolean duplicate = false;
		String query = "select * from users where email = ?";
		try {
			conn = new DBConnectSQL().getConnection();
			ps = conn.prepareStatement(query);
			ps.setString(1, email);
			rs = ps.executeQuery();
			if (rs.next()) {
				duplicate = true;
			}
			ps.close();
			conn.close();
		} catch (Exception ex) {
		}
		return duplicate;
	}

	@Override
	public boolean checkExistUsername(String username) {
		boolean duplicate = false;
		String query = "select * from users where username = ?";
		try {
			conn = new DBConnectSQL().getConnection();
			ps = conn.prepareStatement(query);
			ps.setString(1, username);
			rs = ps.executeQuery();
			if (rs.next()) {
				duplicate = true;
			}
			ps.close();
			conn.close();
		} catch (Exception ex) {
		}
		return duplicate;
	}

	@Override
	public boolean checkExistPhone(String phone) {
		boolean duplicate = false;
		String query = "select * from users where phone = ?";
		try {
			conn = new DBConnectSQL().getConnection();
			ps = conn.prepareStatement(query);
			ps.setString(1, phone);
			rs = ps.executeQuery();
			if (rs.next()) {
				duplicate = true;
			}
			ps.close();
			conn.close();
		} catch (Exception ex) {
		}
		return duplicate;
	}

	public static void main(String[] args) {

		IUserDao userDao = new UserDao();
		System.out.println(userDao.findByUsername("trungnh"));
		// List<UserModel> list = userDao.findAll();
		// for (UserModel user : list) {
		// System.out.println(user);
		// }
	}

}
