package com.vfislk.web.validators;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.vfislk.entity.Employee;

@Component
public class FormValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return clazz.isAssignableFrom(Employee.class);
	}

	@Override
	public void validate(Object target, Errors errors) {
		ValidationUtils.rejectIfEmptyOrWhitespace(
				errors, "fname", "employee.empty.fname", "Name is mandatory");
		ValidationUtils.rejectIfEmptyOrWhitespace(
				errors, "email", "employee.empty.email", "Email is mandatory");
		
		
		Employee emp = (Employee) target;
		if(emp.getDeptId()==null) {
			errors.rejectValue("deptId", "employee.min.deptId", "Please select Department");
	}
	}

}
