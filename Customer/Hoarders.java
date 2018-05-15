
package Customer;


public class Hoarders extends Customer{

    public Hoarders(String name) {
        super(name,3);
    }


    @Override
    public int getRentDay() {
        return 7;
    }

    @Override
    public int getRentVideoNum() {
        return 3;
    }
    @Override
    public void printInformation() {
        System.out.println("Customer Name:" + customerName);
        System.out.println("Customer Type: " + "Hoarders");
    }
    
}
