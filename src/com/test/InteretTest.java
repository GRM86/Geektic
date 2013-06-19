package com.test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.mg.Interet;


public class InteretTest {

	@Test
    public void userTest() {
		Interet interet = new Interet("4","Langage");
        assertEquals("4", interet.getId());
        assertEquals("Langage", interet.getLibelle());
    }
}
