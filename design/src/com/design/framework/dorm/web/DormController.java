package com.design.framework.dorm.web;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.design.base.utils.BaseController;
import com.design.framework.dorm.model.Dorm;
import com.design.framework.dorm.service.DormService;
import com.design.framework.student.service.StudentService;
@Controller
@Scope("prototype")
@RequestMapping("/sys/dorm")
public class DormController extends BaseController {

    private final static String URL_DORM_LIST = "/list";
    private final static String JSP_DORM_LIST = "jsp/dorm/list";
    private final static String URL_DORM_ADD = "/add";
    private final static String JSP_DORM_ADD = "jsp/dorm/add";
    private final static String URL_DORM_DELETE = "/delete/{dorm_id}";
    private final static String JSP_DORM_DELETE = "redirect:/sys/dorm/list";
    private final static String URL_DORM_ASSIGNED = "/assigned";
    private final static String URL_CHECK_DORM_ASSIGNED = "/checkAssigned";
    private final static String JSP_DORM_ASSIGNED = "jsp/dorm/assigned";
    private final static String JSP_CHECK_DORM_ASSIGNED = "jsp/dorm/checkAssigned";


    @Autowired
    private DormService dormService ;
    @Autowired
    private StudentService studentService;

    @GetMapping(URL_DORM_DELETE)
    public String delete(@PathVariable("dorm_id") Integer dorm_id){
        this.dormService.delete(dorm_id);
        return JSP_DORM_DELETE;
    }
    
    @GetMapping(URL_DORM_ASSIGNED)
    public String assigned(Model model){
        model.addAttribute("dormList" , this.dormService.list());
        return JSP_DORM_ASSIGNED;
    }
    
    @GetMapping(URL_CHECK_DORM_ASSIGNED)
    public String checkAssigned(){
        return JSP_CHECK_DORM_ASSIGNED;
    }
    
    @GetMapping(URL_DORM_LIST)
    public String list(Model model){
        model.addAttribute("dormList" , this.dormService.list());
        return JSP_DORM_LIST;
    }
    @GetMapping(URL_DORM_ADD)
    public String toAdd(){
        return JSP_DORM_ADD;
    }
    @PostMapping(URL_DORM_ADD)
    @ResponseBody
    public Map<String,Object> add(String dorm_name){
        Map<String , Object> map = new HashMap<String , Object>();
        Dorm dorm = new Dorm();
        dorm.setDorm_name(dorm_name);
        try{
            this.dormService.add(dorm);
            map.put("flag" , "success");
        }catch(Exception e){
            map.put("message" , e.getMessage());
        }
        return map;
    }
    
    @PostMapping(URL_CHECK_DORM_ASSIGNED)
    @ResponseBody
    public Map<String,Object> checkAssigned(Integer student_id){
        Map<String , Object> map = new HashMap<String , Object>();
        Integer student_dorm = this.studentService.load(student_id).getStudent_dorm();
        if(student_dorm != null && student_dorm!=0){
        	map.put("flag" , "success");
        	map.put("student_dorm" , this.dormService.load(student_dorm).getDorm_name());
        }else{
        	map.put("flag" , "error");
        }
        return map;
    }

}
