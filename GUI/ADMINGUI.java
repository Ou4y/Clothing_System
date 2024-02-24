/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package admingui;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.HBox;
/**
 *
 * @author mo
 */
public class ADMINGUI extends Application {
    
         /**
          * @param args the command line arguments
         */
         public static void main(String[] args) {
         launch(args);
         for(Cashier a:Cashier.CashiersDataList){
         System.out.println(a);
         }
         }

         @Override
         public void start(Stage primaryStage) throws Exception {
         //----------------------------------------------------------------------------------------
         Admin admin=new Admin("mohamed","admin","Mo200400");
         Products.productsDataList.add(new Products("Jeans",1200));
         Products.productsDataList.add(new Products("shoes",3000));
         Products.productsDataList.add(new Products("Tshirt",1150));
         Products.productsDataList.add(new Products("Slides",1400));
         Products.productsDataList.add(new Products("Hoodie",1900));
         
         
         Supplier sup1=new Supplier("ahmed","ahmed1234");
         Supplier.SupplierDataList.add(sup1);
         sup1.supplierProducts.add(new Products("Tshirt",300));
         sup1.supplierProducts.add(new Products("Shorts",450));
         sup1.supplierProducts.add(new Products("shoes",900));
         sup1.supplierProducts.add(new Products("Hoodie",600));
         sup1.supplierProducts.add(new Products("Cap",250));
         
         
         Supplier sup2=new Supplier("mahmoud","mahmoud1234");
         Supplier.SupplierDataList.add(sup2);
         sup2.supplierProducts.add(new Products("Hoodie",900));
         sup2.supplierProducts.add(new Products("shoes",1900));
         sup2.supplierProducts.add(new Products("Tshirt",750));
         sup2.supplierProducts.add(new Products("Slides",1000));
         sup2.supplierProducts.add(new Products("Hoodie",1200));


         Supplier sup3=new Supplier("hassan","hassan1234");
         Supplier.SupplierDataList.add(sup3);
         sup3.supplierProducts.add(new Products("Jeans",1200));
         sup3.supplierProducts.add(new Products("shoes",3000));
         sup3.supplierProducts.add(new Products("Tshirt",1150));
         sup3.supplierProducts.add(new Products("Slides",1400));
         sup3.supplierProducts.add(new Products("Hoodie",1900));
         
         
         Supplier sup4=new Supplier("adam","adam1234");
         Supplier.SupplierDataList.add(sup4);
         sup4.supplierProducts.add(new Products("Beanie",900));
         sup4.supplierProducts.add(new Products("shoes",4000));
         sup4.supplierProducts.add(new Products("Tshirt",2200));
         sup4.supplierProducts.add(new Products("Slides",1600));
         sup4.supplierProducts.add(new Products("Hoodie",1900));
         
         
         Supplier sup5=new Supplier("ali","ali1234");
         Supplier.SupplierDataList.add(sup5);
         sup5.supplierProducts.add(new Products("Tshirt",700));
         sup5.supplierProducts.add(new Products("Shorts",920));
         sup5.supplierProducts.add(new Products("shoes",1450));
         sup5.supplierProducts.add(new Products("Hoodie",1100));
         sup5.supplierProducts.add(new Products("Cap",460));
         //----------------------------------------------------------------------------------------
         primaryStage.setTitle("ADMIN");

         // Create a main VBox to hold the components and other layouts
         VBox mainvbox = new VBox();
         mainvbox.setSpacing(15);
         Insets AppInsets=new Insets(20,50,50,20);// Insets: top, right, bottom, left
         mainvbox.setPadding(AppInsets); 

         //------------------------------------------------------------------------------------------   
        
         // Welcome message
         StackPane welcomePane = new StackPane();
         Label test=new Label("welcome Admin");
         welcomePane.getChildren().add(test);
         mainvbox.getChildren().add(welcomePane);
         StackPane.setAlignment(test,Pos.CENTER);
        
         //-------------------------------------------------------------------------------------------
         // Panel for managing users or products
         VBox managePanel = new VBox(10);
         Button manageUsersButton = new Button("Manage Users");
         Button manageProductsButton = new Button("Manage Products");
         Button ManageSup=new Button("Manage Supplier");
         //-------------------------------------------------------------------------------------------
         Button Trends=new Button("Trends");
         //********************************************************************************************
         
         // Add buttons to manage panel
         managePanel.getChildren().addAll(manageUsersButton, manageProductsButton,ManageSup,Trends);
        
         // Add manage panel(VBox)to the main VBox
         mainvbox.getChildren().add(managePanel);
        
        
        
        
         // Create the scene
         Scene AdminSc = new Scene(mainvbox, 400, 300);
        
         // Set the stage scene
         primaryStage.setScene(AdminSc);

         // Show the stage
         primaryStage.show();
        
          //********************************************************************************************
          //                          Add User(Done) *Supplier*
     
         //add user button will show this stage (usename,usertype, password and confirm password fields)
         
         VBox Adduser=new VBox(15);
         //usename
         TextField UserName=new TextField();
         UserName.setPromptText("Example:Mo101");
        
         //group toggle HBox(for user type)
         HBox ToggleUserType=new HBox(10);
         Insets ToggleInsets=new Insets(5,5,5,35);
         ToggleUserType.setPadding(ToggleInsets);
         //-------------------------------------------------------------------------------------------  
         //toggle group (cashier,customer,supplier)
         ToggleGroup GroupUserTypeAdd = new ToggleGroup();
         RadioButton CustomerRadioAdd = new RadioButton("Customer"); 
         CustomerRadioAdd.setToggleGroup(GroupUserTypeAdd); 
         RadioButton CashierRadioAdd = new RadioButton("Cashier"); 
         CashierRadioAdd.setToggleGroup(GroupUserTypeAdd);
         RadioButton SupplierRadioAdd =new RadioButton("Supplier");
         ToggleUserType.getChildren().addAll(CustomerRadioAdd,CashierRadioAdd,SupplierRadioAdd);
        
         //------------------------------------------------------------------------------------------
         //password and confirm password
         PasswordField Password=new PasswordField();
         Password.setPromptText("Example:....");
         PasswordField ConfirmPassword=new PasswordField();
         ConfirmPassword.setPromptText("Example:....");
         //------------------------------------------------------------------------------------------
         Button ConfirmAdd=new Button("Confirm");//Action: Add the user with the given information
         //Labels
         Label UserNameLab=new Label("Username");
         Label UserTypeLab=new Label("User Type");
         Label PasswordLab=new Label("Password");
         Label ConfirmPasswordLab=new Label("Confirm Password");
         //------------------------------------------------------------------------------------------
         //Padding, alignment and Scene
         Adduser.setPadding(new Insets(20,50,50,50));
         Adduser.getChildren().addAll(UserNameLab,UserName,UserTypeLab,ToggleUserType,PasswordLab
         ,Password, ConfirmPasswordLab,ConfirmPassword,ConfirmAdd);
         Button managepanelsadd=new Button("Home");
         Adduser.getChildren().add(managepanelsadd);
         Adduser.setAlignment(Pos.CENTER);
         ScrollPane addpane=new ScrollPane(Adduser);
         Scene AddUserSc=new Scene(addpane,390,400);   
         
         
        
          //**************************************************************************************************
          //                                Edit User
     
          //Edit user button will show this stage (current usename,New Username,current usertype,New usertype, new password and confirm password fields)
          //Main VBox
         VBox EditUser = new VBox(15);
         EditUser.setPadding(new Insets(10,10,10,10));
     
         //-----------------------------------------------------------------------
         //current user type toggle group
         HBox ToggleEditUserType = new HBox(10);
         ToggleEditUserType.setPadding(new Insets(5,5,5,30));
         ToggleGroup GroupUserTypeEdit = new ToggleGroup();
         
         RadioButton CustomerRadioEdit = new RadioButton("Customer");
         CustomerRadioEdit.setToggleGroup(GroupUserTypeEdit);
         
         RadioButton CashierRadioEdit = new RadioButton("Cashier");
         CashierRadioEdit.setToggleGroup(GroupUserTypeEdit);
         
         RadioButton SupplierRadioButtonEdit=new RadioButton("Supplier");
         SupplierRadioButtonEdit.setToggleGroup(GroupUserTypeEdit);
         
         ToggleEditUserType.getChildren().addAll(CustomerRadioEdit, CashierRadioEdit,SupplierRadioButtonEdit);
         //----------------------------------------------------------------------------
         //texts and passwords fields
         TextField CurrentUserName = new TextField();
         
         TextField EditUserName = new TextField();
         EditUserName.setPromptText("Example: Mo101");
         
         PasswordField NewPassword = new PasswordField();
         NewPassword.setPromptText("Example:....");
     
         PasswordField ConfirmNewPassword = new PasswordField();
         ConfirmNewPassword.setPromptText("Example:....");
         //----------------------------------------------------------------------------
         Button ConfirmEdit = new Button("Confirm");// Action: Update the user with the given information
         Label CurrentUserNameLab = new Label("Current Username");
         Label EditUserNameLab = new Label("new Username");
         Label EditUserTypeLab = new Label("User Type");
         Label NewPasswordLab = new Label("New Password");
         Label ConfirmNewPasswordLab = new Label("Confirm New Password");
         Button managepanelsedit=new Button("Home");
         EditUser.getChildren().addAll(CurrentUserNameLab,CurrentUserName,EditUserNameLab, EditUserName, EditUserTypeLab, ToggleEditUserType,
         NewPasswordLab, NewPassword, ConfirmNewPasswordLab, ConfirmNewPassword, ConfirmEdit,managepanelsedit);
         EditUser.setAlignment(Pos.CENTER);
         ScrollPane editpane=new ScrollPane(EditUser);
         Scene EditUserSc = new Scene(editpane, 350, 400);
         
         
         //**************************************************************************************************
                                           /* Search for a user */
         
         //Main VBox
         VBox MainSearchUser=new VBox(15);
         MainSearchUser.setPadding(new Insets(10,10,10,10));
         //----------------------------------------------------------------
         Label SearchUserNamelab=new Label("User Name");
         TextField SearchUserName=new TextField();
         //----------------------------------------------------------------
         HBox ToggleSearchUserType = new HBox(10);
         ToggleEditUserType.setPadding(new Insets(5,5,5,30));
         ToggleGroup GroupUserTypeSearch = new ToggleGroup();
         
         RadioButton CustomerRadioSearch = new RadioButton("Customer");
         CustomerRadioSearch.setToggleGroup(GroupUserTypeSearch);
         
         RadioButton CashierRadioSearch = new RadioButton("Cashier");
         CashierRadioSearch.setToggleGroup(GroupUserTypeSearch);
         
         RadioButton SupplierRadioButtonSearch=new RadioButton("Supplier");
         SupplierRadioButtonSearch.setToggleGroup(GroupUserTypeSearch);
         
         ToggleSearchUserType.getChildren().addAll(CustomerRadioSearch, CashierRadioSearch,SupplierRadioButtonSearch);   
         
         //------------------------------------------------------------------
         Button ConfirmSearch=new Button("Confirm");
         Button managepanelssearch=new Button("Home");
         MainSearchUser.getChildren().addAll(SearchUserNamelab,SearchUserName,ToggleSearchUserType,ConfirmSearch
         ,managepanelssearch);
         
              Scene SearchUserSc=new Scene(MainSearchUser,350,350);
         
         
             //**************************************************************************************************   
                                                       /*Remove User*/
             //Main VBox
         VBox MainRemoveUser=new VBox(15);
         MainRemoveUser.setPadding(new Insets(10,10,10,10));
         //----------------------------------------------------------------
         Label RemoveUserNamelab=new Label("User Name");
         TextField RemoveUserName=new TextField();
         //----------------------------------------------------------------
         HBox ToggleRemoveUserType = new HBox(10);
         ToggleRemoveUserType.setPadding(new Insets(5,5,5,30));
         ToggleGroup GroupUserTypeRemove = new ToggleGroup();
         
         RadioButton CustomerRadioRemove = new RadioButton("Customer");
         CustomerRadioRemove.setToggleGroup(GroupUserTypeRemove);
         
         RadioButton CashierRadioRemove = new RadioButton("Cashier");
         CashierRadioRemove.setToggleGroup(GroupUserTypeRemove);
         
         RadioButton SupplierRadioButtonRemove=new RadioButton("Supplier");
         SupplierRadioButtonRemove.setToggleGroup(GroupUserTypeRemove);
         
         ToggleRemoveUserType.getChildren().addAll(CustomerRadioRemove, CashierRadioRemove,SupplierRadioButtonRemove);   
         
         //------------------------------------------------------------------
         Button ConfirmRemove=new Button("Confirm");
         Button managepanelsRemove=new Button("Home");
         MainRemoveUser.getChildren().addAll(RemoveUserNamelab,RemoveUserName,ToggleRemoveUserType,ConfirmRemove
         ,managepanelsRemove);
         
              Scene RemoveUserSc=new Scene(MainRemoveUser,350,350);
             
             //**************************************************************************************************
                                                         /*Add Product*/
         VBox MainAddP = new VBox(10); // 10 pixels spacing
         MainAddP.setPadding(new Insets(20, 20, 20, 20)); // Set padding                                                 
         Label Pnamelab = new Label("Product Name");
         TextField Pname = new TextField();

         Label pricelab = new Label("Product Price");
         TextField price = new TextField();

         Button confirmAddP = new Button("Confirm");
         Button managepanelAddP = new Button("Home");

         // Add nodes to VBox
         MainAddP.getChildren().addAll(Pnamelab, Pname, pricelab, price, confirmAddP, managepanelAddP);

         // Set up the scene
         Scene AddPSc = new Scene(MainAddP, 300, 250);
         //********************************************************************************************************
                                                          /*Remove Product*/
                                                          
         VBox mainRemoveP = new VBox(10); // 10 pixels spacing
        mainRemoveP.setPadding(new Insets(20, 20, 20, 20)); // Set padding

        Label nameLabel = new Label("Product Name or Serial Number");
        TextField nameOrSerialField = new TextField();

        Button confirmRemoveP = new Button("Confirm");
        Button managePanelRemoveP = new Button("Home");

        // Add nodes to VBox
        mainRemoveP.getChildren().addAll(nameLabel, nameOrSerialField, confirmRemoveP, managePanelRemoveP);

        // Set up the scene
        Scene RemovePSc = new Scene(mainRemoveP, 300, 250);

        // Set up action for the confirm button
        confirmRemoveP.setOnAction(e -> {
            String nameOrSerial = nameOrSerialField.getText();

            // Calling remove method 
            boolean removed = admin.removeProducts(nameOrSerial, nameOrSerial);

            // Clear existing labels and add the result label
            mainRemoveP.getChildren().clear();

            Label resultLabel = new Label();
            if (removed) {
                // Product successfully removed
                resultLabel.setText("Product removed successfully.");
            } else {
                // Product not found or removal failed
                resultLabel.setText("Product not found or removal failed.");
            }

            mainRemoveP.getChildren().addAll(resultLabel, managePanelRemoveP);
        });
             
         //*********************************************************************************************************
                                                        /*Search for a product*/
                                                        
        
        Label searchLabel = new Label("Enter Product Name or ID:");
        TextField searchField = new TextField();
        Button confirmButton = new Button("Search");

        // Create a result label to display the search result
        Label resultLabel = new Label();

        // Handle search button click
        confirmButton.setOnAction(e -> {
            String searchText = searchField.getText();
           Products search= admin.searchProducts(searchText, searchText);
           resultLabel.setText("name: " +search.productName+"\n"+"price:"+search.price+"\n"+"product serial number:"+search.PID);
        });

        // Create layout
        VBox layout = new VBox(10);
        layout.getChildren().addAll(searchLabel, searchField, confirmButton, resultLabel);
        layout.setPadding(new Insets(10));

        // Create scene
        Scene SearchPSc = new Scene(layout, 300, 150);                                            
         //********************************************************************************************************
                                                              /*Manage supplier*/
         
               HBox MainSupManagement=new HBox(30);
               MainSupManagement.setPadding(new Insets(10,10,10,10));
               MainSupManagement.setAlignment(Pos.CENTER);
               VBox Sup1=new VBox(10);
               
               Sup1.setPadding(new Insets(5,5,5,5));
               Label sup1p1N=new Label(sup1.supplierProducts.get(0).productName);
               Label sup1p2N=new Label(sup1.supplierProducts.get(1).productName);
               Label sup1p3N=new Label(sup1.supplierProducts.get(2).productName);
               Label sup1p4N=new Label(sup1.supplierProducts.get(3).productName);
               Label sup1p5N=new Label(sup1.supplierProducts.get(4).productName);
               
               Label sup1p1P=new Label(""+sup1.supplierProducts.get(0).price);
               Label sup1p2P=new Label(""+sup1.supplierProducts.get(1).price);
               Label sup1p3P=new Label(""+sup1.supplierProducts.get(2).price);
               Label sup1p4P=new Label(""+sup1.supplierProducts.get(3).price);
               Label sup1p5P=new Label(""+sup1.supplierProducts.get(4).price);
               
               Label sup1Lab=new Label(Supplier.SupplierDataList.get(0).supplierName);
               
               Sup1.getChildren().addAll(sup1Lab,
                       sup1p1N,sup1p1P,
                       sup1p2N,sup1p2P,
                       sup1p3N,sup1p3P,
                       sup1p4N,sup1p4P,
                       sup1p5N,sup1p5P);
               
               
               VBox Sup2=new VBox(10);
               Sup2.setPadding(new Insets(5,5,5,5));
               Label sup2p1N=new Label(sup2.supplierProducts.get(0).productName);
               Label sup2p2N=new Label(sup2.supplierProducts.get(1).productName);
               Label sup2p3N=new Label(sup2.supplierProducts.get(2).productName);
               Label sup2p4N=new Label(sup2.supplierProducts.get(3).productName);
               Label sup2p5N=new Label(sup2.supplierProducts.get(4).productName);
               
               Label sup2p1P=new Label(""+sup2.supplierProducts.get(0).price);
               Label sup2p2P=new Label(""+sup2.supplierProducts.get(1).price);
               Label sup2p3P=new Label(""+sup2.supplierProducts.get(2).price);
               Label sup2p4P=new Label(""+sup2.supplierProducts.get(3).price);
               Label sup2p5P=new Label(""+sup2.supplierProducts.get(4).price);
               Label sup2Lab=new Label(Supplier.SupplierDataList.get(1).supplierName);
               Sup2.getChildren().addAll(sup2Lab,
                       sup2p1N,sup2p1P,
                       sup2p2N,sup2p2P,
                       sup2p3N,sup2p3P,
                       sup2p4N,sup2p4P,
                       sup2p5N,sup2p5P);
               
               
               VBox Sup3=new VBox(10);
               Sup3.setPadding(new Insets(5,5,5,5));
     
               Label sup3p1N=new Label(sup3.supplierProducts.get(0).productName);
               Label sup3p2N=new Label(sup3.supplierProducts.get(1).productName);
               Label sup3p3N=new Label(sup3.supplierProducts.get(2).productName);
               Label sup3p4N=new Label(sup3.supplierProducts.get(3).productName);
               Label sup3p5N=new Label(sup3.supplierProducts.get(4).productName);
               
               Label sup3p1P=new Label(""+sup3.supplierProducts.get(0).price);
               Label sup3p2P=new Label(""+sup3.supplierProducts.get(1).price);
               Label sup3p3P=new Label(""+sup3.supplierProducts.get(2).price);
               Label sup3p4P=new Label(""+sup3.supplierProducts.get(3).price);
               Label sup3p5P=new Label(""+sup3.supplierProducts.get(4).price);
               Label sup3Lab=new Label(Supplier.SupplierDataList.get(1).supplierName);
               Sup3.getChildren().addAll(sup3Lab,
                       sup3p1N,sup3p1P,
                       sup3p2N,sup3p2P,
                       sup3p3N,sup3p3P,
                       sup3p4N,sup3p4P,
                       sup3p5N,sup3p5P);
               
               
               
               VBox Sup4=new VBox(10);
               Sup4.setPadding(new Insets(5,5,5,5));
               Label sup4p1N=new Label(sup4.supplierProducts.get(0).productName);
               Label sup4p2N=new Label(sup4.supplierProducts.get(1).productName);
               Label sup4p3N=new Label(sup4.supplierProducts.get(2).productName);
               Label sup4p4N=new Label(sup4.supplierProducts.get(3).productName);
               Label sup4p5N=new Label(sup4.supplierProducts.get(4).productName);
               
               Label sup4p1P=new Label(""+sup4.supplierProducts.get(0).price);
               Label sup4p2P=new Label(""+sup4.supplierProducts.get(1).price);
               Label sup4p3P=new Label(""+sup4.supplierProducts.get(2).price);
               Label sup4p4P=new Label(""+sup4.supplierProducts.get(3).price);
               Label sup4p5P=new Label(""+sup4.supplierProducts.get(4).price);
               Label sup4Lab=new Label(Supplier.SupplierDataList.get(1).supplierName);
               Sup4.getChildren().addAll(sup4Lab,
                       sup4p1N,sup4p1P,
                       sup4p2N,sup4p2P,
                       sup4p3N,sup4p3P,
                       sup4p4N,sup4p4P,
                       sup4p5N,sup4p5P);
               
               VBox Sup5=new VBox(10);
               Sup5.setPadding(new Insets(5,5,5,5));
               Label sup5p1N=new Label(sup3.supplierProducts.get(0).productName);
               Label sup5p2N=new Label(sup3.supplierProducts.get(1).productName);
               Label sup5p3N=new Label(sup3.supplierProducts.get(2).productName);
               Label sup5p4N=new Label(sup3.supplierProducts.get(3).productName);
               Label sup5p5N=new Label(sup3.supplierProducts.get(4).productName);
               
               Label sup5p1P=new Label(""+sup3.supplierProducts.get(0).price);
               Label sup5p2P=new Label(""+sup3.supplierProducts.get(1).price);
               Label sup5p3P=new Label(""+sup3.supplierProducts.get(2).price);
               Label sup5p4P=new Label(""+sup3.supplierProducts.get(3).price);
               Label sup5p5P=new Label(""+sup3.supplierProducts.get(4).price);
               Label sup5Lab=new Label(Supplier.SupplierDataList.get(1).supplierName);
               Sup5.getChildren().addAll(sup5Lab,
                       sup5p1N,sup5p1P,
                       sup5p2N,sup5p2P,
                       sup5p3N,sup5p3P,
                       sup5p4N,sup5p4P,
                       sup5p5N,sup5p5P);
               
             MainSupManagement.getChildren().addAll(Sup1,Sup2,Sup3,Sup4,Sup5);
             Scene ManageSupSc=new Scene(MainSupManagement,400,400);
             //*********************************************************************************************************
                                                       /*cashier with maximum carts*/
                VBox MainMaxCashier=new VBox(10);
                MainMaxCashier.setAlignment(Pos.CENTER);
                MainMaxCashier.setPadding(AppInsets);
                Button CashMN=new Button("Cashier with Maximum Cart");
                MainMaxCashier.getChildren().add(CashMN);
                
                Scene MainMaxCashierSc=new Scene(MainMaxCashier,250,250);
                //*****************************************************************************************************
                Trends.setOnAction(e->{primaryStage.setScene(MainMaxCashierSc);
        primaryStage.setTitle("Trends");});
             //*********************************************************************************************************  
             //managng user buttons
                Button AddU=new Button("Add User");
                Button EditU=new Button("Edit User");
                Button SearchU=new Button("Search for a User");
                Button RemoveU=new Button("Remove User");
                
                // adding buttons to a vbox(acts as a panel
                VBox manageUsersButtons = new VBox(5);
                manageUsersButtons.getChildren().addAll(AddU,EditU,SearchU,RemoveU);
             //-----------------------------------------------------------------------------------------------
                //managng products buttons
                Button AddP=new Button("Add Product");
                Button SearchP=new Button("Search for a Product");
                Button RemoveP=new Button("Remove Product");
                
              // adding buttons to the 
                VBox manageProductsButtons = new VBox(5);
                manageProductsButtons.getChildren().addAll(AddP,SearchP,RemoveP);
        
         //***********************************************************************************************        
         // Set action for manage users button 
            manageUsersButton.setOnAction(e -> {
            mainvbox.getChildren().remove(manageProductsButtons);
            if (!mainvbox.getChildren().contains(manageUsersButtons)) {
                mainvbox.getChildren().add(manageUsersButtons);
        }
            }
        );
        //***********************************************************************************************     
        // Set action for manage products button 
        manageProductsButton.setOnAction(e -> {
            mainvbox.getChildren().remove(manageUsersButtons);
            if (!mainvbox.getChildren().contains(manageProductsButtons)) {
                mainvbox.getChildren().add(manageProductsButtons);
            }
        });
        
     //***********************************************************************************************
                                        /*Home Button handeling in every scene*/
     
     managepanelsadd.setOnAction(e->{primaryStage.setScene(AdminSc);
      primaryStage.setTitle("Admin");
     });
     //------------------------------------------------------------------------------
     managepanelsedit.setOnAction(e->{primaryStage.setScene(AdminSc);
      primaryStage.setTitle("Admin");
     });
     //------------------------------------------------------------------------------
     managepanelssearch.setOnAction(e->{primaryStage.setScene(AdminSc);
      primaryStage.setTitle("Admin");
     });
     //------------------------------------------------------------------------------
     managepanelsRemove.setOnAction(e->{primaryStage.setScene(AdminSc);
      primaryStage.setTitle("Admin");});
     //------------------------------------------------------------------------------
     managepanelAddP.setOnAction(e->{primaryStage.setScene(AdminSc);
      primaryStage.setTitle("Admin");});
     //***********************************************************************************************
     SearchP.setOnAction(e->{primaryStage.setScene(SearchPSc);
        primaryStage.setTitle("Searching for product");});
     //***********************************************************************************************
     ManageSup.setOnAction(e->{primaryStage.setScene(ManageSupSc);
        primaryStage.setTitle("Manage suppliers");});
     //***********************************************************************************************
     
        AddU.setOnAction(e->{primaryStage.setScene(AddUserSc);
        primaryStage.setTitle("Add User");});
        
     //***********************************************************************************************
     
        EditU.setOnAction(e->{primaryStage.setScene(EditUserSc);
        primaryStage.setTitle("Edit User");});
        
     //***********************************************************************************************
     SearchU.setOnAction(e->{primaryStage.setScene(SearchUserSc);
     primaryStage.setTitle("Search for a User");});
     
     //***********************************************************************************************
     RemoveU.setOnAction(e->{primaryStage.setScene(RemoveUserSc);
     primaryStage.setTitle("Remove User");});
     //***********************************************************************************************
     AddP.setOnAction(e->{primaryStage.setScene(AddPSc);
     primaryStage.setTitle("Add Product");});
     //***********************************************************************************************
     RemoveP.setOnAction(e->{primaryStage.setScene(RemovePSc);
     primaryStage.setTitle("Remove Product");});
     //***********************************************************************************************
                                     /*Confirm Add User Button*/
                                     
     ConfirmAdd.setOnAction(e->{
     String username= UserName.getText();
     //-----------------------------------------------------------------------------------------------
     //Password and confirm password conflict
     if(!Password.getText().equals(ConfirmPassword.getText())){
     Alert passerror= new Alert(AlertType.INFORMATION);
     passerror.setHeaderText("Password Confirmation");
     passerror.setHeaderText("Please reconfirm your password");
     passerror.showAndWait();
     }
     //setting the passwords
     String password= Password.getText();
     String confirmpassword= ConfirmPassword.getText();
     //-------------------------------------------------------------------------------------------------
     //setting the user type
     String userType;
     RadioButton selectedToggle1 = (RadioButton) GroupUserTypeAdd.getSelectedToggle();
     // Handle the case where no toggle is selected
     if (selectedToggle1 == null) {
      Alert TypeError= new Alert(AlertType.INFORMATION);
     TypeError.setHeaderText("User type selection");
     TypeError.setHeaderText("Please choose the user type");
     TypeError.showAndWait(); 
     }
     
     //no need for exception handelling 
     userType = selectedToggle1.getText();
 
     admin.addUser(username, userType, password, confirmpassword);
     Label AddDone=new Label("User added...");
     Adduser.getChildren().add(AddDone);
        });
     //****************************************************************************************************
                                    /*Confirm Edit User Button*/
                                    
     ConfirmEdit.setOnAction(e->{
     String CurrentUsername=CurrentUserName.getText();
     String newUsername=EditUserName.getText();
     //----------------------------------------------------------------------------------------------------
     //Password and confirm password conflict
     if(!NewPassword.getText().equals(ConfirmNewPassword.getText())){
     Alert passerror= new Alert(AlertType.INFORMATION);
     passerror.setHeaderText("Password Confirmation");
     passerror.setHeaderText("Please reconfirm your password");
     passerror.showAndWait();
     }
     
     String EditedPassword=NewPassword.getText();
     //-----------------------------------------------------------------------------------------------------
     //User type handle 
     
     String CurrentUserType;
     RadioButton selectedToggle2 = (RadioButton) GroupUserTypeEdit.getSelectedToggle();
     if(selectedToggle2==null){
        Label usertype=new Label("User type is required");
        EditUser.getChildren().clear();
        
        EditUser.getChildren().addAll(CurrentUserNameLab,CurrentUserName,EditUserNameLab,
         EditUserName, EditUserTypeLab,usertype, ToggleEditUserType,
         NewPasswordLab, NewPassword, ConfirmNewPasswordLab,
         ConfirmNewPassword, ConfirmEdit,managepanelsedit);
     }
     else{CurrentUserType=selectedToggle2.getText();
     admin.editUser(CurrentUsername,newUsername, CurrentUserType, EditedPassword);}
     Label doneedit=new Label("your edits are saved");
     EditUser.getChildren().clear();
        
        EditUser.getChildren().addAll(CurrentUserNameLab,CurrentUserName,EditUserNameLab,
         EditUserName, EditUserTypeLab, ToggleEditUserType,
         NewPasswordLab, NewPassword, ConfirmNewPasswordLab,
         ConfirmNewPassword, ConfirmEdit,managepanelsedit,doneedit);
     });
     
     
     //***********************************************************************************************
                                         /*Confirm Button Search*/
                                         
           ConfirmSearch.setOnAction(e->{
           String Username=SearchUserName.getText();
           String usertype;
           RadioButton Selectedtoggle3=(RadioButton) GroupUserTypeSearch.getSelectedToggle();
           //------------------------------------------------------------------------------------
           //handeling null type
           if(Selectedtoggle3==null){
            Label usertypelab=new Label("User type is required");
            MainSearchUser.getChildren().clear();
            MainSearchUser.getChildren().addAll(SearchUserNamelab,SearchUserName,ToggleSearchUserType,ConfirmSearch
         ,managepanelssearch,usertypelab);
           }
           else{ 
               usertype=Selectedtoggle3.getText();
               
               if(admin.searchUser(Username,usertype)){
                   Label found=new Label("User found");
                   MainSearchUser.getChildren().clear();
            MainSearchUser.getChildren().addAll(SearchUserNamelab,SearchUserName,ToggleSearchUserType,ConfirmSearch
         ,managepanelssearch,found);
               }
               else{
               Label notfound=new Label("User not found");
               MainSearchUser.getChildren().clear();
            MainSearchUser.getChildren().addAll(SearchUserNamelab,SearchUserName,ToggleSearchUserType,ConfirmSearch
         ,managepanelssearch,notfound);
               }
           }
           
           
           
           });
           //**************************************************************************************************
                                                    /*Confirm Remove User*/
            ConfirmRemove.setOnAction(e->{
            String Username=RemoveUserName.getText();
           String usertype;
           RadioButton Selectedtoggle4=(RadioButton) GroupUserTypeRemove.getSelectedToggle();
           //------------------------------------------------------------------------------------
           //handeling null type
           if(Selectedtoggle4==null){
            Label usertypelab=new Label("User type is required");
            MainRemoveUser.getChildren().clear();
            MainRemoveUser.getChildren().addAll(RemoveUserNamelab,RemoveUserName,ToggleRemoveUserType,ConfirmRemove
         ,managepanelsRemove,usertypelab);
           }
           else{ 
               usertype=Selectedtoggle4.getText();
               
               if(admin.removeUser(Username, usertype)){
                   Label found=new Label("User removed");
                   MainRemoveUser.getChildren().clear();
            MainRemoveUser.getChildren().addAll(RemoveUserNamelab,RemoveUserName,ToggleRemoveUserType,ConfirmRemove
         ,managepanelsRemove,found);
               }
               else{
               Label notfound=new Label("User not found");
               MainRemoveUser.getChildren().clear();
            MainRemoveUser.getChildren().addAll(RemoveUserNamelab,RemoveUserName,ToggleRemoveUserType,ConfirmRemove
         ,managepanelsRemove,notfound);
               }
           }
            });
            
            //***********************************
                                                       /*Add product confirm*/
           
         confirmAddP.setOnAction(e -> {
    String productName = Pname.getText();
    String priceText = price.getText();

    VBox content = new VBox(10);  // Use an appropriate layout container

    if (productName.isEmpty()) {
        content.getChildren().addAll(new Label("Please enter a product name"), Pname, pricelab, price, confirmAddP, managepanelAddP);
    } else if (priceText.isEmpty()) {
        content.getChildren().addAll(Pnamelab, Pname, pricelab, price, new Label("Price cannot be zero"), confirmAddP, managepanelAddP);
    } else {
        try {
            int pprice = Integer.parseInt(priceText);
            String pname = productName;
            admin.addProducts(pname, pprice);
            content.getChildren().addAll(new Label("Product added successfully"), Pnamelab, new TextField(), pricelab, new TextField(), confirmAddP, managepanelAddP);
        } catch (NumberFormatException ex) {
            content.getChildren().addAll(Pnamelab, Pname, pricelab, price, new Label("Invalid price format"), confirmAddP, managepanelAddP);
        }
    }

    MainAddP.getChildren().setAll(content);
});
         
         

           
            
           
    }
    }