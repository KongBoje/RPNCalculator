/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.rpncalculator;

import java.util.Scanner;
import java.util.Stack;

/**
 *
 * @author Michael
 */
public class RPNCalc {

    private static Stack<Integer> stack = new Stack<Integer>();
    private static Scanner in = new Scanner(System.in);

    public static void calculator() {
        System.out.println("Calculator has started");

        getInput();
    }

    private static void getInput() {
        String input = " ";
        Stack<Integer> results = new Stack<Integer>();
        System.out.println("Enter the numbers you like, Q to quit. ");
        Boolean done = false;
        while (!done) {
            
            input = in.nextLine();
            for (String inp : input.split(" ")) {
                switch (inp) {
                    case "+":
                        results.push(results.pop() + results.pop());
                        break;
                    case "-":
                        {
                            Integer arg2 = results.pop();
                            results.push(results.pop() - arg2);
                            break;
                        }
                    case "*":
                    case "x":
                        results.push(results.pop() * results.pop());
                        break;
                    case "/":
                        {
                            Integer arg2 = results.pop();
                            results.push(results.pop() / arg2);
                            break;
                        }
                    case "Q":
                    case "q":
                        done = true;
                        break;
                    default:
                        results.push(Integer.parseInt(inp));
                        break;
                }
                System.out.println(">" + results);
            }
        }
    }

    public static void main(String[] args) {
        try {
            calculator();
        } catch (Exception e) {
            System.out.println("That doesn't work!");
        }
    }
}
