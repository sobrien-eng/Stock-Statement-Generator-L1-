package stockgenerator;

import java.io.*;
import java.util.*;
import org.json.simple.*;
import org.json.simple.parser.*;
import java.text.SimpleDateFormat;

public final class App {
    private App() {
    }

    public static void main(String[] args) throws ParseException, FileNotFoundException, IOException {
        System.out.println("Hello World!");

            JSONParser parser = new JSONParser();
            // Use JSONObject for simple JSON and JSONArray for array of JSON.
            JSONArray data = (JSONArray) parser.parse(
                    new FileReader("C:/Users/Sabrina/Downloads/stockgendata.json"));// path to the JSON file.
            // System.out.println(data);

            SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
            Date date = new Date();
            for (int i = 0; i < data.size(); i++) {
                
    
                JSONObject jItem = (JSONObject) data.get(i);
                String firstName = (String) jItem.get("first_name");
                String lastName = (String) jItem.get("last_name");
                String name = firstName + " " + lastName;
                String ssn = (String) jItem.get("ssn");
                String email = (String) jItem.get("email");
                String phone = (String) jItem.get("phone");
                Long number = (Long) jItem.get("account_number");
                String accnum = Long.toString(number);
                JSONArray trades = (JSONArray) jItem.get("stock_trades");
                String beginbal = (String) jItem.get("beginning_balance");
                String begBal2 = beginbal.substring(1);
                Float cashStart = Float.parseFloat(begBal2);
                String person = "\n" + "\n" + name + " SSN: " + ssn + " Account Number: " + accnum + "\n" + "Email: " + email + "\n" + "Phone: " + phone + "\n" +
                formatter.format(date) + " Transctions:" + "\n";
            
                System.out.println(person);


                for (int j = 0; j < trades.size(); j++) {
                    JSONObject object = (JSONObject) trades.get(j);
                    String type = (String) object.get("type");
                    String symbol = (String) object.get("stock_symbol");
                    String pricepershare = (String) object.get("price_per_share");
                    Long shares = (Long) object.get("count_shares");
                    
      
                    //int stockStart = 0;
                   String newPrice = pricepershare.substring(1);
                   Float priceNum = Float.parseFloat(newPrice);
                  
                    Float total = priceNum * shares;
                    
                    for (int a = 0; a < trades.size(); a++) {
                        Float newNum = 0f;
                        if (type.equals("Sell")){
                             newNum = cashStart + total;
                        } else{
                          // newNum = cashStart - total;
                        }
                        //System.out.println(newNum);
                        
                    }
                   
                    
                    String transactions = type + " (" + symbol + ") " +  shares + " / " + pricepershare + " ea.";
                //     String oof = pricepershare + " " + shares;
                //     System.out.println(priceNum + " * " + shares + " = "+ total);
                System.out.println(transactions);
                }
            }
    
        } 
     
        
    }


