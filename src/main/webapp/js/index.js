function judge(){
    var name=document.getElementById("username").value;
    var pwd=document.getElementById("password").value;
    if(name==""){
        alert("用户名不能为空！");
        return false;
    }else if(pwd==""){
        alert("密码不能为空！");
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
            if(request.status == 200) {
                str = request.responseText;
                if(name==""){
                    td.innerHTML="用户名不能为空";
                    td.style.color="red";
                }else if(str=="false"){
                    td.innerHTML="用户名不存在";
                    td.style.color="red";
                }else{
                    td.innerHTML="　";
                }
                }else if(request.status == 404) {
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
    }else{
        td.innerHTML="　";
    }
}