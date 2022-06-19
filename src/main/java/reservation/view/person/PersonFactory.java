package reservation.view.person;

public class PersonFactory {

    public static Person getPerson(String choice) {
        Person person;
        switch (choice) {
            case "customer" :
                person = new Customer();
                break;
            case "admin":
                person = new Admin();
                break;
            default:
                person = null;
                break;
        }
        return person;
    }

}
