/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.burger_oop_courdework;

import java.util.Scanner;


public class Order {
    public static int size=1;
    private static Order[] orders = new Order[10];
    public Scanner input = new Scanner(System.in);
    private String order_id;
    private String cus_id;
    private String name;
    private double total;
    private String status;
    private int quantity;
    public char choice = 'n';
    public static int count = 0;
    public String existingCustomerIndex;
    private static int orderCount = 0;
    //public int size=0;

     public Order() {
        // Default constructor
    }
   @Override
        public String toString()
        {
            /*    
             private String order_id;
    private String cus_id;
    private String name;
    private double total;
    private String status;
    private int quantity;
            */
            
            return "{"+order_id+"-"+cus_id+"-"+"-"+name+"-"+total+"-"+"status"+"-"+quantity;
        }
    public String generateID() {
       orderCount++;
       size++;
        return String.format("B%04d", orderCount);
    }

    public static Order[] getOrderList() {
        
        return orders;
    }

   /*  public void clearConsole() {
        try {
            final String os = System.getProperty("os.name");
            if (os.contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                System.out.print("\033[H\033[2J");
                System.out.flush();
            }
        } catch (final Exception e) {
            e.printStackTrace();
        }
    }*/

    public void takeOrder() {
        //clearConsole();
        choice = 'n';
        System.out.println("---------------------------------------------------------------------------------------");
        System.out.println("|                                   Place Order                                    |");
        System.out.println("---------------------------------------------------------------------------------------");

       
        takeOrderDetails();

        //char choice2 = Confirmation();

        orders[count++] = this;

        
    }

    public  void exit() {
               // clearConsole();
                System.out.println("\n\t\tYou left the program. Thanks Come again!!!!!!!!!!!..\n");
                System.exit(0);
                }

     
    public  Order(String order_id,String cus_id,String name,double total)
     {
                this.order_id=order_id;
                this.cus_id=cus_id;
                this.name=name;
                this.total=total;
         
     }
     
     
    public String getorder_id() {
    return order_id;
}
     
     public void  setorder_id(String order_id)
     {
         this.order_id=order_id;
     }
     
     public String getcus_id()
     {
         return cus_id;
     }
     
     public  void setcus_id(String cus_id)
     {
         this.cus_id=cus_id;
     }
     
     public String getname()
     {
         return name;
     }
     
     public void  setname(String name)
     {
         this.name=name;
     }
     
     
     public double gettotal() {
          return total; 
     }
     
     public  void settotal(double total)
     {
         this.total=total;
     }
     public void setquantity(int quantity)
     {
         this.quantity=quantity;
     }
     
     public int getquantity()
     {
         return quantity;
     }
     
      public String getstatus()
     {
         return status;
     }
      public void  setstatus(String status)
     {
         this.status=status;
     }
      
     ///////////////////////////////////
    
     //take new order
     public void takeOrderDetails() {
        //clearConsole();
        
        String input1 = generateID();
        String result = input1.substring(input1.length() - 3);

        System.out.println("Order ID - B" + result + "\n==================");
        String id_new = ("B" + result);
        setorder_id(id_new);

       // takePhoneNum();
        //takeName();
       // int quantity = takeQuantity();
        //takeTotal(quantity);
    }
    
    public void takePhoneNum() {
        do {
            System.out.print("Enter customer ID (Phone no.): ");
            int PhoneNo = input.nextInt();
            input.nextLine();
           /*  existingCustomerIndex = findCustomerIndex(PhoneNo);
            if (existingCustomerIndex != null) {
                System.out.println("Welcome back! " + name + " Hungry Burger shop");
                System.out.println("Customer Name: " + name);
                break;
            }*/  
                int val = phoneNoValidate(PhoneNo);
                String phoneString = "" + PhoneNo;
                if (val == 1) {
                    setcus_id(phoneString);
                    break;
                } else {
                    System.out.print("Invalid number!\nDo you want to try again (y/n): ");
                    choice = input.next().charAt(0);
                    if (choice != 'y' && choice != 'Y') {
                        System.out.print("Do you want to go back to the main menu? (y/n): ");
                        char goBackToMainMenu = input.next().charAt(0);
                        if (goBackToMainMenu == 'y' || goBackToMainMenu == 'Y') {
                         //   clearConsole();
                            break;
                        }
                    }
                }
            
        } while (choice == 'y' || choice == 'Y');
    }

    public void takeName() {
        System.out.println("Hello!!!! welcome to iHungry Burger shop");
        System.out.print("Customer name: ");
        String name = input.next();
        setname(name);
    }

