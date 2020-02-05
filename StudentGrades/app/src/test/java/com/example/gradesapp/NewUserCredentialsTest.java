package com.example.gradesapp;

import org.junit.Test;
import static org.junit.Assert.*;

// Sean
public class NewUserCredentialsTest {


    // Sean
    private NewUserCredentials passwordMismatch;
    private NewUserCredentials usernameTaken;
    private NewUserCredentials emptyFields;
    private NewUserCredentials allFieldsEmpty;
    private NewUserCredentials nullFields;
    private NewUserCredentials allFieldsNull;

    // Sean
    public NewUserCredentialsTest(){
        super();
        this.passwordMismatch = new NewUserCredentials(
            "sean",
            "towne",
            "townesean",
            "password",
            "passwork"
        );

        this.usernameTaken = new NewUserCredentials(
            "sean",
            "towne",
            "usernametaken",
            "password",
            "password"
        );

        this.emptyFields = new NewUserCredentials(
            "",
            "towne",
            "townesean",
            "password",
            "password"
        );

        this.allFieldsEmpty = new NewUserCredentials(
            "",
            "",
            "",
            "",
            ""
        );

        this.nullFields = new NewUserCredentials(
            "sean",
            "towne",
            null,
            "password",
            null
        );

        this.allFieldsNull = new NewUserCredentials(
                null,
                null,
                null,
                null,
                null
        );
    }

    // Sean
    @Test
    public void passwordDoesntMatchTest(){
        assertFalse(this.passwordMismatch.passwordMatches());
    }

    // Sean
    @Test
    public void passwordDoesMatchTest(){
        assertTrue(this.usernameTaken.passwordMatches());
    }

    // Sean
    @Test
    public void missingFieldsTest(){
        assertTrue(this.emptyFields.missingFields());
        assertTrue(this.allFieldsEmpty.missingFields());
    }

    // Sean
    @Test
    public void nullFieldsTest(){
        assertTrue(this.nullFields.missingFields());
        assertTrue(this.allFieldsNull.missingFields());
    }
}
