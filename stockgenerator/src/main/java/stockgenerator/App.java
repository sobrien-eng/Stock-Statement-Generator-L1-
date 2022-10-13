package stockgenerator;

import java.io.*;
import java.util.*;
import org.json.simple.*;
import org.json.simple.parser.*;

public final class App {
    private App() {
    }
    public static void main(String[] args) {
        System.out.println("Hello World!");
    }
}
    // current date, read account holder's full name, ssn, email address, phone, and account number at the top
    //transactions: buy/sell, stock symbol, price per share, number of shares bought or sold, total amount of transaction 
    //total cash , total stock value 
    //cashStart = beginning_balance, sotckStart = 0
    //transaction ($ for each buy (-) or sell (+)) = totalValue = numberofshares * shareprice
    //loop through each trade for transactions then +- cash start and +- stock start