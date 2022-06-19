package reservation.controller.authentication;

import reservation.model.user.User;
import reservation.service.customer.CustomerService;
import reservation.service.authentication.AuthenticationService;

public class AuthenticationController {

    private volatile static AuthenticationController authenticationController;
    private final AuthenticationService authenticationService;

    private AuthenticationController() {
        authenticationService = AuthenticationService.getInstance();
    }

    public static AuthenticationController getInstance() {

        if (authenticationController == null) {
            synchronized (CustomerService.class) {
                if (authenticationController == null) {
                    authenticationController = new AuthenticationController();
                }
            }
        }
        return authenticationController;
    }

    public User login(String userId) {
        return authenticationService.login(userId);
    }



}
