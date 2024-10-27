import java.util.Scanner;

/*
Coffee machine
 3-5 recipes to choose from, balance of components for the day (for the reporting period), profit, income
 */
public class CoffeeMachine {
    Component[] store;
    double profit;

    public CoffeeMachine() {
        this.store = new Component[]{
                new Component("Coffee", 5, 10),
                new Component("Tea", 100, 1),
                new Component("Sugar", 3, 2),
                new Component("Milk", 6, 1.50)
        };
        this.profit = 0;
        start();
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);
        int mode;
        do {
            System.out.println("\nChoose a mode: 1 - Sale, 2 - Add components, 3 - Report, 0 - Exit");
            mode = scanner.nextInt();
            switch (mode) {
                case 1:
                    sale(scanner);
                    break;
                case 2:
                    addComponents(scanner);
                    break;
                case 3:
                    report();
                    break;
                case 0:
                    System.out.println("Exit");
                    break;
                default:
                    System.out.println("There is no such mode");
            }
        } while (mode != 0);
    }

    public void sale(Scanner scanner) {
        int choice;
        do {
            System.out.println("Take a choice: 1 - Coffee, 2 - Tea, 3 - Milk, 0 - Exit");
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("What Coffee do you want? 1 - standard, 2 - Double Coffee");
                    int coffeeQuantity = scanner.nextInt();
                    store[0].quantity -= 0.01 * coffeeQuantity;
                    profit += 0.01 * store[0].price * coffeeQuantity;
                    //
                    //                    if (coffeeQuantity == 1) {
                    //                        store[0].quantity -= 0.01;
                    //                    } else {
                    //                        store[0].quantity -= 0.02;
                    //                    }
                    System.out.println("with sugar? 1 - yes, 0 - no");
                    int coffeeSugarQuantity = scanner.nextInt();
                    store[2].quantity -= 0.01 * coffeeSugarQuantity;
                    profit += 0.01 * store[2].price * coffeeSugarQuantity;
                    //                    if (coffeeSugarQuantity == 1) {
                    //                        store[2].quantity -= 0.01;
                    //                    }
                    System.out.println("with milk? 1 - yes, 0 - no");
                    int coffeeMilkQuantity = scanner.nextInt();
                    store[3].quantity -= 0.02 * coffeeMilkQuantity;
                    profit += 0.02 * store[3].price * coffeeMilkQuantity;
                    //                    if (coffeeMilkQuantity == 1) {
                    //                        store[3].quantity -= 0.02;
                    //                    }
                    break;
                case 2:
                    store[1].quantity -= 1;
                    profit += 1;
                    System.out.println("With sugar? 1 - yes, 0 - no");
                    int teaSugarQuantity = scanner.nextInt();
                    if (teaSugarQuantity == 1) {
                        store[2].quantity -= 0.01;
                        profit += 0.01 * store[2].price;
                    }
                    break;
                case 3:
                    store[3].quantity -= 0.2;
                    profit += 0.2 * store[3].price;
                    break;
                case 0:
                    System.out.println("Exit to Main Menu");
            }
        } while (choice != 0);
    }

    public void addComponents(Scanner scanner) {
        int choice;
        do {
            System.out.println("Take a choice: 1 - Coffee, 2 - Tea, 3 - Sugar, 4 - Milk, 0 - Exit");
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("How much Coffee do you want to add?");
                    double coffeeQuantity = scanner.nextDouble();
                    store[0].quantity += coffeeQuantity;
                    break;
                case 2:
                    System.out.println("How many Tea do you want to add?");
                    int teaQuantity = scanner.nextInt();
                    store[1].quantity += teaQuantity;
                    break;
                case 3:
                    System.out.println("How much Sugar do you want to add?");
                    double sugarQuantity = scanner.nextDouble();
                    store[2].quantity += sugarQuantity;
                    break;
                case 4:
                    System.out.println("How much milk do you want to add?");
                    double milkQuantity = scanner.nextDouble();
                    store[3].quantity += milkQuantity;
                    break;
                case 0:
                    System.out.println("Exit to Main Menu");
                    break;
                default:
                    System.out.println("There is not such variant");
            }
        } while (choice != 0);
    }

    public void report() {
        System.out.println("Components list:");
        for (int i = 0; i < store.length; i++) {
            System.out.println(store[i]);
        }
        //TODO прибыль, доход
        System.out.println("Profit: " + profit);
        System.out.println("Income: " + profit * 0.45);
    }
}
