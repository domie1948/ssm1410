package com.design.framework.student.web;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.design.framework.classes.service.ClassesService;
import com.design.framework.dorm.service.DormService;
import com.design.framework.major.service.MajorService;
import com.design.framework.student.model.Student;
import com.design.framework.student.service.StudentService;

@Controller
@Scope("prototype")
@RequestMapping("/sys/student")
public class StudentController {

    private final static String URL_ADD="/add";
    private final static String URL_LIST="/list";
    private final static String URL_TO_ADD="/toAdd";
    private final static String JSP_ADD="jsp/student/add";
    private final static String JSP_LIST="jsp/student/list";
    private final static String URL_CHARGE="/charge";
    private final static String URL_QUERY_CHARGE="/queryCharge";
    private final static String JSP_CHARGE="jsp/charge/charge";
    private final static String JSP_QUERY_CHARGE="jsp/charge/queryCharge";
    private final static String URL_ASSIGNEDDORM="/assignedDorm";
    private final static String JSP_ASSIGNEDDORM="jsp/dorm/assigned";
    private final static String URL_NAMETEST="/nameTest";

    @Autowired
    private StudentService studentService;
    @Autowired
    private MajorService majorService;
    @Autowired
    private DormService dormService ;
    @Autowired
    private ClassesService classesService;

    @GetMapping(URL_CHARGE)
    public String charge(){
        return JSP_CHARGE;
    }
    
    @GetMapping(URL_LIST)
    public String list(ModelMap mdoelMap,Student student){
    	mdoelMap.addAttribute("studentsList", this.studentService.list(student));
    	mdoelMap.addAttribute("majorList", this.majorService.list());
    	mdoelMap.addAttribute("classesList", this.classesService.list());
    	mdoelMap.addAttribute("dormList", this.dormService.list());
        return JSP_LIST;
    }
    
    @GetMapping(URL_QUERY_CHARGE)
    public String queryCharge(){
        return JSP_QUERY_CHARGE;
    }

    @PostMapping(URL_CHARGE)
    public String charge(Student student){
        student.setStudent_tuition(1);
        this.studentService.update(student);
        return JSP_CHARGE;
    }
    
    @PostMapping(URL_QUERY_CHARGE)
    @ResponseBody
    public Map<String,Object> queryCharge(Integer student_id){
    	Map<String , Object> map = new HashMap<String , Object>();
    	Integer student_tuition = this.studentService.load(student_id).getStudent_tuition();
    	System.out.println(student_tuition);
    	if(student_tuition == 1){
    		map.put("flag", "success");
    	}else{
    		map.put("flag", "error");
    	}
        return map;
    }

    @PostMapping(URL_ASSIGNEDDORM)
    public String assignedDorm(Student student){
        this.studentService.update(student);
        return JSP_ASSIGNEDDORM;
    }

    
    @GetMapping(URL_TO_ADD)
    public String toAdd(ModelMap modelMap){
        modelMap.addAttribute("majorList", this.majorService.list());
        return JSP_ADD;
    }

    @PostMapping(URL_ADD)
    public String add(Student student,ModelMap modelMap){
        this.studentService.add(student);
        return toAdd(modelMap);
    }

    @PostMapping(URL_NAMETEST)
    @ResponseBody
    public Map<String,Object> nameTest(Integer student_id){
        Map<String , Object> map = new HashMap<String , Object>();
        try{
            map.put("student_name" , this.studentService.load(student_id).getStudent_name());
            map.put("flag" , "success");
        }catch(Exception e){
            map.put("message" , e.getMessage());
        }
        return map;
    }
}
