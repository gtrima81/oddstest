package oddtest.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import oddtest.apigenerated.model.Odds;


public interface PostRequestBodyValidator extends Validator {
    @Override
    default boolean supports(Class<?> aClass){
        return Odds.class.isAssignableFrom(aClass);
    }

}
