package com.eventi.left.design.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.eventi.left.common.Paging;
import com.eventi.left.design.service.DesignService;
import com.eventi.left.design.service.DesignVO;

@Controller
@RequestMapping("/design")
public class DesignController {
@Autowired DesignService service;
	
	@RequestMapping("/designList")
	public String bfList(Model model, DesignVO vo, Paging paging) {
		model.addAttribute("designList", service.designList(vo, paging));
		return "content/design/designList";
	}
}
