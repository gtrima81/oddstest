package oddtest.validator;

import org.springframework.validation.Errors;

public class OddsValidator implements PostRequestBodyValidator {
    @Override
    public void validate(Object o, Errors errors) {
        System.out.print("");
    }
}
