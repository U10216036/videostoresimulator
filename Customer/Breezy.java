
package Customer;


public class Breezy extends Customer{

    public Breezy(String customerName) {
        super(customerName,2);
    }


    @Override
    public int getRentDay() {
        return rand.nextInt(2) + 1;
    }

    @Override
    public int getRentVideoNum() {
        return rand.nextInt(2) + 1;
    }

    @Override
    public void printInformation() {
        System.out.println("Customer Name:" + customerName);
        System.out.println("Customer Type: " + "Breezy");
    }
    
}
