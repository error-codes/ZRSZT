package com.young.zrszt.annotation;

import org.apache.commons.lang3.StringUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.regex.Pattern;

/**
 * @author error-codes 【BayMax】
 * @see <a href="www.error-codes.xyz">BayMax Blog</a>
 * @since 2022/5/30 14:58
 */
public class PhoneValidation implements ConstraintValidator<Phone, String> {

    public static final Pattern PATTERN = Pattern.compile("^1[35789]\\d{9}$");

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        if (StringUtils.isBlank(s)) {
            return false;
        } else {
            return PATTERN.matcher(s).matches();
        }
    }
}
