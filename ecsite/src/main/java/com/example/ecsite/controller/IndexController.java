package com.example.ecsite.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.ecsite.model.dao.GoodsRepositpry;
import com.example.ecsite.model.dao.UserRepository;
import com.example.ecsite.model.dto.LoginDto;
import com.example.ecsite.model.entity.Goods;
import com.example.ecsite.model.entity.User;
import com.example.ecsite.model.form.LoginForm;
import com.google.gson.Gson;

//Userトップ：http://localhost:8080/ecsite/

@Controller
@RequestMapping("/ecsite")
public class IndexController {
	
	@Autowired
	private UserRepository userRep;
	
	@Autowired
	private GoodsRepositpry goodsRep;
	
	private Gson gson = new Gson();
	
	@RequestMapping("/")
	public String index(Model m) {
		List<Goods> goods = goodsRep.findAll();
		m.addAttribute("goods",goods);
		return "index";
	}
	
	@ResponseBody
	@PostMapping("/api/login")
	public String loginApi(@RequestBody LoginForm form) {
		List<User> users = userRep.findByUserNameAndPassword(form.getUserName(), form.getPassword());
		
		LoginDto loginDto = new LoginDto(0,null,null,"ゲスト");
		if(users.size() > 0) {
			loginDto = new LoginDto(users.get(0));
		}
		return gson.toJson(loginDto);
	}
	
	
}
