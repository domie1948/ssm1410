var loginJS = {
    login:function(){

    },
    loginOut:function(){
    
    },
    validCode:function(){
        $("img").on("click",function(){
            //欺骗浏览器缓存
            $(this).attr("src","sys/code?"+(new Date()).getTime());
        });
    
    }
};

