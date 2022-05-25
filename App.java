import java.util.Scanner;

public class App {
  public static void main(String args[]) {
    boolean tollTag;
    boolean gps;
    boolean roadside;

    Scanner input = new Scanner(System.in);
    System.out.println("What is the pickup date?");
    String date = input.next();
    System.out.println("How many days will you be renting?");
    int daysOfRental = input.nextInt();
    System.out.println("Would you like an electronic toll tag at $3.95? (y/n)");
    if (input.next().contains("y")) {
      tollTag = true;
    } else {
      tollTag = false;
    }
    System.out.println("Would you like  a GPS at $2.95/day(y/n)");
    if (input.next().contains("y")) {
      gps = true;
    } else {
      gps = false;
    }
    System.out.println("Would you like roadside assistance at $3.95/day? (y/n)");
    if (input.next().contains("y")) {
      roadside = true;
    } else {
      roadside = false;
    }
    System.out.println("What is your age?");
    int age = input.nextInt();
    input.close();

    double basicCarRental = basicCarRental(daysOfRental);
    double optionsCost = optionsCost(daysOfRental, tollTag, gps, roadside);
    double surcharge = (basicCarRental * ageSurcharge(age)) - basicCarRental;
    double totalCost = (basicCarRental * ageSurcharge(age)) + optionsCost;

    System.out.println("The cost of the basic car rental is " + basicCarRental);
    System.out.println("The cost of the options you've chosen is " + optionsCost);
    System.out.println("The age surcharge is " + surcharge);
    System.out.println("And lastly, the the total cost of the rental is " + totalCost);

  }

  private static double basicCarRental(int daysOfRental) {
    return 29.99 * daysOfRental;
  }

  private static double optionsCost(int daysOfRental, boolean tollTag, boolean gps, boolean roadside) {
    if (tollTag && gps && roadside) {
      return daysOfRental * 10.85;
    } else if (gps && (tollTag || roadside)) {
      return daysOfRental * 6.90;
    } else if (tollTag && roadside) {
      return daysOfRental * 7.90;
    } else if (tollTag || roadside) {
      return daysOfRental * 3.95;
    } else if (gps) {
      return daysOfRental * 2.95;
    } else {
      return 0;
    }
  }

  private static double ageSurcharge(int age) {
    if (age < 25) {
      return 1.30;
    } else {
      return 1;
    }
  }
}
