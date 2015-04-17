//验证会员ID是否符合要求
 var tag=true;
 var tip=true;
 function validuserID(){
 var useridError=document.getElementById("useridError");
 var msg="会员ID不能为空！";
 var msg1="会员ID必须为八位数字或字母的组合！";
 if(isEmpty(document.getElementById("userid").value)){
 useridError.innerHTML=msg;
 return tag=false
 }
 else{
 if(!isLetterOrDigital(document.getElementById("userid").value)|!isLengthequality(document.getElementById("userid").value,8)){
 useridError.innerHTML=msg1;
 return tag=false
				
 }
 else {
	 return tag=true
	 }
 }
 }
 
 //验证会员ID是否改变正确
 function changeID(){
 var useridError=document.getElementById("useridError");
 var msg="";
 if(validuserID()){
 useridError.innerHTML=msg;
 }
 }


//验证会员名是否符合要求
 function validusername(){
 var usernameError=document.getElementById("usernameError");
 var font=/[\u4e00-\u9fa5]/;　
 var msg="会员名不能为空！";
 var msgl="会员名必须为字符！";
// var msgl="会员名必须为汉字！";
 //var username=document.getElementById("username").value;
 if(isEmpty(document.getElementById("username").value)){
 usernameError.innerHTML=msg;
 return tag=false
 }
 else{
 if(!isChar(document.getElementById("username").value)|(isLengthGreaterThan(document.getElementById("username").value,20)&isLengthLessThan(document.getElementById("username"),1))){
  usernameError.innerHTML=msg1;
  return tag=false
	 }
	 else {return tag=true}
 }
 }
  //验证会员名是否改正确变
  function changeName(){
 var usernameError=document.getElementById("usernameError");
 var msg="";
 if(validusername()){
 usernameError.innerHTML=msg;
 }
 }
 
 
 //验证会员密码是否符合要求
 function validuserpassword(){
 var userpwdError=document.getElementById("userpwdError");
 var font=/[\u4e00-\u9fa5]/;　
 var msg="会员密码不能为空！";
 var msg1="会员密码必须为六位数字或字母组合！";
 //var userpassword=document.getElementById("userpassword").value;
 if(isEmpty(document.getElementById("userpassword").value)){
 userpwdError.innerHTML=msg;
return tag=false
 }
 else{
 if(!isLetterOrDigital(document.getElementById("userpassword").value)|!isLengthequality(document.getElementById("userpassword").value,6)){
 userpwdError.innerHTML=msg1;
 return tag=false
 }
 else {return tag=true}
 }
 }
 
 //验证会员密码是否改变正确
 function changePWD(){
 var userpwdError=document.getElementById("userpwdError");
 var msg="";
 if(validuserpassword()){
 userpwdError.innerHTML=msg;
 }
 }
 
 //验证会员确认密码是否符合要求
 function validpassword(){
 var pwdError=document.getElementById("pwdError");
 //var userpwdError=document.getElementById("userpwdError");
 var font=/[\u4e00-\u9fa5]/;　
 var msg="确认密码不能为空！";
 var msgl="两次输入的密码不一致！";
 var msg2="密码必须为六位数字或字母组合！";
// var password=document.getElementById("password").value;
 if(isEmpty(document.getElementById("password").value)){
 pwdError.innerHTML=msg;
 return tag=false
 }
 else{
 if(document.getElementById("userpassword").value!=document.getElementById("password").value){
 pwdError.innerHTML=msgl;
 return tag=false
 }
 else{
	 if(!isLengthequality(document.getElementById("password").value,6)){ 
		 pwdError.innerHTML=msg2;
		 return tag=false
		 }
	 else {return tag=true}
	 }
 }
 }
  //验证会员确认密码是否改变正确
 function isChangePWD(){
 var pwdError=document.getElementById("pwdError");
 var msg="";
 if(validpassword()){
 pwdError.innerHTML=msg;
 }
 }
 
 //检查会员注册信息是否正确
function error_msg(){
	if(tag==false){
		var error_msg = document.getElementById("error_msg");
		error_msg.innerHTML = "会员注册信息错误！";
		return tag;
		}
		
	 
   }
//跳转到主页面index.html  
function gotoLinkIndex(){
	gotolink("index.html");
	}
//跳转到注册页面register.html	
function gotoLinkRegister(){
	gotolink("register.html");
	}
//跳转到系统错误页面system_error.html	
function gotoLinkError(){
    gotolink("system_error.html");
	}
