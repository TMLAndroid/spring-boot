package com.luban.properties;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import javax.validation.constraints.Email;

@Component
@ConfigurationProperties(prefix = "student")
@Validated
public class Student {
	private String name;
	private int age;
	//spl表达式
	@Value("#{${sex}+${sex1}}")
	private int sex;

	//JSR303
	@Email(message = "不符合邮箱格式")
	private String email;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getSex() {
		return sex;
	}

	public void setSex(int sex) {
		this.sex = sex;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Student{" +
				"name='" + name + '\'' +
				", age=" + age +
				", sex=" + sex +
				", email='" + email + '\'' +
				'}';
	}
}
