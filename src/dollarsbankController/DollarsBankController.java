package dollarsbankController;

import dollarsBankConsoleView.AccountCreate;
import dollarsBankConsoleView.LoginMenu;
import dollarsBankConsoleView.LoginPage;
import dollarsbankModel.Customer;
import dollarsbankModel.CustomerServices;
import java.util.ArrayList;
import java.util.Iterator;


public class DollarsBankController {

    ArrayList customers = new ArrayList();
    CustomerServices cs = new CustomerServices();

    //start the app with LoginMenu page and load data into customers.
    public void starter(){
        fetchLoginMenu();
        customers = cs.getCustomers();
    }

//    public Customer getCustomer(String id){
//        Customer customer = new Customer();
//        return customer;
//    }

    public void fetchLoginMenu(){
        LoginMenu lm = new LoginMenu();
        while (lm.welcome_page() != 3) {
            lm.welcome_page();
        }
    }

    public void fetchAccountCreate(){
        AccountCreate ac = new AccountCreate(cs);
        ac.deserializeCustomer();
    }

    public void fetchLoginPage(){
        LoginPage lp = new LoginPage();
        int returnValue = lp.login_page();
        if(returnValue ==1){
            fetchLoginPage();
        }
        else{
            fetchLoginMenu();
        }
    }


}


