package com.project.stockmanagement.security;

import java.util.logging.Logger;

import com.project.stockmanagement.model.entity.UserAccount;
import com.project.stockmanagement.repository.IUserAccountDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CustomDaoBasedUserDetailsService implements UserDetailsService {
    @Autowired
    private IUserAccountDao userRepository; // the repository that manages users
    /** Utilisé pour la journalisation */
    private Logger LOGGER = Logger.getLogger(getClass().getName());
    // Implementation of the method to check the existence of an account
    // with the login passed in parameter
    @Override
    public UserDetails loadUserByUsername(String username) {
        UserAccount user = null;
        // We get the account with its username
        user = userRepository.getUserByUsername(username);
        // If not exists
        if (user == null) {
            String msg = "User  " + username + " has no permissions !.";
            // A warning message is written in the log file
            LOGGER.warning(msg);
            // This exception informs Spring security that the user does not exist
            // and therefore is not allowed to log in
            throw new UsernameNotFoundException(msg);
        }
        if (user.getRole() == null) {
            String msg = "User  " + username + " has no permissions !.";
            // A warning message is written in the log file
            LOGGER.warning(msg);
            // This exception informs Spring that the user has no authorization
            throw new UsernameNotFoundException(msg);
        }
        // Wrap the object of type UserAccount in an object of type UserPrincipal
        // which itself implements UserDetails.
        return new UserPrincipal(user);
    }
}
