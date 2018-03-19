function sub(){
    var num=document.getElementById("n");
    var n=num.innerHTML;
    if(n>1){
        n--;
    }
    num.innerHTML=n;
    GetRadioValue();
}
function plus(){
    var num=document.getElementById("n");
    var n=num.innerHTML;
    n++;
    num.innerHTML=n;
    GetRadioValue();
}
function GetRadioValue(){
    var obj=document.getElementsByName("radios");
    var price=document.getElementById("price");
    var n=document.getElementById("n").innerHTML;
    if(obj!=null){
        for(var i=0;i<obj.length;i++){
            if(obj[i].checked){
                price.innerHTML=obj[i].value*n;
                return i;
            }
        }
    }
}
function goorder(){
    var name=document.getElementById("name").innerHTML;
    var price=document.getElementById("price").innerHTML;
    var people=document.getElementById("n").innerHTML;
    var obj=document.getElementsByName("ra");
    var n=obj[GetRadioValue()].value;
    if(price==""){
        alert("请选择景点！");
    }
    window.location.href="/order?name="+name+"&n="+people+"&price="+price+"&num="+n;
}
function goPage(pno){
    var itable = document.getElementById("itable");
    var num = itable.rows.length;//表格所有行数(所有记录数)
    console.log(num);
    var totalPage = 0;//总页数
    var pageSize = 2;//每页显示行数
    //总共分几页
    if(num/pageSize > parseInt(num/pageSize)){
        totalPage=parseInt(num/pageSize)+1;
    }else{
        totalPage=parseInt(num/pageSize);
    }
    var currentPage = pno;//当前页数
    var startRow = (currentPage - 1) * pageSize+1;//开始显示的行  31
    var endRow = currentPage * pageSize;//结束显示的行   40
    endRow = (endRow > num)? num : endRow;    //40
    console.log(endRow);
    //遍历显示数据实现分页
    for(var i=1;i<(num+1);i++){
        var irow = itable.rows[i-1];
        if(i>=startRow && i<=endRow){
            irow.style.display = "table-row";
        }else{
            irow.style.display = "none";
        }
    }
    var pageEnd = document.getElementById("pageEnd");
    var tempStr = "<span>共"+totalPage+"页　</span>";

    if(currentPage>1){
        tempStr += "<a href=\"#\" onClick=\"goPage("+(1)+")\">首页</a>　";
        tempStr += "<a href=\"#\" onClick=\"goPage("+(currentPage-1)+")\"><上一页</a>　"
    }else{
        tempStr += "首页　";
        tempStr += "<上一页　";
    }

    for(var pageIndex= 1;pageIndex<totalPage+1;pageIndex++){
        tempStr += "<a href=\"#\" onclick=\"goPage("+pageIndex+")\">"+ pageIndex +"</a>　";
    }

    if(currentPage<totalPage){
        tempStr += "<a href=\"#\" onClick=\"goPage("+(currentPage+1)+")\">下一页></a>　";
        tempStr += "<a href=\"#\" onClick=\"goPage("+(totalPage)+")\">尾页</a>　";
    }else{
        tempStr += "下一页>　";
        tempStr += "尾页　";
    }
    document.getElementById("barcon").innerHTML = tempStr;
}