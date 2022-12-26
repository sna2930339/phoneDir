
    matchpsw = function (oldpsw) {
        var value1 = document.getElementById("oldpsw").value;
        if (oldpsw === value1){
            document.getElementById("oldspan").innerHTML  = "<font color='green'>√</font>";
        }else {
            document.getElementById("oldspan").innerHTML  = "<font color='red'>原密码不匹配</font>";
        }
    }

