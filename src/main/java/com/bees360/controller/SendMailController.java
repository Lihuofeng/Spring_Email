package com.bees360.controller;

import org.apache.velocity.app.VelocityEngine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.thymeleaf.spring4.SpringTemplateEngine;

import com.bees360.utils.EmailUtils;

import freemarker.template.Configuration;

/**
 * 测试邮件发送controller
 */
@RestController
@RequestMapping("mail")
public class SendMailController {
	@Autowired
	private JavaMailSender javaMailSender;// 在spring中配置的邮件发送的bean
	@Autowired
	private Configuration configuration;
	@Autowired
	private VelocityEngine velocityEngine;
	
	@Autowired
	private SpringTemplateEngine templateEngine;

	// text
	@RequestMapping("send")
	public String sendEmail() {
		EmailUtils emailUtils = new EmailUtils();
		return emailUtils.sendMail("测试email  text！！！", "测试email  text！！！", "E:/ftpfile/img/a.jpeg", "18877571474@163.com",
				javaMailSender, false);
	}

	// html
	@RequestMapping("send2")
	public String sendEmail2() {
		EmailUtils emailUtils = new EmailUtils();
		return emailUtils.sendMail(
				"测试email html" + "<a href='https://github.com/Lihuofeng'>点击打开我的Github!</a><br/>",
				"测试email html", "E:/ftpfile/img/a.jpeg", "18877571474@163.com", javaMailSender, true);
	}

	// freemarker
	@RequestMapping("send3")
	public String sendEmail3() {
		EmailUtils emailUtils = new EmailUtils();
		return emailUtils.sendMailFreeMarker("测试email freemarker", "E:/ftpfile/img/a.jpeg", "18877571474@163.com", javaMailSender,
				configuration);

	}

	// velocity
	@RequestMapping("send4")
	public String sendEmail4() {
		EmailUtils emailUtils = new EmailUtils();
		return emailUtils.sendMailVelocity("测试email velocity", "E:/ftpfile/img/a.jpeg", "18877571474@163.com", javaMailSender,
				velocityEngine);

	}
	
	
	// Thymeleaf
	@RequestMapping("send5")
	public String sendEmail5() {
		EmailUtils emailUtils = new EmailUtils();
		return emailUtils.sendMailThymeleaf("测试email Thymeleaf", "E:/ftpfile/img/a.jpeg", "18877571474@163.com", javaMailSender,
				templateEngine);

	}
}
