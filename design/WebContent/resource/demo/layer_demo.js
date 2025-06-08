/**
 * Created by Administrator on 2016/6/8 0008.
 */

$(function () {

    $("#s1").on("click", function () {
        layer.alert("我是弹出框,警告窗口");
        console.log("没有阻塞作用!");
    });

    var index = -1;
    $("#s2").on("click", function () {
        switch (index) {
            case -1:
                layer.alert("我没有图标,看内容和标题栏栏", {title: "信息提示"});
                break;

            case 0:
                layer.alert("设置{icon:0,title:'warning'}", {title: "警告窗口", icon: 0});
                break;
            case 1:
                layer.alert("设置{icon:1,title:'success'}", {title: "成功", icon: 1});
                break;
            case 2:
                layer.alert("设置{icon:2,title:'error'}", {title: "错误", icon: 2});
                break;
            case 3:
                layer.alert("设置{icon:3,title:'no'}", {title: "未知", icon: 3});
                break;
            case 4:
                layer.alert("设置{icon:4,title:'锁住'}", {title: "上锁了", icon: 4});
                break;
            case 5:
                layer.alert("设置{icon:5,title:'success'}", {title: "笑脸成功", icon: 5});
                break;
            case 6:
                layer.alert("设置{icon:6,title:'error'}", {title: "哭脸", icon: 6});
                break;
            default:
                index = -1;
                layer.alert("我没有图标,看内容和标题栏栏", {title: "信息提示"});
                break;
        }
        index++;

    });

    $("#s3").on("click", function s3() {
        var k = layer.alert("看我变化万千", {title: "信息提示", icon: index}, function (i) {

            index = i - 1;
            if (index === 7) {
                index = -1;
                layer.closeAll();
                return;
            }


            console.log(index)
            layer.close(i);
            $("#s3").off("click");
            $("#s3").on("click", s3());

        });

        layer.title("测试顶顶顶顶"+k, k);

    });

    $("#s4").on("click", function () {
        layer.alert("蒙板没有了", {title: "信息提示", icon: 6 ,shade: 0});
    });

    $("#s5").on("click", function () {
        top.layer.alert("我有强大的穿透能力", {title: "信息提示", icon: 4 });
    });

});
