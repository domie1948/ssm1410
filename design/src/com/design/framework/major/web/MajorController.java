package com.design.framework.major.web;

import java.util.HashMap;
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

import com.design.framework.major.model.Major;
import com.design.framework.major.service.MajorService;

@Controller
@Scope("prototype")
@RequestMapping("/sys/major")
public class MajorController {
	
	private final static String URL_DELETE="/delete/{major_id}";
	private final static String URL_ADD = "/add";
	private final static String URL_TO_LIST="/list";
	private final static String JSP_LIST="jsp/major/list";
	private final static String JSP_ADD="jsp/major/add";
	private final static String JSP_delete = "redirect:/sys/major/list";
	
    @Autowired
    private MajorService majorService;
    
    
    @GetMapping(URL_TO_LIST)
    public String list(ModelMap modelMap){
    	modelMap.addAttribute("majorList", this.majorService.list());
        return JSP_LIST;
    }
    
    @GetMapping(URL_DELETE)
    public String delete(@PathVariable("major_id") Integer major_id){
    	this.majorService.delete(major_id);
    	return JSP_delete;
    }
    
    @GetMapping(URL_ADD)
    public String toAdd(){
    	return JSP_ADD;
    }
    
    @PostMapping(URL_ADD)
    @ResponseBody
    public Map<String,Object> add(String major_name){
    	Map<String , Object> map = new HashMap<String , Object>();
    	Major major = new Major();
    	major.setMajor_name(major_name);
    	try{
    		this.majorService.add(major); 
            map.put("flag" , "success");
        }catch(Exception e){
            map.put("message" , e.getMessage());
        }
        return map;
    }
}
