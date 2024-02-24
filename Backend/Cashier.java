  /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projectphase1;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import java.util.ArrayList;
import java.util.Scanner;


/**
 *
 * @author Adoumy 
 */
public class Cashier extends User
{
    public String cashierUserName;
    public String CashierUserType;
    public String CartFilePath = "Cart.txt" ;
    public String CashierPassword;   
    public String CashierConfirmPassword;

    public ArrayList <Products> cartProducts; //retrieve from Class product
    static public ArrayList<Cashier> CashiersDataList; // Add cashiers should be in class admin 
    public ArrayList<Cashier> CashiersDataList2;
    public ArrayList<Cart> UserCart; 
    String cashierFileName="cashierData.txt";

    public String getCashierPassword() {
        return CashierPassword;
    }

    public void setCashierPassword(String CashierPassword) {
        this.CashierPassword = CashierPassword;
    }

    public String getCashierConfirmPassword() {
        return CashierConfirmPassword;
    }

    public void setCashierConfirmPassword(String CashierConfirmPassword) {
        this.CashierConfirmPassword = CashierConfirmPassword;
    }
   
    static public ArrayList<Cashier> getCashiersDataList(){
        return CashiersDataList;
    }

    public static void setCashiersDataList(ArrayList<Cashier> CashiersDataList) {
        Cashier.CashiersDataList = CashiersDataList;
    }

    
    
    
    public Cashier(){}
    
    public Cashier(String username,String usertype, String CashierPassword ) 
    {
        this.cashierUserName = username;
        this.CashierUserType = usertype;
        this.CashierPassword=CashierPassword;
    }

    
    @Override
    public void createFile() 
    {
           try
           {
             File userDataFile=new File (cashierFileName);
             if(userDataFile.createNewFile())
             {
             System.out.println("File created succefully!");
             
             }
             else 
             {
               System.out.println("File already exists");             
             }
         }
         catch(IOException e)
         {
         System.out.println("File is not created"+e.getMessage());
         }
    }
    
    
    @Override
    public void readFromFile() 
    {
         try (BufferedReader reader = new BufferedReader(new FileReader(cashierFileName)))
         {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(" ");

                if (parts.length == 3) {
                    String userNamed = parts[0];
                    String userTyped = parts[1];
                    String passwordd= parts[2];
                      
                      
                    // Create a new User object and add it to  userDataList(arraylist)
                    Cashier cash11 = new Cashier(userNamed, userTyped, passwordd);
                    this.CashiersDataList2.add(cash11);
                    Cashier.CashiersDataList=CashiersDataList2;
                } else {
                    System.out.println("Invalid data format in the file.");
                }
            }

            System.out.println("User data read from file into arraylist successfully.");
        } catch (IOException e) {
            System.out.println("Error reading from file: " + e);
        }   
    }
    
    
    
    

    @Override
    public void writeToFile() {

       try (FileWriter writer = new FileWriter ("adminData.txt"))
       {
           //looping through the  arraylist 
        for (Cashier c: CashiersDataList) 
        {
            //writing its contents on a file
            writer.write(c.cashierUserName+" "+c.CashierUserType+" "+c.getCashierPassword()+"\n");

        }
        System.out.println("User data saved to file successfully.");
    } catch (IOException e)
    {
       System.out.println(e);
    
            }
    }

         
    

    
    @Override
public boolean checkUserData(String userName, String userType, String password) {
    for (Cashier  c : CashiersDataList) {
        if (c.cashierUserName.equals(userName) && c.CashierUserType.equals(userType) && c.getCashierPassword().equals(password)) {
            return true;
        }
    }
    return false;
}


//user name repetiotion in the same file 
  @Override
    public boolean checkUserName(String userName)
    {
            for (Cashier  c : CashiersDataList) 
            {
               if( c.cashierUserName.equals(userName))
               return true;
            }
            return false;

    }


@Override
public boolean logIn() {
    Scanner userInput2 = new Scanner(System.in);
    System.out.println("Enter user name: ");
    this.cashierUserName = userInput2.next(); 
    System.out.println("Enter user type: ");
    this.CashierUserType = userInput2.next();  
    System.out.println("Enter password: ");
    setCashierPassword(userInput2.next()); 
        return checkUserData(this.cashierUserName, this.CashierUserType, getCashierPassword());
}


@Override
public void signUp()
    {
        Scanner userInput3 = new Scanner(System.in);

        while (true) {
            System.out.println("Enter user name:");
            cashierUserName = userInput3.next();

            if (checkUserName(cashierUserName)) {
                System.out.println("Already registered user name, try another one");
            } else {
                break; // Exit the loop if the user name is not already registered
            }
        }

        System.out.println("Enter user type:");
        CashierUserType = userInput3.next();

        System.out.println("Enter password:");
        setCashierPassword(userInput3.next());

        System.out.println("Confirm password: ");
        setCashierConfirmPassword(userInput3.next());

        if (getCashierConfirmPassword().equals(getCashierPassword())) {
            Cashier currentCashier = new Cashier(cashierUserName, CashierUserType, getCashierPassword());
            CashiersDataList.add(currentCashier);
            System.out.println("Registered successfully!");
        } else {
            System.out.println("Confirmation doesn't match password, try again ");
            signUp();
        }
    
    
    }
public void createCart() {
         try
           {
             File CartDataFile=new File (CartFilePath);
             if(CartDataFile.createNewFile())
             {
             System.out.println("File created succefully!");
             
             }
             else 
             {
               System.out.println("File already exists");             
             }
         }
         catch(IOException e)
         {
         System.out.println("File is not created"+e.getMessage());
         }
        
    }

   
     public ArrayList<Products> AllProducts=Products.productsDataList;
    public void addProductToCart(String ProductName)
    { 
          for(Products p1 : Products.productsDataList)
          {
             if(p1.productName.equals(ProductName)){
                 cartProducts.add(p1);
             }
             else{
             System.out.println("Product Not Found ");
             }
          }
    }

    public void removeProductFromCart(String ProductName) {
         for(Products p2:AllProducts){
             if(p2.productName.equals(ProductName)){
                 cartProducts.remove(p2);
             }
             else{
             System.out.println("Product Not Found ");
             }
          }
     
    }
//    public void calculatePayment() {
//        
//        Path cartFilePath = Path.of(userName + "Cart");
//        try {
//            String cartContent = Files.readString(cartFilePath);
//            int totalProducts = cartContent.length();
//            System.out.println("Total products in the cart: " + totalProducts);
//            
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }

    public void deleteCart() {
         cartProducts.clear();
    }

    public void displayCarts() {
        if (cartProducts == null) {
            cartProducts = new ArrayList<>(); 
        }
        if (cartProducts.isEmpty()) {
            System.out.println("The cart is empty.");
        } else {
            System.out.println("Products in the cart:");
            for (Products p : cartProducts) {
                System.out.println("- " + p.productName);
            }
        }
    }    

}
