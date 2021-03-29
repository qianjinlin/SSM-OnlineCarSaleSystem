$(document).ready(function () {
    $("#login").click(function () {
        var username1=document.getElementById("username");/*获得用户名*/
        var pass1=document.getElementById("password");/*获得密码*/
        var reg= /^[a-zA-Z]\w{3,15}$/;/*正则表达式,用于判断用户名是否合法*/
        if(username1.value =='' || username1.value == undefined || username1.value==null){
            layer.msg("用户名不可为空",{
                icon:5
            });
        }else if(pass1.value =='' || pass1.value == undefined || pass1.value==null){
            layer.msg("请输入密码！",{
                icon:5
            });
        }else if(reg.test(username1.value) == false){
            layer.msg("用户名格式不正确！请重新输入",{
                icon:2
            });
        }else{
            var index="";
            $.ajax({
               url:"car/login",
                type:"post",
                data:{
                   username:username1.value,
                    password:pass1.value
                },
                beforeSend:function(){
                    index=layer.load(1, {
                        shade: [0.1,'#fff'],
                        time:2000//0.1透明度的白色背景
                    });
                },
                complete:function(){
                  layer.close(index);
                },
                success:function (data) {
                   if(data == "ok"){
                      localStorage.setItem("username",username1.value);//存储用户名，在后面调用
                       window.location.href = "testMain.html";
                   }
                  },
                error:function (data,error) {
                    layer.msg("用户名或者密码错误",function () {
                       document.getElementById("username").value="";
                        document.getElementById("password").value="";
                        },{
                        icon:2,
                        time:2000
                    });
                }
            });
        }
    });

});