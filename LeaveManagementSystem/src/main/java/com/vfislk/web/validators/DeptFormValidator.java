package com.vfislk.web.validators;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.vfislk.entity.Department;

@Component
public class DeptFormValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return clazz.isAssignableFrom(Department.class);
	}

	@Override
	public void validate(Object target, Errors errors) {
		ValidationUtils.rejectIfEmptyOrWhitespace(
				errors, "deptName", "department.empty.deptName", "Dept Name is mandatory");
		ValidationUtils.rejectIfEmptyOrWhitespace(
				errors, "deptCode", "department.empty.deptCode", "Dept Code is mandatory");
		ValidationUtils.rejectIfEmptyOrWhitespace(
				errors, "deptShortName", "department.empty.deptShortName", "Dept Short Name is mandatory");
		
		
//		Department emp = (Department) target;
//		if(emp.getDeptId()==null) {
//			errors.rejectValue("deptId", "department.min.deptId", "Please select Department");
//	}
	}

}
