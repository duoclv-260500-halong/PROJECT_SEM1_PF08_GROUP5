package vn.edu.vtc;

import static org.junit.Assert.assertTrue;


import java.util.Arrays;

import org.junit.Test;

import vn.edu.vtc.bl.Validation;

public class ValidationPassword {
    @Test
    public void testValid1() {
        try {
            Validation valid = new Validation();
            boolean[] result = {valid.isValidPassword("Alo123456@")};
            boolean[] expected = {true};
            assertTrue(Arrays.equals(result, expected));
        } catch (Exception e) {
        }
    }
    @Test
    public void testPassword2() {
        try {
            Validation valid = new Validation();
        boolean[] result = {valid.isValidPassword("Alo123456")};
        boolean[] expected = {false};
        assertTrue(Arrays.equals(result, expected));
        } catch (Exception e) {
            
        }
        
    }
    @Test
    public void testPassword3() {
        try {
            Validation valid = new Validation();
        boolean[] result = {valid.isValidPassword("alo123456@")};
        boolean[] expected = {false};
        assertTrue(Arrays.equals(result, expected));
        } catch (Exception e) {
            
        }
        
    }

    @Test
    public void testPassword4() {
        try {
            Validation valid = new Validation();
            boolean[] result = {valid.isValidPassword("ALOAAAA1@")};
            boolean[] expected = {false};
            assertTrue(Arrays.equals(result, expected));
        } catch (Exception e) {
            
        }
       
    }
    @Test
    public void testPassword5() {
        try {
            Validation valid = new Validation();
        boolean[] result = {valid.isValidPassword("ALOAAAAaa@")};
        boolean[] expected = {false};
        assertTrue(Arrays.equals(result, expected));
        } catch (Exception e) {
            
        }
        
    }
    @Test
    public void testPassword6() {
        try {
            Validation valid = new Validation();
            boolean[] result = {valid.isValidPassword("Alo1@")};
            boolean[] expected = {false};
            assertTrue(Arrays.equals(result, expected));
        } catch (Exception e) {
            
        }
       
    }
    @Test
    public void testPassword7() {
        try {
            Validation valid = new Validation();
            boolean[] result = {valid.isValidPassword("Alo123@Alo123@Alo123@Alo123@")};
            boolean[] expected = {false};
            assertTrue(Arrays.equals(result, expected));
        } catch (Exception e) {
            
        }
       
    }
}