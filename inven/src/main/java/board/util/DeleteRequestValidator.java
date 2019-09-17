package board.util;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class DeleteRequestValidator  implements Validator{

	@Override
	public boolean supports(Class<?> clazz) {
		  return DeleteRequest.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		DeleteRequest delReq = (DeleteRequest) target;
	
	}

}
