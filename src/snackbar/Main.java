package snackbar;


public class Main {
  public static void printMachine(VendingMachine machine) {
    System.out.println("Machine: " + machine.getName());
  }

  private static void printCustomerCash(Customer customer) {
    System.out.println(customer.getName() + "'s cash on hand: " + customer.getCashOnHand());
  }

  private static void printSnackQuantity(Snack snack) {
    System.out.println(snack.getName() + " quantity: " + snack.getQuantity());
  }

  private static void haveCustomerBuySnackQuantity(Customer customer, Snack snack, int quantity) {
    System.out.println(customer.getName() + " buys " + quantity + " " + snack.getName() + "(s)");
    snack.buyQuantity(quantity);
    customer.buySnacks(snack.getTotalCost(quantity));
    printCustomerCash(customer);
    printSnackQuantity(snack);
    System.out.println("");
  }

  private static void printSnackDetails(Snack snack, VendingMachine machine) {
    System.out.println("Snack: " + snack.getName());
    System.out.println("Vending Machine: " + machine.getName());
    System.out.println("Quantity: " + snack.getQuantity());
    System.out.println("Total Cost: " + snack.getTotalCost(snack.getQuantity()));
    System.out.println("");
  }

  public static void main(String[] args) {
    // CUSTOMERS
    Customer jane = new Customer("Jane", 45.25);
    Customer bob = new Customer("Bob", 33.14);


    // VENDING MACHINES
    VendingMachine food = new VendingMachine("Food");
    VendingMachine drink = new VendingMachine("Drink");
    VendingMachine office = new VendingMachine("Office");

    // Add snacks to food vending machine
    Snack chips = new Snack("Chips", 36, 1.75, food.getId());
    Snack chocolatebar = new Snack("Chocolate Bar", 36, 1.00, food.getId());
    Snack pretzel = new Snack("Pretzel", 30, 2.00, food.getId());

    // Add snacks to drink vending machine
    Snack soda = new Snack("Soda", 24, 2.50, drink.getId());
    Snack water = new Snack("Water", 20, 2.75, drink.getId());

    // Jane buys 3 sodas
    // soda.buyQuantity(3);
    // jane.buySnacks(soda.getTotalCost(3));
    // printCustomerCash(jane);
    // printSnackQuantity(soda);
    haveCustomerBuySnackQuantity(jane, soda, 3);

    // Jane buys 1 pretzel
    haveCustomerBuySnackQuantity(jane, pretzel, 1);

    // Bob buys 2 sodas
    haveCustomerBuySnackQuantity(bob, soda, 2);

    // Jane finds $10.00
    System.out.println("Jane finds $10.00");
    jane.addToCashOnHand(10.00);
    printCustomerCash(jane);
    System.out.println("");

    // Jane buys a chocolate bar
    haveCustomerBuySnackQuantity(jane, chocolatebar, 1);

    System.out.println("Add 12 pretzels");
    pretzel.addQuantity(12);
    printSnackQuantity(pretzel);
    System.out.println(""); 

    // Bob buys 3 pretzels
    haveCustomerBuySnackQuantity(bob, pretzel, 3);

    // print all snacks
    printSnackDetails(chips, food);
    printSnackDetails(chocolatebar, food);
    printSnackDetails(pretzel, food);
    printSnackDetails(soda, drink);
    printSnackDetails(water, drink);
  }
}