import java.util.*;

abstract class PaymentProcessor
{
    public abstract void processPayment(double amount);
}

class CreditCardPaymentProcessor extends PaymentProcessor
{
    @Override 
    public void processPayment(double amount)
    {
        System.out.println("Processing credit card payment of $" + amount);
    }
}

class PayPalPaymentProcessor extends PaymentProcessor
{
    @Override 
    public void processPayment(double amount)
    {
        System.out.println("Processing PayPal payment of $" + amount);
    }
}

interface IVegetarianMenu
{
    List<String> getVegetarianItems();
}

interface INonVegetarianMenu
{
    List<String> getNonVegetarianItems();
}

interface IDrinkMenu
{
    List<String> getDrinkItems();
}

class VegetarianMenu implements IVegetarianMenu
{
    public List<String> getVegetarianItems()
    {
        return Arrays.asList("Veggie Sandwitch", "Paneer Roll", "Garden Salad");
    }
}

class NonVegetarianMenu implements INonVegetarianMenu
{
    public List<String> getNonVegetarianItems()
    {
        return Arrays.asList("Chicken Puff", "Egg Sandwitch", "Turkey Sub");
    }
}

class DrinkMenu implements IDrinkMenu
{
    public List<String> getDrinkItems()
    {
        return Arrays.asList("Coffee", "Tea", "Juice");
    }
}

class MenuDisplay
{
    public static void displayVegetarianMenu(IVegetarianMenu menu)
    {
        System.out.println("Vegetarian Menu:");
        for (String item : menu.getVegetarianItems())
        {
            System.out.println("- " + item);
        }
    }

    public static void displayNonVegetarianMenu(INonVegetarianMenu menu)
    {
        System.out.println("Non-Vegetarian Menu:");
        for (String item : menu.getNonVegetarianItems())
        {
            System.out.println("- " + item);
        }
    }

    public static void displayDrinkMenu(IDrinkMenu menu)
    {
        System.out.println("Drink Menu:");
        for (String item : menu.getDrinkItems())
        {
            System.out.println("- " + item);
        }
    }
}

class BreadBaker
{
    public void bakeBread()
    {
        System.out.println("Baking high-quality bread...");
    }
}

class InventoryManager
{
    public void manageInventory()
    {
        System.out.println("Managing inventory...");
    }
}

class SupplyOrder
{
    public void orderSupplies()
    {
        System.out.println("Ordering supplies...");
    }
}

class BakeryCleaner
{
    public void cleanBakery()
    {
        System.out.println("Cleaning the bakery...");
    }
}

class CustomerService
{
    private final PaymentProcessor paymentProcessor;

    public CustomerService(PaymentProcessor paymentProcessor)
    {
        this.paymentProcessor = paymentProcessor;
    }

    public void serveCustomer(double amount)
    {
        System.out.println("Serving customer...");
        paymentProcessor.processPayment(amount);
    }
}

public class Main 
{
    public static void main(String[] args) 
    {
        BreadBaker baker = new BreadBaker();
        InventoryManager inventoryManager = new InventoryManager();
        SupplyOrder supplyOrder = new SupplyOrder();
        BakeryCleaner bakeryCleaner = new BakeryCleaner();
        VegetarianMenu vegMenu = new VegetarianMenu();
        NonVegetarianMenu nonVegMenu = new NonVegetarianMenu();
        DrinkMenu drinkMenu = new DrinkMenu();
        CustomerService customerService = new CustomerService(new CreditCardPaymentProcessor());
        baker.bakeBread();
        inventoryManager.manageInventory();
        supplyOrder.orderSupplies();
        MenuDisplay.displayVegetarianMenu(vegMenu);
        MenuDisplay.displayNonVegetarianMenu(nonVegMenu);
        MenuDisplay.displayDrinkMenu(drinkMenu);
        customerService.serveCustomer(100.00);
        bakeryCleaner.cleanBakery();    
        System.out.println("New customer pays with PayPal...");
        CustomerService paypalService = new CustomerService(new PayPalPaymentProcessor());
        paypalService.serveCustomer(150.00);
    }
}