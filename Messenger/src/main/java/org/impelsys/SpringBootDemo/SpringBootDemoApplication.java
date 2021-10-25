package org.impelsys.SpringBootDemo;

import org.impelsys.SpringBootDemo.controller.CommentController;
import org.impelsys.SpringBootDemo.dao.impl.CommentDaoImpl;
import org.impelsys.SpringBootDemo.data.UserRepository;
import org.impelsys.SpringBootDemo.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.actuate.autoconfigure.security.servlet.ManagementWebSecurityAutoConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.autoconfigure.security.servlet.SecurityFilterAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
 
@SpringBootApplication
@EnableJpaRepositories

@EnableAutoConfiguration(exclude= { SecurityAutoConfiguration.class,
		ManagementWebSecurityAutoConfiguration.class
		//SecurityFilterAutoConfiguration.class,
		//ManagementWebSecurityAutoConfiguration.class
	
})
@EnableWebMvc
@EnableAspectJAutoProxy(proxyTargetClass = true)
//@ComponentScan(basePackages={"org.impelsys.controller" , "org.impelsys.resources","org.impelsys.config"})
@ComponentScan(basePackageClasses= {CommentController.class,CommentService.class,CommentDaoImpl.class,org.impelsys.SpringBootDemo.exception.handler.ControllerExceptionHandler.class})
public class SpringBootDemoApplication {

	//@Autowired
	//private static Environment environment; 
	
//	@Autowired
//	static ApplicationContext context;
	
	//@Value("${app.profile}")
	//private static String profile;
	
	//@Value("${spring.profiles.active}")
	//private static String activeProfile;
	
	public static void main(String[] args) {
		//System.setProperty("server.servlet.context-path", "/SpringBootDemo");
		//SpringApplicationBuilder(SpringBootDemoApplication.class).profiles("dev").run(args);
		
		//System.setProperty("spring.profiles.active", "dev");
				
		ApplicationContext context = SpringApplication.run(SpringBootDemoApplication.class, args);
		
		/*
		 * if(environment==null) environment = (Environment)
		 * context.getBean("environment");
		 * 
		 * String[] profilesList = environment.getActiveProfiles(); for(String s :
		 * profilesList) System.out.println(s);
		 * 
		 * 
		 * CommentController controller = (CommentController)
		 * context.getBean("commentController"); if(controller==null)
		 * System.out.println("Comment controller not created");
		 * 
		 * //SpringApplication.run(SpringBootDemoApplication.class, args);
		 */		
		System.out.println("Hello to the world of springBoot");
	}

}
