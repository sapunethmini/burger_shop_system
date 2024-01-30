/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.burger_oop_courdework;


import java.util.Arrays;
import java.util.Scanner;
public class Burger_oop_courdework {
 public static OrderList list = new OrderList(10);
    public static int listcount = 0;
    

    public static void main(String[] args) {
        int option;
        Order newOrder = null;
        Scanner input = new Scanner(System.in);

        do {
            System.out.println("---------------------------------------------------------------------------------------");
            System.out.println("|                                   iHungry Burger                                    |");
            System.out.println("---------------------------------------------------------------------------------------");

            System.out.println("[1] Place Order\t\t[2] Search Best Customer\n[3] Search Order\t\t[4] Search Customer\n[5] View Orders\t\t[6] Update Order Details\n[7] Exit  ");
            System.out.print("Enter an option to continue > ");
            option = input.nextInt();
            char choice = 'n';

            switch (option) {
                case 1: {
                    do {
                        newOrder = new Order();
                        newOrder.takeOrder();
                        newOrder.takePhoneNum();
                        newOrder.takeName();
                        int quantity = newOrder.takeQuantity();
                        newOrder.takeTotal(quantity);

                        list.add(newOrder); // Add the newOrder to the list

                        choice = newOrder.Confirmation();
                    } while (choice == 'y' || choice == 'Y');

                    break;
                    
                    
                    
                }
case 2: {
    String result = newOrder.search_best_customer(list.toArray());
    System.out.println(result);

    break;
}

case 3: {
    String result = newOrder.search_Order_Details(list.toArray());
    System.out.println(result);

    break;
}

case 4: {
    String result = newOrder.search_customer_Details(list.toArray());
    System.out.println(result);

    break;
}
 case 5: {
                System.out.println("[1] see Deliverd order List\n[2] see Preparing order List\n[3] see Cancled order List\n");
                System.out.print("Enter an option to continue: ");
                int selectedOption = input.nextInt();
                input.nextLine();
                String result = newOrder.veiw_order_list(new OrderList[]{list}, selectedOption);
                System.out.println(result);

                break;
            }

                 case 6: {
                System.out.print("Enter the order ID to update: ");
                String orderId = input.next();
                String result = newOrder.update_details(list.toArray(), orderId);
                System.out.println(result);
                break;
            }
                case 7: {
                    newOrder.exit();
                }
                default: {
                    System.out.println("Invalid choice");

                }
            }

        } while (true);
    }
}
