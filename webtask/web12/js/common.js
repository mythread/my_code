//非空验证，成功返回true,失败返回false
function isEmpty(content){	
	if(0 == content.length){		
		return true;					
	}						
	return false;						
}	

//验证是否为空
function isNull(s){
for(i=0;i<=s.length;i++){
if(s.charAt(i)!=""){
return false;
}
}
return true;
}
//判断两个字符串是否相等
function isEquals(Str1,Str2){
for(i=0;i<=Str.length;i++){
if(Str1.charAt(i)!=Str2.charAt(i)){
return false;
}
}
return true;
}

//跳转到指定页面
function gotolink(link) {
	window.location.replace(link);
}
//位数长度指定验证,长度合理返回true,与指定位数不相等返回false
function isLengthequality(content,length){							
	if(content.length == length){						
		return true;					
	}						
	return false;						
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

//验证是否字符
function isChar(content){
	for(var i=0;i< content.length;i++){
		var ch=content.charAt(i);
		if(isLetterOrDigital(ch)||ch=='_'){
			return true;
			}
		}
		return false;
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