    public int takeQuantity() {
        
            System.out.print("Enter Burger quantity: ");
            quantity = input.nextInt();
            if (quantity > 0) {
                setquantity(quantity);
            } else {
                System.out.print("Oops! It looks like you've entered a quantity of zero. " +
                        "Please choose a positive quantity to place your order!\n" +
                        "Do you want to try again (y/n): ");
                choice = input.next().charAt(0);
                if (choice != 'y' && choice != 'Y') {
                    System.out.print("Do you want to go back to the main menu? (y/n): ");
                    char goBackToMainMenu = input.next().charAt(0);

                    if (goBackToMainMenu == 'y' || goBackToMainMenu == 'Y') {
                       // clearConsole();

                    }
                }
            }
        
        return this.quantity;
    }

    public void takeTotal(int quantity) {
        double total = 500 * this.quantity;
        System.out.println("Total value: " + total);
        settotal(total);
    }
       
       public char Confirmation() {
                          System.out.print("Are you confirm order (y/n): ");
                          char confirmation = input.next().charAt(0);

                          if (confirmation == 'y') {
                                 
                                    setstatus("PREPARING");
                          } else {
        // Set a default status if the user does not confirm
                          this.status = "PENDING";
                          }

                        //  clearConsole();
                          System.out.println("Your order has been entered into the system successfully.");
                          System.out.print("Do you want to place any order (y/n): ");
                          this.choice = input.next().charAt(0);

              return this.choice;
}

       
       public char Runagain()
       {
                            
                            if (choice != 'y' && choice != 'Y'){
                                System.out.print("Do you want to go back to the main menu? (y/n): ");
                                this.choice = input.next().charAt(0);
                                
                            if (this.choice == 'y' || this.choice == 'Y') {
                           //     clearConsole();
                                
                            }
                            }
                            
                            
              return this.choice;
       }
       
       
    
   
        
        //////////////////////////////////////////////////////
         //SEARCH Order Details
// SEARCH Best Customer (Descending Order)
       
       
   public String search_best_customer(Order[] orders) {
        System.out.println("---------------------------------------------------------------------------------------");
        System.out.println("|                       SEARCH Best Customer (Descending Order)                        |");
        System.out.println("---------------------------------------------------------------------------------------");

        // Perform bubble sort to sort orders by total in descending order
        for (int i = 0; i < orders.length - 1; i++) {
            for (int j = 0; j < orders.length - 1 - i; j++) {
                if (orders[j] == null || orders[j + 1] == null) {
                    // Handle null case, either by skipping or assigning a default value
                    // For example: System.out.println("Skipping null order.");
                } else if (orders[j].gettotal() < orders[j + 1].gettotal()) {
                    Order bestO = orders[j];
                    orders[j] = orders[j + 1];
                    orders[j + 1] = bestO;
                }
            }
        }

        displayOrderDetails(orders);

        return "Search complete!!";
    }
      public String search_Order_Details(Order[] orders) {
    System.out.println("---------------------------------------------------------------------------------------");
    System.out.println("|                               SEARCH Order Details                                 |");
    System.out.println("---------------------------------------------------------------------------------------");

    System.out.print("Enter order ID: ");
    String choice1 = input.next();
    input.nextLine();
    boolean found = false;

    for (Order order : orders) {
        if (choice1.equals(order.getorder_id())) {
            this.order_id = order.getorder_id();
            this.cus_id = order.getcus_id();
            this.name = order.getname();
            this.total = order.gettotal();
            this.status = order.getstatus();

            System.out.println("Order ID: " + order_id);
            System.out.println("Customer ID: " + cus_id);
            System.out.println("Name: " + name);
            System.out.println("Total: " + total);
            System.out.println("Status: " + status);

            found = true;
            break;
        }
    }

    if (!found) {
        System.out.println("Order not found!");
    }

    return "Search complete.";
}

public String search_customer_Details(Order[] orders) {
    System.out.println("---------------------------------------------------------------------------------------");
    System.out.println("|                               SEARCH Customer Details                                 |");
    System.out.println("---------------------------------------------------------------------------------------");

    System.out.print("Enter customer ID: ");
    String choice1 = input.next();
    input.nextLine();
    boolean found = false;

    for (Order order : orders) {
        if (choice1.equals(order.getcus_id())) {
            this.order_id = order.getorder_id();
            this.cus_id = order.getcus_id();
            this.name = order.getname();
            this.total = order.gettotal();
            this.status = order.getstatus();

            System.out.println("Order ID: " + order_id);
            System.out.println("Customer ID: " + cus_id);
            System.out.println("Name: " + name);
            System.out.println("Total: " + total);
            System.out.println("Status: " + status);

            found = true;
            break;
        }
    }

    if (!found) {
        System.out.println("Customer not found!");
    }

    return "Search complete.";
}
///////////////////////////////////////////////////////////////////////
        //  VEIW ORDER LIST  
public String veiw_order_list(OrderList[] orders, int selectedOption) {
    System.out.println("---------------------------------------------------------------------------------------");
    System.out.println("|                                  VEIW ORDER LIST                                   |");
    System.out.println("---------------------------------------------------------------------------------------");

    System.out.println("Orderid\tCustomer_ID\tName\tTotal\tStatus");

    for (OrderList orderList : orders) {
        for (Order order : orderList.toArray()) {
            if (selectedOption == 1 && "Delivered".equalsIgnoreCase(order.getstatus())) {
                System.out.println(order.todtring());
            } else if (selectedOption == 2 && "Preparing".equalsIgnoreCase(order.getstatus())) {
                System.out.println(order.todtring());
            } else if (selectedOption == 3 && "Canceled".equalsIgnoreCase(order.getstatus())) {
                System.out.println(order.todtring());
            }
        }
    }

    return "That's all for now.";
}
                    
                
                 public String todtring(){
                 return getorder_id() + "\t" + getcus_id() + "\t" + getname() + "\t" + gettotal()+"\t"+getstatus();
}
public void displayOrderDetails(Order[] orders) {
    System.out.println("---------------------------------------------------------------------------------------");
    System.out.println("|                                  VEIW ORDER LIST                                   |");
    System.out.println("---------------------------------------------------------------------------------------");

    System.out.println("Order ID\tCustomer ID\tName\tTotal\tStatus");
    for (Order order : orders) {
        if (order != null) {
            System.out.println(order.todtring());
        }
    }
}

