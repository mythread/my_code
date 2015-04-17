<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>无标题文档</title>
<script type="text/javascript">
function test(){
	//var temp=document.getElementById("info");
	if(document.getElementById("info").value.length>0){
       window.location.replace("index.html")
	   return false;
	}
	else {
	return true;
	}
}
//onsubmit="return test()"
</script>
</head>

<body>
<form id="form1" name="form1" method="post" action="search.jsp" onsubmit="return test()" >
  <label>
    <input type="text" name="info" id="info" />
  </label>
  <br>
  <label>
    <input type="submit" name="enter" id="enter" value="提交" />
  </label>
</form>
</body>
</html>
