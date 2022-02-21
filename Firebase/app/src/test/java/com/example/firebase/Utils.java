package com.example.firebase;

import org.hamcrest.core.Is;
import org.junit.Assert;
import org.junit.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Utils {

    public static boolean checkEmailForValidity(String email) {
        Matcher mathcher = VALID_EMAIL_ADDRESS_REGEX.matcher(email);
        return mathcher.find();
    }
    public static boolean checkPasswordForValidity(String password) {
        Matcher mathcher = VALID_EMAIL_PASSWORD_REGEX.matcher(password);
        return mathcher.find();
    }
    private static final Pattern VALID_EMAIL_ADDRESS_REGEX = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
    private static final Pattern VALID_EMAIL_PASSWORD_REGEX = Pattern.compile("^(?=.*[0-9])(?=.*[!@#$%^&*])(?=.*[a-z])(?=.*[A-Z])[0-9a-zA-Z!@#$%^&*]{8,20}$");
    @Test
    public void testIsEmailValid() {
        String testEmail = "anupamch123@gmail.com";
        Assert.assertThat(String.format("Email id valid %s ", testEmail), Utils.checkEmailForValidity(testEmail), Is.is(true));
    }
    @Test
    public void testIspasswordValid() {
        String testEmail = "dHada#191";
        Assert.assertThat(String.format("Email id valid %s ", testEmail), Utils.checkPasswordForValidity(testEmail), Is.is(true));
    }
}