             ///////////// update deteils   
            public String update_details(Order[] orders, String orderId) {
    System.out.println("---------------------------------------------------------------------------------------");
    System.out.println("|                             UPDATE ORDER DETAILS                                  |");
    System.out.println("---------------------------------------------------------------------------------------");

    boolean found = false;
    Order orderToUpdate = null;

    for (Order order : orders) {
        if (orderId.equals(order.getorder_id())) {
            orderToUpdate = order;
            System.out.println(order.todtring());
            found = true;
            break;
        }
    }

    if (!found) {
        System.out.println("Invalid ID.\nDo you want to try again? (y/n): ");
        char choice = input.next().charAt(0);
        return "Incomplete"; // Indicate that the update was not successful
    }

    System.out.println("What do you want to update?\n\t(1) Quantity\n\t(2) Status");
    System.out.print("Enter here: ");
    int updateOption = input.nextInt();
    input.nextLine();

    if (updateOption == 1) {
        System.out.print("Enter the new quantity: ");
        int newQuantity = input.nextInt();
        input.nextLine();

        orderToUpdate.setquantity(newQuantity);
        orderToUpdate.settotal(500.00 * newQuantity);

        System.out.println("Update Quantity successfully!");
        System.out.println("New order Quantity: " + newQuantity);
        System.out.println("New order Value: " + (newQuantity * 500.00));

    } else if (updateOption == 2) {
        if ("Delivered".equals(orderToUpdate.getstatus()) || "Canceled".equals(orderToUpdate.getstatus())) {
            System.out.print("Can't change anything, sorry");
        } else {
            System.out.print("[1] Delivered Order\n[2] Cancel Order\n[3] Prepared Order\nEnter the new status: ");
            int newStatus = input.nextInt();
            input.nextLine();

            if (newStatus == 1) {
                orderToUpdate.setstatus("Delivered");
                System.out.println("Update status successfully!");
                System.out.println("New order status: Delivered");
            } else if (newStatus == 2) {
                if ("Delivered".equals(orderToUpdate.getstatus())) {
                    System.out.println("Sorry!! Can't cancel already delivered");
                } else {
                    orderToUpdate.setstatus("Canceled");
                    System.out.println("Update status successfully!");
                    System.out.println("New order status: Canceled");
                }
            } else if (newStatus == 3) {
                orderToUpdate.setstatus("Prepared");
                System.out.println("Update status successfully!");
                System.out.println("New order status: Prepared");
            } else {
                System.out.println("Invalid status selection.");
            }
        }
    }

    return "  complete";
}
        
     //////////////////////////////////////////////////////
     
   
    
    public String findCustomerIndex(int customerId) {
    for (int i = 0; i < orders.length; i++) {
        if (orders[i].getcus_id().equals(Integer.toString(customerId))) {
            return orders[i].getname();
        }
    }
    return null;
}
    

     public  int phoneNoValidate(int phoneNumbers) {
        int result = 0;
        int F_N = phoneNumbers / 1000000000;
        int r_N = phoneNumbers % 1000000000;
        int num = 1;
        int count = 0;

        while (r_N > 0) {
            count++;
            r_N = r_N / 10;
        }

        if ((F_N == 0 || F_N == +94) && count == 9 && phoneNumbers <= 999999999) {
            result = 1;
        }
        return result;
    }
    
     
     

}

