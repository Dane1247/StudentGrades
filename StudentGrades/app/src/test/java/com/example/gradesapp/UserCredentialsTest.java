package com.example.gradesapp;

import org.junit.Test;
import static org.junit.Assert.*;

public class UserCredentialsTest {

    @Test
    public void passwordMatchesTest(){
        UserCredentials cred = new UserCredentials("username", "password", "passwork");
        assertFalse(cred.passwordMatches());
        cred = new UserCredentials("username", "password", "password");
        assertTrue(cred.passwordMatches());
    }
}
