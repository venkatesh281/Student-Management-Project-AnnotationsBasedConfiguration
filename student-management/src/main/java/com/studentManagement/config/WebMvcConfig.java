package com.studentManagement.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import com.studentManagement.StudentDao;
import com.studentManagement.TeacherDao;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.studentManagement")
public class WebMvcConfig implements WebMvcConfigurer {

	@Bean
	public InternalResourceViewResolver viewResolver() {

		 InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		//viewResolver.setViewClass(JstlView.class);
		viewResolver.setPrefix("/WEB-INF/jsp/");
		viewResolver.setSuffix(".jsp");
		return viewResolver;

	}


	@Bean(name ="ds")
	public DataSource dataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/student_management");
		dataSource.setUsername("root");
		dataSource.setPassword("VenkaT@28");
		return dataSource;
	}

	@Bean(name ="jt")
	public JdbcTemplate jdbcTemplate() {
		JdbcTemplate jdbcTemplate = new JdbcTemplate();
		jdbcTemplate.setDataSource(dataSource());
		return jdbcTemplate;
	}
	
	@Bean(name ="studObj")
	  public StudentDao studentDao(){
	    StudentDao studObj = new StudentDao();
	    studObj.setJdbcTemplate(jdbcTemplate());
	    return studObj;
	  }
	
	@Bean(name ="teachObj")
	public TeacherDao teacherDao() {
	
		 TeacherDao teachObj = new TeacherDao();
		 teachObj.setJdbcTemplateTeacher(jdbcTemplate());
		 return teachObj;
	
	}

}
