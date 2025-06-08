package com.design.framework.manager.web;

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

import com.design.framework.dorm.model.Dorm;
import com.design.framework.manager.model.Manager;
import com.design.framework.manager.service.ManagerService;

@Controller
@Scope("prototype")
@RequestMapping("/sys/manager")
public class ManagerController {
	
	private final static String URL_MANAGER_LIST = "/list";
	private final static String JSP_MANAGER_LIST = "jsp/manager/list";
	private final static String URL_MANAGER_ADD = "/add";
	private final static String JSP_MANAGER_ADD = "jsp/manager/add";
	private final static String URL_MANAGER_DELETE = "/delete/{manager_id}";
	
	@Autowired
    private ManagerService managerService;
	
	@GetMapping(URL_MANAGER_ADD)
	public String add(){
		return JSP_MANAGER_ADD;
	}
	
	@PostMapping(URL_MANAGER_ADD)
	@ResponseBody
	public Map<String,Object> add(Manager manager){
		Map<String , Object> map = new HashMap<String , Object>();
        try{
            this.managerService.add(manager);
            map.put("flag" , "success");
        }catch(Exception e){
            map.put("message" , e.getMessage());
        }
        return map;
	}
	
	
	
    @GetMapping(URL_MANAGER_LIST)
    public String list(Model model){
        model.addAttribute("managerList" , this.managerService.list());
        return JSP_MANAGER_LIST;
    }
    
    @GetMapping(URL_MANAGER_DELETE)
    public String delete(@PathVariable("manager_id") Integer manager_id){
    	this.managerService.delete(manager_id);
    	return "redirect:/sys/manager/list";
    }
	
}
