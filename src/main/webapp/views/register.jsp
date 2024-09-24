<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="/ltwct4/register" method="post">
		<h2>Tạo tài khoản mới</h2>
		<c:if test="${alert !=null}">
			<h3 class="alert alert danger">${alert}</h3>
		</c:if>
		<section>
			<label class="input register-input">
				<div class="input-group">
					<span class="input-group-addon"><i class="fa fa-user"></i></span> <input
						type="text" placeholder="Tài khoản" name="username"
						class="form-control">
				</div>
			</label>
		</section>
		<section>
			<label class="input register-input">
				<div class="input-group">
					<span class="input-group-addon"><i class="fa fa-user"></i></span> <input
						type="text" placeholder="Họ tên" name="fullname"
						class="form-control">
				</div>
			</label>
		</section>
		<section>
			<label class="input register-input">
				<div class="input-group">
					<span class="input-group-addon"><i class="fa fa-user"></i></span> <input
						type="text" placeholder="Email" name="email"
						class="form-control">
				</div>
			</label>
		</section>
		<section>
			<label class="input register-input">
				<div class="input-group">
					<span class="input-group-addon"><i class="fa fa-user"></i></span> <input
						type="text" placeholder="Số điện thoại" name="phone"
						class="form-control">
				</div>
			</label>
		</section>
		<section>
			<label class="input register-input">
				<div class="input-group">
					<span class="input-group-addon"><i class="fa fa-user"></i></span> <input
						type="text" placeholder="Mật khẩu" name="password"
						class="form-control">
				</div>
			</label>
		</section>
		<section>
			<label class="input register-input">
				<div class="input-group">
					<span class="input-group-addon"><i class="fa fa-user"></i></span> <input
						type="text" placeholder=" Nhập lại mật khẩu" name="password"
						class="form-control">
				</div>
			</label>
		</section>
	
		<section>
			<label class="input register-input">
				<div class="input-group">
					<span class="input-group-addon"><i class="fa fa-user"></i></span> <input
						type="submit" value="Đăng ký" class="form-control">
				</div>
			</label>
		</section>
	</form>
</body>
</html>