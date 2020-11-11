# Bank-Database

Created by Sanjay Sewbhajan

Database is a Bank Database where there is a customer table that contains the customer’s ID, first name,
middle initial, last name, and address. It also contains a account table which contains the
account’s ID, amount in the account. The database contains a separate table for phone
numbers because the attribute can be multivalued. A loan table is included containing the loan’s
ID, type of loan, amount of the loan. In order to connect a loan with a customer I created a
separate table labeled c_takes_l for the sole purpose of telling us what customer took which
loan. Each loan comes a choice of payment plans; the payment plan table contains the plan
number and the amount remaining left to be paid back for the loan. The payment plan also is
connected to a due date attribute telling us which day the payment is due. The menu contains 5
options which the user can choose from. The first option is to modify the customer table to
change their current address. The creation of this option gave me trouble because of the
getLine and scanner within java as I will explain below. The second option is deleting all
accounts related to the user, the customer will provide us with his/her ID and then their data in
the database will delete throughout. The third option is to open a new account the customer will
provide their first name, middle initial, last name, and address, the customer_id will be created
for them. After creating the customer entry into the database, a new account is opened for then
containing zero dollars by using their newly created customer ID. The fourth option is viewing
the user’s loan information. I created a view combining two tables to get the amount remaining
the user must pay and the final due date. Finally, the fifth option is simply to exit the menu. 

**Difficulties:**
The overall project was not very difficult it was straightforward and easy to understand. The only
problem I faced was the implementation of MySQL to Java. I was very new to Java, so the
codes and phrases were really hard to grasp. The concept and logic still remained the same as
other programming languages however, learning the code and making simple mistakes in the
syntax for Java was really time consuming and difficult. After time, I got familiar with the syntax
and the code ran smoothly. Another speed bump in Java that slow me down was when I trying
to collect a full string using getLine and a scanner. The problem was that getLine used an \n
when collecting the line. So, to counter that I collected the \n first with another getLine then I
was able to collect the rest of the string.

**Learned:**
I learn to utilize Java much better, I understand the basic fundamentals that will help me next
semester in object-oriented programming. I also learned how easily java can connect to other
software with connectors. When I follow the steps of forming an ER-diagram, then convert it to a
schema, and finally implement it into code it is much simpler to visualize and understand. 

**Next Steps:** 
+ Update GUI 
+ Expand Database
