/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bank.database;
import java.sql.* ;
/**
 *
 * @author sanjay_mac
 */
public class BankDatabase 
  {
    /**
         * @param args the command line arguments
         */

    public static void main(String[] args) throws SQLException, ClassNotFoundException 
    {

      Class.forName("com.mysql.cj.jdbc.Driver");
      System.out.println("Driver loaded");

      Connection con;
      con = DriverManager.getConnection("jdbc:mysql://localhost:3306/", "root", "Sanjay925");
      System.out.println("Database connected");

      Statement customer = con.createStatement();
      Statement account = con.createStatement();
      Statement customer_number = con.createStatement();
      Statement loan = con.createStatement();
      Statement c_takes_l = con.createStatement();
      Statement payment_plan = con.createStatement();
      Statement due_date = con.createStatement();

      //creating database and using it
      customer.executeUpdate("CREATE DATABASE bank");
      customer.executeUpdate("USE bank");

      //creating tables
      customer.executeUpdate("CREATE TABLE customer(customer_id int, first_name, varchar(20), middle_initial varchar(1), last_name varchar(20), address varchar(60), PRIMARY KEY(customer_id))");
      //Customer
      customer.executeUpdate("insert into customer values(100091, 'Mona', 'H', 'Mumm', '1 Onsgard Avenue ');");
      customer.executeUpdate("insert into customer values (100092, 'Conrade', 'J', 'Easby', '5311 Goodland Road ');");
      customer.executeUpdate("insert into customer values (100093, 'Gordie', 'K', 'Guyonnet', '28 Jenna Road ');");
      customer.executeUpdate("insert into customer values (100094, 'Lorne', 'L', 'Murrey', '2 Bartillon Circle ');");
      customer.executeUpdate("insert into customer values (100095, 'Georges', 'U', 'Iveson', '878 Cherokee Terrace ');");
      customer.executeUpdate("insert into customer values (100096, 'Darby', 'Y', 'Hallaways', '01630 Haas Street'); ");
      customer.executeUpdate("insert into customer values (100097, 'Ilyssa', 'E', 'Flowers', '7106 Del Mar Crossing ');");
      customer.executeUpdate("insert into customer values (100098, 'Tedman', 'A', 'Batson', '7 Erie Point ');");
      customer.executeUpdate("insert into customer values (100099, 'Thedrick', 'P', 'Gorwood', '597 Erie Court'); ");
      customer.executeUpdate("insert into customer values (100100, 'Frank', 'O', 'Hallede', '4 Rieder Alley ');");
      ResultSet customerList = customer.executeQuery("SELECT * FROM customer;");

      account.executeUpdate("CREATE TABLE account(account_id int, amount decimal(10,2), customer_id int, PRIMARY KEY(account_id), FOREIGN KEY(customer_id) REFERENCES customer(customer_id) on delete cascade)");
      //Account
      account.executeUpdate("insert into account values (3574977, '174549.44', 100091);");
      account.executeUpdate("insert into account values (3586603, '2087634.58', 100091);");
      account.executeUpdate("insert into account values (3718097, '761702.09', 100093);");
      account.executeUpdate("insert into account values (5893556, '2822827.42', 100092);");
      account.executeUpdate("insert into account values (5315951, '133577.52', 100097);");
      account.executeUpdate("insert into account values (3536561, '1465249.05', 100094);");
      account.executeUpdate("insert into account values (6331103, '2754743.81', 100095);");
      account.executeUpdate("insert into account values (3044257, '2308965.07', 100096);");
      account.executeUpdate("insert into account values (3539426, '503504.77', 100097);");
      account.executeUpdate("insert into account values (6761864, '892313.82', 100098);");
      account.executeUpdate("insert into account values (3456603, '27344.09', 100099);");
      account.executeUpdate("insert into account values (1233335, '4754743.17', 100099);");
      account.executeUpdate("insert into account values (0900032, '4713.41', 100100);");
      ResultSet accountList = account.executeQuery("SELECT * FROM account;");

      customer_number.executeUpdate("CREATE TABLE customer_number(customer_id int, phone_number varchar(20), FOREIGN KEY(customer_id) REFERENCES customer(customer_id) on delete cascade)");
      //Customer_Number

      customer_number.executeUpdate("insert into customer_number values (100091, '183-184-0644 ');");
      customer_number.executeUpdate("insert into customer_number values (100092, '624-568-4230 ');");
      customer_number.executeUpdate("insert into customer_number values (100093, '646-584-4568 ');");
      customer_number.executeUpdate("insert into customer_number values (100094, '646-486-0238 ');");
      customer_number.executeUpdate("insert into customer_number values (100095, '718-300-5749 ');");
      customer_number.executeUpdate("insert into customer_number values (100096, '713-880-3948 ');");
      customer_number.executeUpdate("insert into customer_number values (100097, '917-480-3485 ');");
      customer_number.executeUpdate("insert into customer_number values (100098, '917-288-9844 ');");
      customer_number.executeUpdate("insert into customer_number values (100099, '713-181-3624 ');");
      customer_number.executeUpdate("insert into customer_number values (100100, '713-982-4982 ');");
      customer_number.executeUpdate("insert into customer_number values (100094, '917-003-4545 ');");
      customer_number.executeUpdate("insert into customer_number values (100098, '646-900-5555 ');");
      ResultSet customer_numberList = customer_number.executeQuery("SELECT * FROM customer_number;");

      loan.executeUpdate("CREATE TABLE loan(loan_id int, type varchar(70), loan_amount decimal(10, 2), PRIMARY KEY(loan_id))");
      loan.executeUpdate("insert into loan values (003570977, 'Home Equity Personal Loan' , '1000000.23');");
      loan.executeUpdate("insert into loan values (003588603, 'Short-Term Personal Loan' , '5000.99');");
      loan.executeUpdate("insert into loan values (003717097, 'Military Payday Loan' , '90004500.34');");
      loan.executeUpdate("insert into loan values (005896556, 'Second-Chance Personal Loan' , '677770.23');");
      loan.executeUpdate("insert into loan values (005315951, 'VA Loan' , '50000.30');");
      loan.executeUpdate("insert into loan values (003534561, 'Conventional Loan' , '3000.00');");
      loan.executeUpdate("insert into loan values (006351103, 'No Credit/Bad Credit Personal Loan ' , '99900.34 ');");
      loan.executeUpdate("insert into loan values (003094257, 'Fast Cash-Advance Loan' , '54000.34');");
      loan.executeUpdate("insert into loan values (003889426, 'Home Equity Line of Credit' , '110000.00');");
      loan.executeUpdate("insert into loan values (006781864, 'Auto Loan' , '32960.55');");
      ResultSet loanList = loan.executeQuery("SELECT * FROM loan;");

      c_takes_l.executeUpdate("CREATE TABLE c_takes_l(customer_id int, loan_id int, FOREIGN KEY(customer_id) REFERENCES customer(customer_id) on delete cascade)");
      c_takes_l.executeUpdate("insert into c_takes_l values (100091, 003570977);");
      c_takes_l.executeUpdate("insert into c_takes_l values (100092, 003588603);");
      c_takes_l.executeUpdate("insert into c_takes_l values (100093, 003717097);");
      c_takes_l.executeUpdate("insert into c_takes_l values (100094, 005896556);");
      c_takes_l.executeUpdate("insert into c_takes_l values (100095, 005315951);");
      c_takes_l.executeUpdate("insert into c_takes_l values (100096, 003534561);");
      c_takes_l.executeUpdate("insert into c_takes_l values (100097, 006351103);");
      c_takes_l.executeUpdate("insert into c_takes_l values (100098, 003094257);");
      c_takes_l.executeUpdate("insert into c_takes_l values (100099, 003889426);");
      c_takes_l.executeUpdate("insert into c_takes_l values (100100, 006781864);");
      ResultSet c_takes_lList = c_takes_l.executeQuery("SELECT * FROM c_takes_l;");

      payment_plan.executeUpdate("CREATE TABLE payment_plan(loan_id int, plan_number int, amount_owed_remaining decimal(10, 2), PRIMARY KEY(loan_id, plan_number), FOREIGN KEY(loan_id) REFERENCES loan(loan_id) on delete cascade)");
      payment_plan.executeUpdate("insert into payment_plan values (003570977, 1, '10000.53');");
      payment_plan.executeUpdate("insert into payment_plan values (003588603, 2, '4900.69');");
      payment_plan.executeUpdate("insert into payment_plan values (003717097, 3, '80204500.54');");
      payment_plan.executeUpdate("insert into payment_plan values (005896556, 4, '579770.43');");
      payment_plan.executeUpdate("insert into payment_plan values (005315951, 7, '31635.47');");
      payment_plan.executeUpdate("insert into payment_plan values (003534561, 7, '1200.20');");
      payment_plan.executeUpdate("insert into payment_plan values (006351103, 8, '160.44');");
      payment_plan.executeUpdate("insert into payment_plan values (003094257, 9, '5600.35');");
      payment_plan.executeUpdate("insert into payment_plan values (003889426, 1, '1098.40');");
      payment_plan.executeUpdate("insert into payment_plan values (006781864, 10, '144.05');");
      ResultSet payment_planList = payment_plan.executeQuery("SELECT * FROM payment_plan;");

      due_date.executeUpdate("CREATE TABLE due_date(plan_number int, due_date date, PRIMARY KEY(plan_number))");

      due_date.executeUpdate("insert into due_date values (1, '2020-01-01');");
      due_date.executeUpdate("insert into due_date values (2, '2021-09-21');");
      due_date.executeUpdate("insert into due_date values (3, '2019-04-19');");
      due_date.executeUpdate("insert into due_date values (4, '2025-11-21');");
      due_date.executeUpdate("insert into due_date values (7, '2025-02-10');");
      due_date.executeUpdate("insert into due_date values (8, '2024-02-07');");
      due_date.executeUpdate("insert into due_date values (9, '2023-09-24');");
      due_date.executeUpdate("insert into due_date values (10, '2039-10-10');");
      ResultSet due_dateList = due_date.executeQuery("SELECT * FROM due_date;");

      java.util.Scanner input = new java.util.Scanner(System. in );

      int count = 1;
      int choice = 0;

      do {
        System.out.println(" ");
        System.out.println(" ");
        System.out.println("1. Change Address.");
        System.out.println("2. Close all your Accounts.");
        System.out.println("3. Open an Account.");
        System.out.println("4. Amount Remaining on Loan and Final Due Date.");
        System.out.println("5. Exit.");
        choice = input.nextInt();

        while (choice < 1 || choice > 5) {
          System.out.println("Error. Please enter a number between 1 and 5.");
          choice = input.nextInt();
        }

        customerList.beforeFirst();
        accountList.beforeFirst();
        customer_numberList.beforeFirst();
        loanList.beforeFirst();
        c_takes_lList.beforeFirst();
        payment_planList.beforeFirst();
        due_dateList.beforeFirst();
        boolean c_flag = false;
        boolean a_flag = false;

        if (choice == 1) {
          System.out.print("Please enter customer ID: ");
          int c_id = input.nextInt();

          while (customerList.next()) {
            if (customerList.getInt(1) == c_id) {
              c_flag = true;

              System.out.print("Enter new address: ");
              input.nextLine();
              String s = input.nextLine();
              String e = "update customer set address = (?) where customer_id = (?);";
              PreparedStatement f = con.prepareStatement(e);
              f.setString(1, s);
              f.setDouble(2, c_id);
              f.executeUpdate();
              customerList = customer.executeQuery("SELECT * FROM customer;");

              break;

            }
          }
          if (!c_flag) {
            System.out.print("Customer ID does not exist in database.");
          }

        } else if (choice == 2) {
          customerList = customer.executeQuery("SELECT * FROM customer;");
          c_flag = false;
          a_flag = false;
          System.out.print("Please enter your customer ID: ");
          int c_id = input.nextInt();

          while (customerList.next()) {
            if (customerList.getInt(1) == c_id) {
              c_flag = true;
              String y = "delete from customer where customer_id = (?);";
              PreparedStatement w = con.prepareStatement(y);
              w.setInt(1, c_id);
              w.executeUpdate();
              customerList = customer.executeQuery("SELECT * FROM customer;");

              System.out.print("Successful. All accounts under you name have been closed.\n");
            }
          }
          if (!c_flag) {
            System.out.print("Customer ID does not exist in database.");
          }
        } else if (choice == 3) {
          System.out.print("Welcome, to create an account please fill out the information below.\n ");
          System.out.print("First Name: ");
          String firstn = input.next();
          System.out.print("Middle Initial: ");
          String middlei = input.next();
          System.out.print("Last Name: ");
          String lastn = input.next();
          System.out.print("Address: ");
          String address = input.next();
          String query = "insert into customer values (?,?,?,?,?)";
          PreparedStatement o = con.prepareStatement(query);
          o.setInt(1, 100100 + count);
          o.setString(2, firstn);
          o.setString(3, middlei);
          o.setString(4, lastn);
          o.setString(5, address);
          o.executeUpdate();
          customerList = customer.executeQuery("SELECT * FROM customer;");
          String qy = "insert into account values (?,?,?)";
          PreparedStatement qw = con.prepareStatement(qy);
          qw.setInt(1, (6761864 + (count * 4)));
          qw.setDouble(2, 0.00);
          qw.setInt(3, 100100 + count);
          qw.executeUpdate();
          accountList = account.executeQuery("SELECT * FROM account;");
          PreparedStatement t = con.prepareStatement("select * from customer join account using(customer_id) where customer_id = '" + (100100 + count) + "';");
          ResultSet data = t.executeQuery();
          while (data.next()) {
            System.out.print("Successfully Created Account. \n");
            System.out.print("Customer ID: " + data.getObject("customer_id") + "\n");
            System.out.print("Account ID: " + data.getObject("account_id") + "\n");
            System.out.print("Current Balance: " + data.getObject("amount") + "\n");

          }
          count += 1;

        }
        else if (choice == 4) {
          c_flag = false;
          a_flag = false;
          System.out.print("Please enter your customer ID: ");
          int c_id = input.nextInt();

          while (customerList.next()) {
            if (customerList.getInt(1) == c_id) {
              c_flag = true;
              payment_plan.executeUpdate("create view Amount_date as select amount_owed_remaining, due_date from(c_takes_l natural join payment_plan), due_date where payment_plan.plan_number = due_date.plan_number and customer_id = '" + c_id + "';");
              PreparedStatement p = con.prepareStatement("select * from Amount_date;");
              ResultSet data = p.executeQuery();
              while (data.next()) {
                System.out.print("Amount Remaining on Loan: " + data.getObject("amount_owed_remaining") + "\n");
                System.out.print("Due Date: " + data.getObject("due_date") + "\n");
              }
              System.out.print("Successful.");
              payment_planList = payment_plan.executeQuery("SELECT * FROM payment_plan;");
            }
          }
          if (!c_flag) {
            System.out.print("Customer ID does not exist in database.");
          }

        }
      }
      while ( choice != 5 );
      System.out.print("Program Exited.");
      con.close();
    }
  }