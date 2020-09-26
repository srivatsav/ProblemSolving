package com.design.splitwise;

import com.design.splitwise.models.EqualSplit;
import com.design.splitwise.models.ExactSplit;
import com.design.splitwise.models.ExpenseType;
import com.design.splitwise.models.PercentageSplit;
import com.design.splitwise.models.Split;
import com.design.splitwise.models.User;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Driver {
  public static void main(String[] args) {
    ExpenseManager expenseManager = new ExpenseManager();
    expenseManager.addUser(new User("u1", "User1", "user1@gmail.com", "8888888888"));
    expenseManager.addUser(new User("u2", "User2", "user2@gmail.com", "8888888888"));
    expenseManager.addUser(new User("u3", "User3", "user3@gmail.com", "8888888888"));
    expenseManager.addUser(new User("u4", "User4", "user4@gmail.com", "8888888888"));

    Scanner sc = new Scanner(System.in);
    while (true) {
      String cmd = sc.nextLine();
      String[] commands = cmd.split(" ");
      String commandType = commands[0];
      switch (commandType) {
        case "SHOW":
          if (commands.length == 1) {
            expenseManager.showBalances();
          } else {
            expenseManager.showBalance(commands[1]);
          }
          break;
        case "EXPENSE":
          String paidBy = commands[1];
          Double amount = Double.parseDouble(commands[2]);
          int noOfUsers = Integer.parseInt(commands[3]);
          String expenseType = commands[4 + noOfUsers];
          List<Split> splits = new ArrayList<>();

          switch (expenseType) {
            case "EQUAL":
              for (int i = 0; i < noOfUsers; i++) {
                splits.add(new EqualSplit(expenseManager.userMap.get(commands[4+i])));
              }
              expenseManager.addExpense(amount, ExpenseType.EQUAL, paidBy, splits, null);
              break;
            case "EXACT":
              for (int i = 0; i < noOfUsers; i++) {
                splits.add(
                    new ExactSplit(
                        expenseManager.userMap.get(commands[4 + i]),
                        Double.parseDouble(commands[5 + noOfUsers + i])));
              }
              expenseManager.addExpense(amount, ExpenseType.EXACT, paidBy, splits, null);
              break;
            case "PERCENT":
              for (int i = 0; i < noOfUsers; i++) {
                splits.add(
                    new PercentageSplit(
                        expenseManager.userMap.get(commands[4 + i]),
                        Double.parseDouble(commands[5 + noOfUsers + i])));
              }
              expenseManager.addExpense(amount, ExpenseType.PERCENTAGE, paidBy, splits, null);
              break;
          }
          break;
        default:
          break;
      }
    }
  }
}
