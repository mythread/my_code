//非空验证，成功返回true,失败返回false
function isEmpty(content){
	if(0 == trim(content).length){
		return true;
	}
	return false;
}
//跳转到指定页面
function gotolink(link) {
	window.location.replace(link);
}
//年月日验证
function isDate(content) {
	for(var i = 0; i < 4; i++) {
		if(isEmpty(content.charAt(i)) || !isDigital(content.charAt(i))) {
			return false;
		}
	}
	for(var i = 5; i < 7; i++) {
		if(isEmpty(content.charAt(i)) || !isDigital(content.charAt(i))) {
			return false;
		}
	}
	for(var i = 8; i < 10; i++) {
		if(isEmpty(content.charAt(i)) || !isDigital(content.charAt(i))) {
			return false;
		}
	}
	if(isEmpty(content.charAt(4)) || content.charAt(4) != '-') {
		return false;
	}
	if(isEmpty(content.charAt(7)) || content.charAt(7) != '-') {
		return false;
	}
	return true;
}

//位数超过验证，长度合理返回true，超过返回false
function isLengthGreaterThan(content,length){
	if(content.length > length){
		return true;
	}
	return false;
}
//位数不足验证,长度合理返回true，未超过返回false
function isLengthLessThan(content,length){
	if(content.length < length){
		return true;
	}
	return false;
}

//验证是否数字
function isDigital(content){
	for(var i = 0; i < content.length; i++){
		var ch = content.charAt(i);
		if((ch < '0')||(ch > '9')){
			return false;
		}
	}
	return true;
}

//验证是否数字或字母
function isLetterOrDigital(content){
	for(var i = 0; i < content.length; i++){
		var ch = content.charAt(i);
		if((ch < '0')||((ch > '9') && (ch < 'A'))||((ch > 'Z')&&(ch < 'a'))||(ch > 'z') ){
			return false;
		}
	}
	return true;
}
	
//半角验证,成功返回true,失败返回false
function isHalfAngle(content){
	var length = content.length;
	for(var i = 0;i < length;i++){
		if(content.charCodeAt(i) < 0xFF61 || content.charCodeAt(i) > 0xFF9F){
			return false;
		}
	}
	return true;
}
//全角验证,成功返回true,失败返回false
function isFullAngle(content){
	var length = content.length;
	for(var i = 0;i < length;i++){
		if(content.charCodeAt(i) >= 0xFF61 && content.charCodeAt(i) <= 0xFF9F
			|| content.charCodeAt(i) >= 0x0000 && content.charCodeAt(i) <= 0x00FF
			|| content.charCodeAt(i) >= 0xFFE8 && content.charCodeAt(i) <= 0xFFEE){
			return false;
		}
	}
	return true;
}
//给字符串添加一行信息
function addALine(msg, newLine) {
	if (msg.length != 0) {
		msg += "<br />";
	}
	msg += newLine;
	return msg;
}
//字符串trim，删除字符串头尾部的空格
function trim(content){
    return content.replace(/(^\s*)|(\s*$)/g, "");
}