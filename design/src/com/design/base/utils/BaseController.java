package com.design.base.utils;

import java.beans.PropertyEditorSupport;
import java.util.Date;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;




public abstract class BaseController {
    
    protected static final String JSP_MESSAGE = "jsp/message";
    
    protected HttpServletRequest request;
    protected HttpServletResponse response;
    protected HttpSession session;
    protected ServletContext application;
    
    @ModelAttribute
    public void setServletAPI(HttpServletRequest request,HttpServletResponse response){

        this.request = request;
        this.response = response;
        this.session = request.getSession();
        this.application = this.session.getServletContext();
    }

    @InitBinder
    public void initDate(WebDataBinder dataBinder){
        dataBinder.registerCustomEditor(Date.class , new PropertyEditorSupport(){
            @Override
            public void setAsText(String text ) throws IllegalArgumentException {
                setValue(DateHelper.parseDate(text));
            }
        });
    }

    
    
}
