package com.xiazhou.base.spring.test;

import com.xiazhou.base.spring.entity.Student;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

/**
 * Created by zhangsong on 16/7/25.
 */
public class MainTest {

	public static void main(String[] args) {
		BeanFactory beanFactory = new XmlBeanFactory(new ClassPathResource(
				"com/xiazhou/base/spring/conf.xml"));
		Student student = (Student) beanFactory.getBean("student");
		System.out.println("s");
	}
}
