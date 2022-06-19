package reservation.view;

import reservation.view.person.Person;
import reservation.view.person.PersonFactory;
import reservation.view.util.ClientUtil;
import java.util.Optional;

public class ReservationClient<T> {

    public static void main(String[] args) {
        System.out.println("*********** Welcome to our reservation system *************");
        Optional<String> option;
        Optional<String> result = Optional.empty();
        do {
            System.out.println("*********** Are you a customer or admin ? *************");
            Person person;
            do {
                option = ClientUtil.readText();
                person = PersonFactory.getPerson(option.get());
                if (person == null) {
                    System.out.println("Please enter valid option");
                } else {
                     person.process();
                }
            } while (person == null);

            System.out.println("You logged out! do you want login again(yes/no)");
            option = ClientUtil.readText();
        } while ("yes".equalsIgnoreCase(option.get()));
    }
}
