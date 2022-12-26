
    doCheck = function() {
    var username = document.getElementById("username").value;
    var uPattern = /^[a-zA-Z0-9]{6,12}$/;
    var xhr = new XMLHttpRequest();
    xhr.onreadystatechange = function () {
        if (this.readyState === 4) {
            if (this.status === 200) {
                var responseText = this.responseText;
                if (uPattern.test(username)){
                    if (responseText === "1"){
                        document.getElementById("namespan").innerHTML =  "<font color='red'>此用户名已被注册</font>";
                    }else {
                        document.getElementById("namespan").innerHTML =  "<font color='green'>√</font>";
                    }
                }else {
                    document.getElementById("namespan").innerHTML =  "<font color='red'>用户名不符合规范</font>";
                }
            }
        }
    }
    xhr.open("post","/snpyy/select?username="+ username,true);
    xhr.send();
}

removeText  = function (id) {
        document.getElementById(id).innerHTML =  "       ";
}

doReg =function (id,spanid) {
    var reg = /^[\w]{6,12}$/;
    var password = document.getElementById(id).value;
    if (reg.test(password) && password != "") {
        document.getElementById(spanid).innerHTML =  "<font color='green'>√</font>";
    }else {
        document.getElementById(spanid).innerHTML =  "<font color='red'>6-12位，只能包含数字、字母和下划线</font>";
    }
    doConfig();
}

doConfig =function (pswid,confid,spanid) {
    var password = document.getElementById(pswid).value;
    var confpsw = document.getElementById(confid).value;
    if (password ===  confpsw &&  password !=  "" && confpsw  != ""){
        document.getElementById(spanid).innerHTML =  "<font color='green'>√</font>";
    }else {
        document.getElementById(spanid).innerHTML =  "<font color='red'>两次密码不相同</font>";
    }
}

smt = function (id1,id2,id3) {
    var value1 = document.getElementById(id1).innerText;
    var value2 = document.getElementById(id2).innerText;
    var value3 = document.getElementById(id3).innerText;
    if (value1  === value2 &&  value1  === value3){
        return true;
    }
    return false;
}