package com.vfislk.web.validators;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.vfislk.entity.Manager;

@Component
public class MngFormValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return clazz.isAssignableFrom(Manager.class);
	}

	@Override
	public void validate(Object target, Errors errors) {
		ValidationUtils.rejectIfEmptyOrWhitespace(
				errors, "fname", "manager.empty.fname", "Name is mandatory");
		ValidationUtils.rejectIfEmptyOrWhitespace(
				errors, "email", "manager.empty.email", "Email is mandatory");
		ValidationUtils.rejectIfEmptyOrWhitespace(
				errors, "phone", "manager.empty.phone", "Enter 10 digit phone no.");
		ValidationUtils.rejectIfEmptyOrWhitespace(
				errors, "password", "manager.empty.password", "Enter strong password");
		ValidationUtils.rejectIfEmptyOrWhitespace(
				errors, "dob", "manager.empty.dob", "Enter date of birth");
		
		
		Manager emp = (Manager) target;
		if(emp.getDeptId()==null) {
			errors.rejectValue("deptId", "manager.min.deptId", "Please select Department");
	}
	}

}
