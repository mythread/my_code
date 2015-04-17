<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>无标题文档</title>
<script type="text/javascript">
function newDoc()
  {
	  if(2>0){
  window.location.replace("index.html")
	  }
  //window.location.assign();
  }
</script>
</head>
<body>
<form id="form1" name="form1" method="post" action="">
<label>
    <input type="text" name="info" id="info" />
  </label>
  <br>
  <input type="button" value="Load new document" onclick="newDoc()" />
</form>
</body>
</html>