//跳转到查询页面search.html	
function gotoLinkSearch(){
    gotolink("search.html");
	}
	
//判断是否系统错误	
function system_error(){
	isTrue();
if(tag==false){
	var error_msg = document.getElementById("error_msg");
	error_msg.innerHTML = "会员注册信息错误！";
	return false;
} 
else{  
 if(document.getElementById("username").value!="zhangxiongcai"|parseInt(document.getElementById("userpassword").value)!=123456){
	isTrue();
	var error_msg = document.getElementById("error_msg");
	error_msg.innerHTML = "会员名或密码错误！";
	alert("会员名或密码错误！")
	gotolink("system_error.html");
	return false;
	}
 else{
	return true;
	}
}
}

 //验证会员第二次填写是否正确
function isTrue(){
var error_msg = document.getElementById("error_msg");
var msg="";
 if(validuserID()&validusername()&validuserpassword()&validpassword()){
	error_msg.innerHTML = msg;
    tag=true;
 }
}
//验证输入的会员名和密码是否正确
function isNameandPWD(){
	if(parseInt(document.getElementById("username").value)!=123&parseInt(document.getElementById("userpassword").value)!=123456){
		alert("6");
		tip=false;
		}
		else{ 
		alert("7");
		tip=true;
		}	
	}

function isLoginTrue(){	
    var error_msg = document.getElementById("error_msg");
    var msg="";
    if(validuserID()&validuserpassword()){
	   alert("1")
	   error_msg.innerHTML = msg;
       tag=true;
    }
}

//判断是否系统登录错误	validuserID()&validusername()
function systemlogin_error(){
	var error_msg = document.getElementById("error_msg");
    var msg="";
    if(validuserID()&validuserpassword()){
	   error_msg.innerHTML = msg;
       tag=true;
    }
if(tag==false){
	var error_msg = document.getElementById("error_msg");
	error_msg.innerHTML = "会员登录信息错误！";
	return false;
} 
else{  
 if(document.getElementById("userid").value!="12345678"|document.getElementById("userpassword").value!="123456"){
	var error_msg = document.getElementById("error_msg");
	error_msg.innerHTML = "会员ID或密码错误！";
	alert("会员ID或密码错误！")
	gotolink("system_error.html");
	return false;
	}
 else{
	return true;
	}
}
}

//判断是否系统查询错误
function systemsearch_error(){
var error_msg = document.getElementById("error_msg");
    var msg="";
    if(validuserID()&validuserpassword()){
	   error_msg.innerHTML = msg;
       tag=true;
    }
if(tag==false){
	var error_msg = document.getElementById("error_msg");
	error_msg.innerHTML = "会员注册信息错误！";
	return false;
} 
else{  
 if(document.getElementById("username").value!="zhangxiongcai"|parseInt(document.getElementById("userpassword").value)!=123456){
	var error_msg = document.getElementById("error_msg");
	error_msg.innerHTML = "会员名或密码错误！";
	alert("会员名或密码错误！")
	gotolink("system_error.html");
	return false;
	}
 else{
	return true;
	}
}	
}

//显示查询的正确信息
function TOinfo(){
var myid="12345678";
var myname="张兄才";
var myemail="X.C_zhang@live.com";
var mystate="online";
var error_msg = document.getElementById("error_msg");
    var msg="";
    if(validuserID()&validusername()){
	   error_msg.innerHTML = msg;
       tag=true;
    }
if(tag==false){
	var error_msg = document.getElementById("error_msg");
	error_msg.innerHTML = "会员查询信息错误！";
	return false;
}
if(document.getElementById("userid").value!="12345678"|document.getElementById("username").value!="zhangxiongcai"){
var error_msg = document.getElementById("error_msg");
error_msg.innerHTML = "会员名或ID错误！";
alert("请输入正确的会员名和ID！")
return false;
gotolink("system_error.html");
}
else{
var NOinfo = document.getElementById("NO");
var NOinfo2 = document.getElementById("NO2");
var NOinfo3 = document.getElementById("NO3");
NOinfo.innerHTML="2";
NOinfo2.innerHTML="3";
NOinfo3.innerHTML="4";
var myidinfo = document.getElementById("myid");
myidinfo.innerHTML=myid;
var mynameinfo = document.getElementById("myname");
mynameinfo.innerHTML=myname;
var myemailinfo = document.getElementById("myemail");
myemailinfo.innerHTML=myemail;
var mystateinfo = document.getElementById("mystate");
mystateinfo.innerHTML=mystate;
return false;
}
}