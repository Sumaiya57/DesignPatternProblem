import java.util.ArrayList;
import java.util.List;

abstract class Pizza {
    protected String description;
    
    public Pizza() {
        this.description = "Plain Pizza";
    }
    
    public String getDescription() {
        return description;
    }
    
    public abstract double cost();
}

class ToppingDecorator extends Pizza {
    protected Pizza pizza;
    
    public ToppingDecorator(Pizza pizza) {
        this.pizza = pizza;
    }
    
    public String getDescription() {
        return pizza.getDescription();
    }
    
    public double cost() {
        return pizza.cost();
    }
}

class Cheese extends ToppingDecorator {
    public Cheese(Pizza pizza) {
        super(pizza);
    }
    
    public String getDescription() {
        return pizza.getDescription() + ", Cheese";
    }
    
    public double cost() {
        return pizza.cost() + 3.0; 
    }
}

class Pepperoni extends ToppingDecorator {
    public Pepperoni(Pizza pizza) {
        super(pizza);
    }
    
    public String getDescription() {
        return pizza.getDescription() + ", Pepperoni";
    }
    
    public double cost() {
        return pizza.cost() + 5.00; 
    }
}

public class PizzaOrder {
    public static void main(String[] args) {
        // Order a plain pizza
        Pizza pizza = new PlainPizza();
        System.out.println("Description: " + pizza.getDescription());
        System.out.println("Cost: tk" + pizza.cost());
        
        // Order a pizza with cheese
        pizza = new Cheese(pizza);
        System.out.println("Description: " + pizza.getDescription());
        System.out.println("Cost: $" + pizza.cost());
        
        // Order a pizza with cheese and pepperoni
        pizza = new Pepperoni(pizza);
        System.out.println("Description: " + pizza.getDescription());
        System.out.println("Cost: tk" + pizza.cost());
    }
}
