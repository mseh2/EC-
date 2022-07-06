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
import com.example.ecsite.model.entity.Goods;
import com.example.ecsite.model.entity.User;
import com.example.ecsite.model.form.GoodsForm;
import com.example.ecsite.model.form.LoginForm;

//Adminトップ：http://localhost:8080/ecsite/admin/

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
	
	@RequestMapping("/goodsMst")
	public String goodMst(LoginForm form,Model m) {
		m.addAttribute("userName",form.getUserName());
		m.addAttribute("password",form.getPassword());
		return "goodsmst";
	}
	
	@RequestMapping("/addGoods")
	public String addGoods(GoodsForm gf,LoginForm lf,Model m) {
		m.addAttribute("userName",lf.getUserName());
		m.addAttribute("password",lf.getPassword());
		
		Goods goods = new Goods();
		goods.setGoodsName(gf.getGoodsName());
		goods.setPrice(gf.getPrice());
		goodsRep.saveAndFlush(goods);
		
		return "forward:/ecsite/admin/welcome";
		
	}
	
	@ResponseBody
	@PostMapping("/api/deleteGoods")
	public String deleteApi(@RequestBody GoodsForm f , Model m) {
		try {
			goodsRep.deleteById(f.getId());
		}catch(IllegalArgumentException e) {
			return "-1";
		}
		return "1";
	}
	
}
