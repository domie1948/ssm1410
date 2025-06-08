package com.design.framework.classes.web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.design.framework.classes.model.Classes;
import com.design.framework.classes.service.ClassesService;
import com.design.framework.major.service.MajorService;
import com.design.framework.student.model.Student;
import com.design.framework.student.service.StudentService;

@Controller
@Scope("prototype")
@RequestMapping("/sys/class")
public class ClassesController {
	
	private final static String URL_DELETE="/delete/{class_id}";
	private final static String URL_ADD = "/add";
	private final static String URL_CLASSES_LIST = "/classesList";
	private final static String URL_TO_LIST="/list";
	private final static String URL_CLASS_ASSIGNED="/assigned";
	private final static String URL_CHECK_CLASS_ASSIGNED="/checkAssigned";
	private final static String JSP_LIST="jsp/class/list";
	private final static String JSP_ADD="jsp/class/add";
	private final static String JSP_CLASS_ASSIGNED="jsp/class/assigned";
	private final static String JSP_CHECK_CLASS_ASSIGNED="jsp/class/checkAssigned";
	private final static String JSP_delete = "redirect:/sys/class/list";
	
    @Autowired
    private ClassesService classesService;
    @Autowired
    private MajorService majorService;
    @Autowired
    private StudentService studentService;
    
    @GetMapping(URL_TO_LIST)
    public String list(ModelMap modelMap){
    	modelMap.addAttribute("classesList", this.classesService.list());
        return JSP_LIST;
    }
    
    @GetMapping(URL_CLASS_ASSIGNED)
    public String assigned(){
        return JSP_CLASS_ASSIGNED;
    }
    
    @GetMapping(URL_CHECK_CLASS_ASSIGNED)
    public String checkAssigned(){
        return JSP_CHECK_CLASS_ASSIGNED;
    }
    
    @GetMapping(URL_DELETE)
    public String delete(@PathVariable("class_id") Integer class_id){
    	this.classesService.delete(class_id);
    	return JSP_delete;
    }
    
    @GetMapping(URL_ADD)
    public String toAdd(ModelMap modelMap){
    	modelMap.addAttribute("majorList", this.majorService.list());
    	return JSP_ADD;
    }
    
    @PostMapping(URL_ADD)
    @ResponseBody
    public Map<String,Object> add(String class_name,Integer class_major){
    	Map<String , Object> map = new HashMap<String , Object>();
    	Classes classes = new Classes();
    	classes.setClass_name(class_name);
    	classes.setClass_major(class_major);
    	try{
    		this.classesService.add(classes); 
            map.put("flag" , "success");
        }catch(Exception e){
            map.put("message" , e.getMessage());
        }
        return map;
    }
    
    @PostMapping(URL_CLASSES_LIST)
    @ResponseBody
    public Map<String,Object> classesList(Integer student_id){
    	Map<String , Object> map = new HashMap<String , Object>();
    	Integer major_id = this.studentService.load(student_id).getStudent_major();
    	List<Classes>  classesList = this.classesService.majorClassList(major_id); 
    	if(classesList.size() != 0){
    		map.put("flag" , "success");
    		map.put("classesList", classesList);
    	}else{
    		map.put("flag" , "error");
    	}
        return map;
    }
    
    @PostMapping(URL_CLASS_ASSIGNED)
    public String assigned(Student student){
    	this.studentService.update(student);
        return JSP_CLASS_ASSIGNED;
    }
    
    @PostMapping(URL_CHECK_CLASS_ASSIGNED)
    @ResponseBody
    public Map<String,Object> checkAssigned(Integer student_id){
        Map<String , Object> map = new HashMap<String , Object>();
        Integer student_class = this.studentService.load(student_id).getStudent_class();
        if(student_class != null && student_class!=0){
        	map.put("flag" , "success");
        	map.put("student_class" , this.classesService.load(student_class).getClass_name());
        }else{
        	map.put("flag" , "error");
        }
        return map;
    }
}
