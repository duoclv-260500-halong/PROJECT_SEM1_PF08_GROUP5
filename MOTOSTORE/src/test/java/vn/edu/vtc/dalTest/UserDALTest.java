package vn.edu.vtc.dalTest;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

import vn.edu.vtc.dal.UserDAL;
import vn.edu.vtc.persistance.User;

public class UserDALTest {
    @Test
    public void testLogin1() {
        UserDAL userDAL = new UserDAL();
        try {
            User user = userDAL.checkUser("dongduclan", "680e07d8a4d196db69674a23a89b2185");
            String[] result = { user.getUsername(), user.getPassword() };
            String[] expected = { "dongduclan", "680e07d8a4d196db69674a23a89b2185" };
            assertTrue(Arrays.equals(result, expected));
        } catch (Exception e) {
        }
    }

    @Test
    public void testLogin2() {
        try {
            UserDAL userDAL = new UserDAL();

            User user1 = userDAL.checkUser("dongducla", ("680e07d8a4d196db69674a23a89b2185"));
            assertNull(user1);
        } catch (Exception e) {

        }

    }

    @Test
    public void testLogin3() {
        try {
            UserDAL userDAL = new UserDAL();

            User user1 = userDAL.checkUser("dongduclan", "680e07d8a4d196db69674a23a89b2184");
            Assert.assertNull(user1);
        } catch (Exception e) {

        }

    }

    @Test
    public void testLogin4() {
        try {
            UserDAL userDAL = new UserDAL();
            User user1 = userDAL.checkUser("", "680e07d8a4d196db69674a23a89b218");
            Assert.assertNull(user1);
        } catch (Exception e) {

        }

    }

    @Test
    public void testLogin5() {
        try {
            UserDAL userDAL = new UserDAL();

            User user1 = userDAL.checkUser("dongduclan", "");
            Assert.assertNull(user1);
        } catch (Exception e) {

        }

    }

    @Test
    public void testLogin6() {
        try {
            UserDAL userDAL = new UserDAL();

            User user1 = userDAL.checkUser("", "");
            Assert.assertNull(user1);
        } catch (Exception e) {

        }

    }
}