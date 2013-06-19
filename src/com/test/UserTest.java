package com.test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.mg.User;


public class UserTest {

	@Test
    public void userTest() {
		User user = new User("1","12","RODRIGO","Gabriel", "Duende","gab@rod.com", "H","1" );
        assertEquals("1", user.getId());
        assertEquals("Duende", user.getPseudo());
    }
}
