package com.javablog.cotroller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.javablog.model.domain.Admin;
import com.javablog.model.service.AdminServiceImpl;

@RestController
public class AdminRestController {
	
	@Autowired
	private AdminServiceImpl adminImpl;
	
	@RequestMapping(value="/rest/admin/login", method=RequestMethod.GET)
	public String login(Admin admin, HttpServletRequest request) {
		System.out.println("/rest/admin/login=RestController ����");
		String resultCode=null;
		
		Admin adminResult = adminImpl.login(admin);
		if(adminResult==null) {
			resultCode="0";
		}else {
			resultCode="1";
		}
		
		System.out.println("adminImpl.login �۵�. json ��ȯ");
		
		request.getSession().setAttribute("admin", adminResult);
		return resultCode;
	}
}
