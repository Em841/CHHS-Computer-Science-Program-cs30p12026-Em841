/*
 * Program:BreakAplate
 * Purpose:User can make account either a personal or business. 
 *  Each should check the balance after every transaction and apply the fee if needed. The base Account class already had balance, customer info, deposit, withdrawal, 
 *  and address change methods.
 * Author: Eman Abid
 * School:CHHS
 * Course: CSE 3130 Object-Oriented Programming 2
  */
package Mastery;
import java.util.Scanner;


public class TestAccount {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);


        System.out.println(" CREATE ACCOUNT ");
        System.out.print("Type (P)ersonal or (B)usiness: ");
        String type = sc.nextLine();


        System.out.print("First name: ");
        String first = sc.nextLine();
        System.out.print("Last name: ");
        String last = sc.nextLine();
        System.out.print("Street: ");
        String street = sc.nextLine();
        System.out.print("City: ");
        String city = sc.nextLine();
        System.out.print("Province: ");
        String prov = sc.nextLine();
        System.out.print("Postal code: ");
        String postal = sc.nextLine();
        System.out.print("Starting balance: ");
        double bal = sc.nextDouble();
        sc.nextLine();


        if (type.equalsIgnoreCase("P")) {
            PersoalAcct acc = new PersoalAcct(bal, first, last, street, city, prov, postal);
            System.out.println("\n--- ACCOUNT CREATED ---");
            System.out.println(acc.toStringPA());
            // Check & apply fee if balance below minimum
            System.out.println(acc.PersonalMinFee());


            System.out.print("\nWithdrawal amount: ");
            double wd = sc.nextDouble();
            acc.withdrawal(wd);
            System.out.println("After withdrawal, balance: $" + acc.getBalance());
            // Check fee again
            System.out.println(acc.PersonalMinFee());


        } else if (type.equalsIgnoreCase("B")) {
            BuisnessAcct acc = new BuisnessAcct(bal, first, last, street, city, prov, postal);
            System.out.println("\n--- ACCOUNT CREATED ---");
            System.out.println(acc.toStringBA());
            System.out.println(acc.PersonalMinFee());


            System.out.print("\nWithdrawal amount: ");
            double wd = sc.nextDouble();
            acc.withdrawal(wd);
            System.out.println("After withdrawal, balance: $" + acc.getBalance());
            System.out.println(acc.PersonalMinFee());
        }


        sc.close();
    }
}
/* CREATE ACCOUNT 
Type (P)ersonal or (B)usiness: p
First name: em
Last name: ab
Street: 10 ave
City: calgary
Province: canada
Postal code: tr3578
Starting balance: 98

--- ACCOUNT CREATED ---
eab
Account Holder's Name: em ab
Adress: 10 ave, calgary, canada, tr3578
Current balance is $98.00
Minimum Of 100Required In Account. 5Monthly Fee Applied.
Balance Is: 93.0

Withdrawal amount: 40
Not enough money in account.
After withdrawal, balance: $5.0
Minimum Of 100Required In Account. 5Monthly Fee Applied.
Balance Is: 0.0
 CREATE ACCOUNT 
Type (P)ersonal or (B)usiness: b
First name: er
Last name: w
Street: 278 ave
City: calgary
Province: alberta
Postal code: 34df3
Starting balance: 67

--- ACCOUNT CREATED ---
ew
Account Holder's Name: er w
Adress: 278 ave, calgary, alberta, 34df3
Current balance is $67.00
Minimum Of 100Required In Account. 10Monthly Fee Applied.
Balance Is: 57.0

Withdrawal amount: 10
After withdrawal, balance: $0.0
Minimum Of 100Required In Account. 10Monthly Fee Applied.
Balance Is: -10.0
 CREATE ACCOUNT 
Type (P)ersonal or (B)usiness: p
First name: er
Last name: re
Street: 23 er
City: abc
Province: cbc
Postal code: 2rfw3
Starting balance: 2000

--- ACCOUNT CREATED ---
ere
Account Holder's Name: er re
Adress: 23 er, abc, cbc, 2rfw3
Current balance is $2,000.00
There Is A Minimum Of 100 In The Account.

Withdrawal amount: 1000
After withdrawal, balance: $1000.0
There Is A Minimum Of 100 In The Account.
 CREATE ACCOUNT 
Type (P)ersonal or (B)usiness: b
First name: em
Last name: ab
Street: 12 ave
City: calgary
Province: rec
Postal code: qcw33
Starting balance: 900

--- ACCOUNT CREATED ---
eab
Account Holder's Name: em ab
Adress: 12 ave, calgary, rec, qcw33
Current balance is $900.00
There Is A Minimum Of 100 In The Account.

Withdrawal amount: 120
After withdrawal, balance: $780.0
There Is A Minimum Of 100 In The Account.


*/