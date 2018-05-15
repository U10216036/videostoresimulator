

package Customer;

public class Regular extends Customer{

    public Regular(String name) {
        super(name,3);
    }


    @Override
    public int getRentDay() {
        return rand.nextInt(4) + 2;
    }

    @Override
    public int getRentVideoNum() {
        return rand.nextInt(3) + 1;
    }
    @Override
    public void printInformation() {
        System.out.println("Customer Name:" + customerName);
        System.out.println("Customer Type: " + "Regular");
    }
}

