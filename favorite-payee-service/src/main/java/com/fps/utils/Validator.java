package com.fps.utils;

import com.fps.exception.PayeeException;
import com.google.common.base.Predicates;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import static com.fps.utils.PayeePredicate.isBlank;

public class Validator {


    private Validator() {
    }

    public static void isNull(Object object, String code, String message) throws PayeeException {

        if (Predicates.isNull().apply(object)) {
            throw new PayeeException(code, message);
        }
    }


    public static void isNull(Optional optional, String code, String message) throws PayeeException {

        if (!optional.isPresent()) {
            throw new PayeeException(code, message);
        }
    }

    public static void isNullOrEmpty(String string, String code, String message) throws PayeeException {

        if (isBlank.test(string)) {
            throw new PayeeException(code, message);
        }
    }

    public static void isTrue(boolean expression, String code, String message) throws PayeeException {
        if (expression) {
            throw new PayeeException(code, message);
        }
    }

    public static void isNotNull(Object object, String code, String message) throws PayeeException {

        if (Predicates.notNull().apply(object))
            throw new PayeeException(code, message);

    }

    public static void isNotEqual(Object object1, Object object2, String code, String message) throws PayeeException {

        if (!Objects.equals(object1, object2)) {

            throw new PayeeException(code, message);
        }
    }

    public static void isNull(List<?> object, String code, String message) throws PayeeException {

        if (Predicates.isNull().apply(object) || object.size() == 0)
            throw new PayeeException(code, message);

    }
}