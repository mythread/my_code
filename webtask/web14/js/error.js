function validateUserid() {
	var userid = document.getElementById("userid").value;
	if (isEmpty(userid)) {
		document.getElementById("userid_error").innerHTML = '<font color="red">�û�������</font>';
		return false;
	}
	return true;
}