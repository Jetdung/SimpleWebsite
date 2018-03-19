function judge(){
    var name=document.getElementById("username").value;
    var pwd=document.getElementById("password").value;
	var con=document.getElementById("confirm").value;
    if(name==""){
        alert("用户名不能为空！");
        return false;
    }else if(pwd==""){
        alert("密码不能为空！");
        return false;
    }else if(pwd!=con){
        alert("两次密码不相同！");
        return false;
    }else if(pwd.length<=6){
        alert("密码过于简单！");
        return false;
    }else if(pwd!=con){
        alert("两次密码不相同！");
        return false;
    }else{
        return true;
    }
}
function displayuser(){
    var name=document.getElementById("username").value;
    var td=document.getElementById("u");
    var request = new XMLHttpRequest() || new ActiveXObject("Msxm12.XMLHTTP");
    var str;
    request.open("post", "judge?name="+name, true);
    request.onreadystatechange = function() {
        if(request.readyState == 4) {
            if (request.status == 200) {
                str = request.responseText;
                if (name == "") {
                    td.innerHTML = "用户名不能为空";
                    td.style.color = "red";
                } else if (str == "false") {
                    td.innerHTML = "用户名可以使用";
                    td.style.color = "green";
                } else if (str == "true") {
                    td.innerHTML = "用户名已存在";
                    td.style.color = "red";
                } else {
                    td.innerHTML = "　";
                }
            } else if (request.status == 404) {
            }
        }
    }
    request.setRequestHeader("content-type", "application/x-www-form-urlencoded");
    request.send("name=");
}
function displaypwd(){
    var pwd=document.getElementById("password").value;
    var td=document.getElementById("p");
    if(pwd==""){
        td.innerHTML="密码不能为空";
        td.style.color="red";
    }if(pwd.length<=6){
        td.innerHTML="密码过于简单";
        td.style.color="red";
    }else{
        td.innerHTML="　";
    }
}
function displayconfirm(){
    var pwd1=document.getElementById("password").value;
    var pwd2=document.getElementById("confirm").value;
    var td=document.getElementById("c");
    if(pwd1!=pwd2) {
        td.innerHTML="两次密码不相同";
        td.style.color="red";
    }else{
            td.innerHTML="　";
    }
}