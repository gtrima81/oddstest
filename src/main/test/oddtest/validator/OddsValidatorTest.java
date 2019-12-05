package oddtest.validator;


import oddtest.apigenerated.model.Odds;
import org.junit.Before;
import org.junit.Test;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;

import static org.assertj.core.api.Assertions.assertThat;


public class OddsValidatorTest {

    private OddsValidator oddsValidator;

    @Before
    public void setUp() throws Exception {
        oddsValidator = new OddsValidator();
    }

    @Test
    public void shouldSupportOddsBodyRequest() {
        // when
        boolean result = oddsValidator.supports(Odds.class);

        // then
        assertThat(result).isTrue();
    }

    @Test
    public void shouldRejectNullAndEmptyValue() {
        // given
        Odds odds = new Odds();
        Errors errors = new BeanPropertyBindingResult(odds, "odds");

        // when
        oddsValidator.validate(odds, errors);

        // then
        assertThat(errors.getFieldError()).extracting(FieldError::getField, FieldError::getCode).contains("odds", "can t be null or empty");
    }

    @Test
    public void shouldRejectWrongFractionsValue() {
        // given
        Odds odds = new Odds();
        odds.setOdds("1/23/2");
        Errors errors = new BeanPropertyBindingResult(odds, "odds");

        // when
        oddsValidator.validate(odds, errors);

        // then
        assertThat(errors.getFieldError()).extracting(FieldError::getField, FieldError::getCode).contains("odds", "wrong format");
    }

    @Test
    public void shouldRejectWrongFractionsWithZeroValue() {
        // given
        Odds odds = new Odds();
        odds.setOdds("0/10");
        Errors errors = new BeanPropertyBindingResult(odds, "odds");

        // when
        oddsValidator.validate(odds, errors);

        // then
        assertThat(errors.getFieldError()).extracting(FieldError::getField, FieldError::getCode).contains("odds", "not valid fraction");
    }

}