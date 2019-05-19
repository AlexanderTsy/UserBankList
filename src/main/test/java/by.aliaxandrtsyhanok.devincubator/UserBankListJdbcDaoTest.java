package by.aliaxandrtsyhanok.devincubator;

import org.junit.Assert;
import org.junit.Test;

import java.sql.SQLException;
import java.util.List;


public class UserBankListJdbcDaoTest {

    @Test
    public void getUserByUserid() throws SQLException, ClassNotFoundException {
        int userid;
        User user;
        userid = 1;
        user = UserBankListJdbcDao.getUserByUserid(userid);
        Assert.assertEquals(user.getUserid(), userid);
    }

    @Test
    public void getAllAccounts() throws SQLException, ClassNotFoundException {
        List<Account> accounts;
        accounts = UserBankListJdbcDao.getAllAccounts();
        Assert.assertNotNull(accounts);
    }
}