package by.aliaxandrtsyhanok.devincubator;


import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

/**
 * Simple class that extends {@link HttpServlet}.
 *
 * @author Aliaxandr Tsyhanok
 */
public class UBLService extends HttpServlet {

    private String message;

    public void init(){

    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //O_o lives forever )))
        message = "Сообщение от UBLService";
        response.setContentType("text/html");
        PrintWriter messageWriter = response.getWriter();

        String requestQueryString;
        requestQueryString = request.getQueryString();

        if (requestQueryString == null || requestQueryString.isEmpty()){
            response.sendError(404,"UBLService query string is empty!");
            return;
        }

        User user;
        List<Account> accounts;
        Account richestUserAccount;

        try {
            //Find richest user and sends user's name and sureName
            if (requestQueryString.contains("richest_user")) {
                accounts = UserBankListJdbcDao.getAllAccounts();
                //sort descending by Account.getAccount
                accounts.sort((Account o1, Account o2)->-(o1.getAccount()-o2.getAccount()));
                richestUserAccount = accounts.get(1);
                user = UserBankListJdbcDao.getUserByUserid(richestUserAccount.getUserid());
                message=user.getName()+" "+user.getSureName();
            }
            //Sums all account.account and sends sum
            else if (requestQueryString.contains("accounts_sum")) {
                accounts = UserBankListJdbcDao.getAllAccounts();
                int sum=0;
                for (int i = 0; i < accounts.size(); i++) {
                    sum+=accounts.get(i).getAccount();
                }
                message = String.valueOf(sum);
            }
            //For other requests responses with 404
            else {
                response.sendError(404,"UBLService for \""+requestQueryString+"\" not found!");
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        messageWriter.println(message);
    }

    public void destroy() {
    }
}