/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.burger_oop_courdework;

import java.util.Arrays;

public class OrderList {
    private Order[] dataArray;
    private int nextIndex;
    private int capacity;
    private String order_id;
    private String cus_id;
    private String name;
    private double total;
    private String status;
    private int quantity;

    public OrderList(int capacity) {
        this.dataArray = new Order[capacity];
        this.capacity = capacity;
        this.nextIndex = 0;
    }

    private void extendsArray() {
        Order[] tempDataArray = new Order[(int) (dataArray.length * 1.5)];
        System.arraycopy(dataArray, 0, tempDataArray, 0, dataArray.length);
        dataArray = tempDataArray;
        capacity = dataArray.length;
    }

    public boolean isFull() {
        return nextIndex >= capacity;
    }

    public void add(Order data) {
        if (isFull()) {
            extendsArray();
        }
        dataArray[nextIndex++] = data;
    }

    public Order get(int index) {
        if (index >= 0 && index < nextIndex) {
            return dataArray[index];
        } else {
            return null;
        }
    }

    public void add(int index, Order data) {
        if (index >= 0 && index <= nextIndex) {
            if (isFull()) {
                extendsArray();
            }
            System.arraycopy(dataArray, index, dataArray, index + 1, nextIndex - index);
            dataArray[index] = data;
            nextIndex++;
        }
    }

    public void clear() {
        nextIndex = 0;
    }

    public int size() {
        return nextIndex;
    }

    public void printList() {
        System.out.print("[");
        for (int i = 0; i < nextIndex; i++) {
            System.out.print(dataArray[i] + ", ");
        }
        System.out.println(isEmpty() ? "empty]" : "\b\b]");
    }

    public boolean isEmpty() {
        return nextIndex <= 0;
    }

    public boolean contains(Order data) {
        for (int i = 0; i < nextIndex; i++) {
            if (dataArray[i].getorder_id().equals(data.getorder_id())) {
                return true;
            }
        }
        return false;
    }

    public Order peek() {
        if (isEmpty()) {
            return null; //throws an Exception
        }
        return dataArray[0];
    }

    public Order[] toArray() {
        Order[] temp = new Order[nextIndex];
        System.arraycopy(dataArray, 0, temp, 0, nextIndex);
        return temp;
    }

    public String getorder_id() {
        return order_id;
    }

    public void setorder_id(String order_id) {
        this.order_id = order_id;
    }

    public String getcus_id() {
        return cus_id;
    }

    public void setcus_id(String cus_id) {
        this.cus_id = cus_id;
    }

    public String getname() {
        return name;
    }

    public void setname(String name) {
        this.name = name;
    }

    public double gettotal() {
        return total;
    }

    public void settotal(double total) {
        this.total = total;
    }

    public int getquantity() {
        return quantity;
    }

    public void setquantity(int quantity) {
        this.quantity = quantity;
    }

    public String getstatus() {
        return status;
    }

    public void setstatus(String status) {
        this.status = status;
    }

    public void takeOrder() {
        // Implement your logic here
    }
}
