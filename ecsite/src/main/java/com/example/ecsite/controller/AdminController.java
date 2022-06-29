package com.example.ecsite.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.ecsite.model.dao.GoodsRepositpry;
import com.example.ecsite.model.dao.UserRepository;
import com.example.ecsite.model.entity.Goods;
import com.example.ecsite.model.entity.User;
import com.example.ecsite.model.form.LoginForm;

//トップ：http://localhost:8080/ecsite/admin/
//スライド21から

@Controller
@RequestMapping("/ecsite/admin")
public class AdminController {
	@Autowired
	private UserRepository userRep;

	@Autowired
	private GoodsRepositpry goodsRep;
		
	@RequestMapping("/")
	public String index() {
		return "adminindex";
	}
	
	@RequestMapping("/welcome")
	public String welcome(LoginForm form,Model m) {
		List<User> users = userRep.findByUserNameAndPassword(form.getUserName(), form.getPassword());
			
		if(users != null && users.size() > 0) {
			boolean isAdmin = users.get(0).getIsAdmin() != 0;
			if(isAdmin) {
				List<Goods> goods = goodsRep.findAll();
				m.addAttribute("userName",users.get(0).getUserName());
				m.addAttribute("password",users.get(0).getPassword());
				m.addAttribute("goods",goods);
			}
		}		
		return "welcome";
	}
}
