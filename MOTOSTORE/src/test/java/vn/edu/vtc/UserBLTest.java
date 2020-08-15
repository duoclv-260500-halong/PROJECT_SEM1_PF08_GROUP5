package vn.edu.vtc;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;


import org.junit.Test;

import vn.edu.vtc.bl.UserBL;
import vn.edu.vtc.persitance.User;

public class UserBLTest {
    @Test
    public void testUserBL1() {
        UserBL userBL = new UserBL();
        try {
            User user = new User();
            user = userBL.getUser("dongduclan", "Alo123456@");
            String[] result = {user.getUsername(), user.getPassword()};
            String[] expected = {"dongduclan", "680e07d8a4d196db69674a23a89b2185"};
            assertTrue(Arrays.equals(result, expected));
        } catch (Exception e) {
            
        }
    }
    @Test
    public void testUserBL2() {
        UserBL userBL = new UserBL(); 
        try {
            User user = new User();
            user = userBL.getUser("dongduclan", "Alo12345@");
            String[] result = {user.getUsername(), user.getPassword()};
            String[] expected = {"dongduclan", "680e07d8a4d196db69674a23a89b2185"};
            assertFalse(Arrays.equals(result, expected));
        } catch (Exception e) {
            
        }
    }
}