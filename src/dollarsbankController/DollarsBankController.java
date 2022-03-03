package dollarsbankController;

import dollarsBankConsoleView.AccountCreate;
import dollarsBankConsoleView.LoginMenu;
import dollarsBankConsoleView.LoginPage;
import dollarsbankModel.Customer;
import dollarsbankModel.CustomerServices;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;


public class DollarsBankController {

    // Created variables within controller class
    ArrayList customers = new ArrayList();
    CustomerServices cs = new CustomerServices();

    //start the app with LoginMenu page and load data into customers.
    public void starter() throws IOException {
        fetchLoginMenu();
        customers = cs.getCustomers();
    }

//    public Customer getCustomer(String id){
//        Customer customer = new Customer();
//        return customer;
//    }

    // starting login menu allowing the user to login
    // or create account - directing them to view
    public void fetchLoginMenu() throws IOException {
        LoginMenu lm = new LoginMenu();
        while (lm.welcome_page() != 3) {
            if(lm.getSelectionNumber() == 1){
                fetchAccountCreate();
            }
            else if(lm.getSelectionNumber() ==2){
                fetchLoginPage();
            }
        }
    }

    // allows transition into accountCreate,
    // passing customer services object as property
    public void fetchAccountCreate() throws IOException {
        AccountCreate ac = new AccountCreate(cs);
        Customer customer = ac.deserializeCustomer();

        // Code doesn't work at the moment.
//        cs.AddCustomerToArrayList(customer);
//
//        //add exception handling
//        cs.SaveCustomersToJson();
//        //repopulate array
//        this.customers = cs.getCustomers();
    }

    // allows user to transition login page
    // pass customer services object as property
    public void fetchLoginPage() throws IOException {
        LoginPage lp = new LoginPage(cs);
        int returnValue = lp.login_page();
        if(returnValue ==1){
            fetchLoginPage();
        }
        else{
            fetchLoginMenu();
        }
    }


}


