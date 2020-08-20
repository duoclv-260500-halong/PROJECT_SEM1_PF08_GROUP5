package vn.edu.vtc.bl;

import vn.edu.vtc.dal.UserDAL;

import vn.edu.vtc.persitance.User;

public class UserBL {

    UserDAL userDAL = new UserDAL();
    Md5 md5 = new Md5();
    Validation valid = new Validation();
    public User getUser(String username, String password) {
        User user = new User();
        try {
            if(valid.isValidPassword(password) == false){
                return null;
            }
            user = userDAL.checkUser(username, md5.getMd5(password));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return user;
    }


}