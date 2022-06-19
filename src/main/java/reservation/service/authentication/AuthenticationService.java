package reservation.service.authentication;

import reservation.model.user.User;
import reservation.service.customer.CustomerService;
import reservation.service.data.TestData;

public class AuthenticationService {

    private volatile static AuthenticationService authenticationService;

    private AuthenticationService() {

    }

    public static AuthenticationService getInstance() {

        if (authenticationService == null) {
            synchronized (CustomerService.class) {
                if (authenticationService == null) {
                    authenticationService = new AuthenticationService();
                }
            }
        }
        return authenticationService;
    }

    public User login(String userId) {
        return TestData.getAllUsers().get(userId);
    }

}
