<%@ page language="java" pageEncoding="GBK"%>

<table width="20%">
	<tr>
		<td>
			<fieldset>
				<legend>
					用户登录
				</legend>
				<form action="login.do" method="post">

					<table width="20%">
						<tr>
							<td>
								用户名 :
							</td>
							<td>
								<input type="text" name="username" />
							</td>
						</tr>
						<tr>
							<td>
								密&nbsp;&nbsp;码 :
							</td>
							<td>
								<input type="password" name="password" />
							</td>
						</tr>
						<tr>
							<td>
								<input type="submit" value=" 登录 " />
							</td>
							<td align="right">
								<a href="register.jsp">注册</a>
								<a href="">忘记密码？</a>
							</td>
						</tr>
					</table>
				</form>
			</fieldset>
		</td>
	</tr>
</table>