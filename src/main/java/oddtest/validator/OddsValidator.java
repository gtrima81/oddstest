package oddtest.validator;

import oddtest.apigenerated.model.Odds;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class OddsValidator implements Validator {
    @Override
    public boolean supports(Class<?> aClass) {
        return Odds.class.isAssignableFrom(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        Odds oddsRequest = (Odds) o;
        String oddsValue = oddsRequest.getOdds();

        if (oddsValue == null || oddsValue.isEmpty() || oddsValue.isBlank()) {
            errors.rejectValue("odds", "can t be null or empty");
            return;
        }

        if (!oddsValue.matches("([0-9]+/[0-9]+)|([A-Z]{2})")) {
            errors.rejectValue("odds", "wrong format");
        }

        if (oddsValue.matches("([0-9]+/[0-9]+)") && !isAValidFraction(oddsValue)) {
            errors.rejectValue("odds", "not valid fraction");
        }
    }

    private boolean isAValidFraction(String value) {
        String[] values = value.split("/");

        if (Integer.parseInt(values[0]) > 0 && Integer.parseInt(values[1]) > 0) {
            return true;
        }

        return false;
    }
}
