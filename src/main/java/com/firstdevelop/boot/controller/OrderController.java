package com.firstdevelop.boot.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.firstdevelop.boot.entity.Product;
import com.firstdevelop.boot.entity.UserEntity;
import com.firstdevelop.boot.mapper.OrderMapper;
import com.firstdevelop.boot.service.ProductService;

@Controller
@RequestMapping("/order")
public class OrderController {
	@Autowired
	ProductService productService;
	@Autowired
	OrderMapper orderMapper;
	@RequestMapping("/cart")
	public String cart(Model model,HttpSession session) {
		UserEntity user = (UserEntity) session.getAttribute("user");
		if(user != null) {
			List<Product> product_list = productService.searchAll();
			model.addAttribute("product_list",product_list);
			return "/mall/cart";
		}
		return "login";
	}
	@PostMapping("/add")
	public String add(@RequestParam("productname") int productname,@RequestParam("quantity") int quantity,HttpSession session) {
		UserEntity user = (UserEntity) session.getAttribute("user");
		orderMapper.insert(productname,quantity,user.getId());
		return "/mall/cart";
	}
}
