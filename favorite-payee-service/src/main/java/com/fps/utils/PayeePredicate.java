package com.fps.utils;

import java.util.Objects;
import java.util.function.Predicate;

public class PayeePredicate {

    public static final Predicate<Object> checkNull = Objects::isNull;

    public static final Predicate<Object> checkNotNull = Objects::nonNull;

    public static final Predicate<String> checkEmptyString = value -> value.isEmpty();

    public static final Predicate<String> isBlank = value -> value == null || value.isEmpty();

    public static final Predicate<Object> isNotBlank = value -> value != null && ! String.valueOf(value).isEmpty();


}
