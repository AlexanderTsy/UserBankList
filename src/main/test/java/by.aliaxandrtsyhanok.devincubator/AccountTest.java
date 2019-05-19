package by.aliaxandrtsyhanok.devincubator;

import org.junit.*;


public class AccountTest {

    @Test
    public void getAccount() {
        Account account = new Account(1,100,1);
        int accountValue = account.getAccount();
        Assert.assertEquals(accountValue, 100);
    }

    @Test
    public void setAccount() {
        Account account = new Account(1,100,1);
        account.setAccount(200);
        int accountValue = account.getAccount();
        Assert.assertEquals(accountValue, 200);
    }

}
