package vn.edu.vtc.blTest;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;

import org.junit.Test;

import vn.edu.vtc.bl.Md5;

public class Md5Test {
    @Test
    public void testMd51_1() {
        try {
            Md5 md5 = new Md5();
            String[] result = {md5.getMd5("Alo123456@")};
            String[] expected = {"680e07d8a4d196db69674a23a89b2185"};
            assertTrue(Arrays.equals(result, expected));
        } catch (Exception e) {
            
        }
    }
    @Test
    public void testMd51_2() {
        try {
            Md5 md5 = new Md5();
            String[] result = {md5.getMd5("Alo123455@")};
            String[] expected = {"680e07d8a4d196db69674a23a89b2185"};
            assertFalse(Arrays.equals(result, expected));
        } catch (Exception e) {
            
        }
    }
}