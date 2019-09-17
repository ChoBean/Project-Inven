package board.util;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
 
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
 
public class ModifyRequestValidator implements Validator{
    
    private static final String emailRegExp =
            "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" +
            "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
    private Pattern pattern;
 
    public ModifyRequestValidator() {
        pattern = Pattern.compile(emailRegExp);
    }
 
    @Override
    public boolean supports(Class<?> clazz) {
        return ModifyRequest.class.isAssignableFrom(clazz);
    }
 
    @Override
    public void validate(Object target, Errors errors) {
        ModifyRequest modReq = (ModifyRequest) target;
        
        if(modReq.getEmail() == null || modReq.getEmail().trim().isEmpty()) {
            errors.rejectValue("email", "required", "필수 정보 입니다.");
        } else {
            Matcher matcher = pattern.matcher(modReq.getEmail());
            if(!matcher.matches()) {
                errors.rejectValue("email", "bad", "올바르지 않는 형식입니다.");
            }
        }
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "required", "필수 정보 입니다.");
        ValidationUtils.rejectIfEmpty(errors, "pw", "required", "필수 정보 입니다.");
        ValidationUtils.rejectIfEmpty(errors, "checkPw", "required", "필수 정보 입니다.");
        if(!modReq.getPw().isEmpty()) {
            if(!modReq.equalToCheckPw()) {
                errors.rejectValue("checkPw", "nomatch", "비밀번호가 일치하지 않습니다.");
            }
        }
    }
 
}
