package com.vfislk.web.validators;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.vfislk.entity.Leave;

@Component
public class LeaveFormValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return clazz.isAssignableFrom(Leave.class);
	}

	@Override
	public void validate(Object target, Errors errors) {
		ValidationUtils.rejectIfEmptyOrWhitespace(
				errors, "fromDate", "leave.empty.fromDate", "Date is mandatory");
		ValidationUtils.rejectIfEmptyOrWhitespace(
				errors, "toDate", "leave.empty.toDate", "Date is mandatory");
		ValidationUtils.rejectIfEmptyOrWhitespace(
				errors, "leaveType", "leave.empty.leaveType", "Please select Leave Type");
		
		
		Leave leave = (Leave) target;
		if(leave.getLeaveType()==null) {
			errors.rejectValue("leaveType", "leave.min.leaveType", "Please select Leave Type");
	}
	}

}
