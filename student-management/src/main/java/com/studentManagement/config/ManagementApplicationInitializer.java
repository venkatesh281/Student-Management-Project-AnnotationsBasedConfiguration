package com.studentManagement.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class ManagementApplicationInitializer extends AbstractAnnotationConfigDispatcherServletInitializer{

	@Override
	protected Class<?>[] getRootConfigClasses() {
		
		return new Class[] {
	            WebMvcConfig.class
	        };
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		
		Class aClass[] = {WebMvcConfig.class }; 
        return aClass;
		
	}

	@Override
	protected String[] getServletMappings() {
		 String arr[] = { "/" }; 
	        return arr; 
	
	}
	
	
	
	

}
