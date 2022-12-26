
    function dispatch(id,mz) {
        if(window.confirm('亲，确定要删除吗？'))
        window.location = mz +'/delete?id='+id;
    }

    function searchAssociation(){
        var searchText = document.getElementById("search");
        var condition = document.getElementById("condition");
        var conditionStr = condition.value;
        var xhr = new XMLHttpRequest();
        xhr.onreadystatechange = function () {
        if (4 === this.readyState) {
            if (200 === this.status){
                var html = "";
                var jsonStr = JSON.parse(xhr.responseText);
                for (let i = 0; i < jsonStr.length; i++) {
                    if ("number" === conditionStr){
                        html += "<p onclick='setInput(\""+jsonStr[i].number+"\")'>" + jsonStr[i].number + "</p>";
                    }else if ("homeLoc" === conditionStr){
                        html += "<p onclick='setInput(\""+jsonStr[i].homeLoc + "\")'>" + jsonStr[i].homeLoc+ "</p>";
                    }
                }
                document.getElementById("mydiv").innerHTML = html;
                if (searchText.value !== ""){
                    document.getElementById("mydiv").style.display = "block";
                }
                else {
                    document.getElementById("mydiv").style.display = "none";
                }
            }
        }
    }
    xhr.open("post","/snpyy/searchAssociation?condition="+condition.value+"&value=" + searchText.value,true)
    xhr.send();
    }

    function setInput(value) {
        document.getElementById("search").value = value;
        document.getElementById("mydiv").style.display = "none";
    }

    function doSearch() {
        var searchText = document.getElementById("search");
        var condition = document.getElementById("condition");

        var xhr = new XMLHttpRequest();
        xhr.onreadystatechange = function () {
            if (4 === this.readyState) {
                if (200 === this.status){
                    var html = "";
                    var jsonStr = JSON.parse(xhr.responseText);
                    for (let i = 0; i < jsonStr.length; i++) {
                        html +="<tr>";
                        html +="  <td>" + (i + 1)+ "</td>";
                        html +="  <td>" + jsonStr[i].master+ "</td>";
                        html +=     "<td>"+ jsonStr[i].contact +"</td>";
                        html +=     "<td>"+ jsonStr[i].number + "</td>";
                        html +=     "<td>"+ jsonStr[i].homeLoc +"</td>";
                        html +=     "<th>";
                        html +=         "<a href=\"javascript:void(0)\" onclick=\"dispatch('"+jsonStr[i].id + "','${pageContext.request.contextPath}')\">删除</a>&nbsp"
                        html +=         "<a href=\"${pageContext.request.contextPath}/dispatchmodify?id="+jsonStr[i].id+" \">修改</a> &nbsp";
                        html +=         "<a href=\"${pageContext.request.contextPath}/detail?id=" + jsonStr[i].id + "\">详细</a>";
                        html +=     "</th>";
                        html += "</tr>";
                        document.getElementById("tbody").innerHTML = html;
                    }
                }
            }
        }
    xhr.open("post","/snpyy/dosearch?condition="+condition.value+"&value=" + searchText.value,true)
    xhr.send();
}

