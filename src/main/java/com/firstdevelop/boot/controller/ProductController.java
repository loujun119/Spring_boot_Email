package com.firstdevelop.boot.controller;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.firstdevelop.boot.entity.Product;
import com.firstdevelop.boot.form.EmailAdressForm;
import com.firstdevelop.boot.form.ProductForm;
import com.firstdevelop.boot.service.ProductService;

@Controller
@RequestMapping("/product")
public class ProductController {

	@Autowired
	private ProductService productService;
	
	@RequestMapping("/searchAll")
	public String searchAll(Model model) {

		List<Product> productList = productService.searchAll();
		model.addAttribute("productList", productList);
		model.addAttribute("title", "ユーザー一覧");
		
		return "/product/productDetail";
	}
	
	@Autowired
	private JavaMailSender mailSender;
	
	@RequestMapping("/registInit")
	public String registInit() {
		
		return "/product/regist";
	}
	
	@RequestMapping("/regist")
	public String regist(ProductForm form) {
		
		productService.regist(form);
		return "redirect:searchAll";
	}
	@RequestMapping("/delete/{productId}")
	public String delete(@PathVariable("productId") Integer productId ,Model model) {
		
		productService.delete(productId);
		
		List<Product> productList = productService.searchAll();
		model.addAttribute("productList", productList);
		model.addAttribute("title", "ユーザー一覧");
		return "/product/productDetail";
		//return "redirect:searchAll";
	}

    // エクセル内容をアップロードして、DBに保存する処理
    @PostMapping("/upload")
    public String upload(@RequestParam("file") MultipartFile file) throws Exception{
        if (file.isEmpty()){
        	return "redirect:searchAll";
        }else {
        	// エクセル
            String fileName = file.getOriginalFilename();
            InputStream is = file.getInputStream();
            boolean isUploadOk = productService.importProductInfo(fileName,is);
            if (isUploadOk){
            	return "redirect:searchAll";
            }else {
            	return "redirect:searchAll";
            }
        }
    }
    
    // メール送信画面を開く
    @RequestMapping("/openEmail")
    public String openEmail(Model model){
    	return "email/sendEmail";
    }
    
    // メール送信
    @RequestMapping("/sendM")
    public String sendMail(
    		@RequestParam("file_address_list") MultipartFile file_address_list,
    		@RequestParam("file_email_text") MultipartFile file_email_text,
    		@RequestParam("file_upload") MultipartFile file_upload,
    		@RequestParam("title_email_text") String title_email_text,
    		Model model
    ){
    	// メール本文
        InputStream textData = null;
        String emailText = null;
		try {
			String fileTextName = file_email_text.getOriginalFilename();
			textData = file_email_text.getInputStream();
			emailText = productService.sendEmailText(fileTextName,textData);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	// address list 取得
        InputStream addressData = null;
        List<EmailAdressForm> addressList = null;
		try {
			String fileAddressName = file_address_list.getOriginalFilename();
			addressData = file_address_list.getInputStream();
			addressList = productService.sendEmailAddressList(fileAddressName,addressData);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		List<EmailAdressForm> errorAddressList = new ArrayList<>();
		boolean isError = false;
		String  error_Message = null;
		String  result_Message = null;
		
		
		for (EmailAdressForm address : addressList) {
			String title = address.getComName();
			String perName = address.getPerson();
			MimeMessage message = mailSender.createMimeMessage();
			String fileName = file_upload.getOriginalFilename();
			MimeMessageHelper helper;
			try {
				helper = new MimeMessageHelper(message, true);
				helper.setTo(address.getEmailAdress());
				helper.setSubject(title_email_text);
				helper.setText(String.format(emailText, title, perName), true);
				System.out.print(String.format(emailText, title, perName));
				
				helper.addAttachment(fileName, file_upload);
				mailSender.send(message);
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				isError = true;
				errorAddressList.add(address);
			}
		}
		
		if (isError) {
			error_Message = "メール送信処理件数:" + addressList.size() + "。";
		                          
			result_Message =  "送信成功：" + (addressList.size() - errorAddressList.size()) +"件。\n" +
                              "送信失敗:" + errorAddressList.size() + "。";
			model.addAttribute("message", error_Message);
			model.addAttribute("result_Message", result_Message);
			model.addAttribute("errorAddressList", errorAddressList);
		} else {
			result_Message = addressList.size() + "件メールが送信しました。";
			model.addAttribute("result_Message", result_Message);
		}
		
		return "email/email";
    }
}
