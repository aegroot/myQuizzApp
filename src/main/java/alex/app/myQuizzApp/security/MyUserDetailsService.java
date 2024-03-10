package alex.app.myQuizzApp.security;

import alex.app.myQuizzApp.security.user.User;
import alex.app.myQuizzApp.security.user.UserRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MyUserDetailsService  implements UserDetailsService{

    private final UserRepository userRepository;

    public MyUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Optional<User>userOptional=userRepository.findByUsername(username);
        System.out.println("loading users");

        System.out.println(username);

        if (userOptional.isEmpty())
            throw new UsernameNotFoundException(username);

        System.out.println(userOptional.get());


        return userOptional.get();
    }
}
