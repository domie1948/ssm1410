package com.design.framework.manager.web;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.OutputStream;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.design.base.utils.BaseController;
import com.design.framework.manager.model.Manager;
import com.design.framework.manager.service.ManagerService;
import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGImageEncoder;
@Controller
@Scope("prototype")
@RequestMapping("/sys")
public class LoginController extends BaseController {

    private final static boolean FLAG = false;
    
    private final static String URL_LOGIN = "/login";
    private final static String URL_LOGIN_OUT = "/loginOut";
    private final static String URL_HOME = "redirect:/sys/home";
    private final static String JSP_HOME = "jsp/home";
    private final static String URL_CONTENT = "/content";
    private final static String JSP_CONTENT = "jsp/content";
    private final static String URL_REDIRECT_LOGIN = "redirect:/sys/login";
    private final static String JSP_LOGIN = "jsp/login";


    @Autowired
    private ManagerService managerService ;

    @SuppressWarnings("unused" )
    @PostMapping(URL_LOGIN)
    public String login(String account,String password,String code,ModelMap modelMap,HttpServletRequest request){
        try{
            
            String session_code = this.session.getAttribute("validateCode").toString();

            if(FLAG || session_code.equals(code)){
                Manager manager = this.managerService.login(account,password);
                HttpSession session = request.getSession();
                session.setAttribute("session_manager" , manager);
                
                return URL_HOME;
            }else{
                modelMap.addAttribute("message" , "您输入的验证吗不正确,请重新输入!");
                modelMap.addAttribute("account" , account);
                return JSP_LOGIN;
            }
        }catch(RuntimeException e){
            modelMap.addAttribute("message" , e.getMessage());
            modelMap.addAttribute("account" , account);
            return JSP_LOGIN;
        }

    }
    @GetMapping(URL_LOGIN)
    public String login(){
        return JSP_LOGIN;
    }
    @GetMapping(URL_CONTENT)
    public String content(){
    	return JSP_CONTENT;
    }
    @GetMapping("/home")
    public String home(){
    	return JSP_HOME;
    }
    @GetMapping(URL_LOGIN_OUT)
    public String loginOut(HttpServletRequest request){
        HttpSession session = request.getSession();
        //手动注销Session
        session.invalidate();
        return URL_REDIRECT_LOGIN;
    }


    @RequestMapping(path="/code",method=RequestMethod.GET)
    @ResponseBody
    public void validCode() throws Exception{
        String s = "";
        /**
         * 验证码宽度
         */
        int width=113;
        /**
         * 验证码高度
         */
        int height=45;
        /**
         * 验证码字符集
         */
        char[] code=new char[]{
                'a','b','c','d','e','f','g','h','i','j','k','l','m','n','p','q','r','s','t','u','v','w','x','y','z',
                '2','3','4','5','6','7','8','9'};
        
        /**
         *  创建一个随机数生成器类
         */
        Random random = new Random();

        // 随机产生codeCount数字的验证码。
        for (int i = 0; i < 4; i++) {
            // 得到随机产生的验证码数字。
            String strRand = String.valueOf(code[random.nextInt(code.length)]);
            
            // 将产生的四个随机数组合在一起。
            s=s+strRand;
        }

        // 保存入session,用于与用户的输入进行比较.
        // 注意比较完之后清除session.

        this.session.setAttribute("validateCode", s);

        this.response.setContentType("image/gif");

        // 定义图像buffer
        BufferedImage image = new BufferedImage(width, height,
                BufferedImage.TYPE_INT_RGB);
        Graphics2D gra = image.createGraphics();
        // 将图像填充为白色
        gra.setColor(Color.WHITE);
        gra.fillRect(0, 0, width, height);
        
        // 创建字体，字体的大小应该根据图片的高度来定。
        
        //字体对象构造方法public Font(String familyName,int style,int size)
        // familyName字体名；字体名可以分成两大类：中文字体：宋体、楷体、黑体等；英文字体：Arial、Times New Roman等等；
        // style风格。PLAIN普通字体，BOLD（加粗），ITALIC（斜体），Font.BOLD+ Font.ITALIC（粗斜体）
        //size 大小

        Font font = new Font("宋体", Font.BOLD, 32/*height-4*/);//

        // 设置字体。
        gra.setFont(font);

        // 画边框。
        gra.setColor(getColor());
        gra.drawRect(0, 0, width - 1, height - 1);

        // 随机产生干扰线，使图象中的认证码不易被其它程序探测到。
        gra.setColor(Color.BLACK);
        for (int i = 0; i < 50; i++) {
            int x = random.nextInt(width);
            int y = random.nextInt(height);
            int xl = random.nextInt(5);
            int yl = random.nextInt(5);
            gra.setColor(getColor());
            gra.drawLine(x, y, x + xl, y + yl);
        }
        
        // 输出数字
        char c;

        for (int i = 0; i < 4; i++) {

            c = s.charAt(i);

            gra.drawString(c + "", i * 25 + 2, 32); // 25为宽度，11为上下高度位置

        }

        OutputStream toClient = this.response.getOutputStream();
        JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(toClient);
        encoder.encode(image);

        toClient.close();
        


    }
    
    private Color getColor()
    {
        Random random = new Random();
        int red = 0, green = 0, blue = 0;
        // 产生随机的颜色分量来构造颜色值，这样输出的每位数字的颜色值都将不同。
        red = random.nextInt(255);
        green = random.nextInt(255);
        blue = random.nextInt(255);
        return new Color(red,green,blue);
    }
}
