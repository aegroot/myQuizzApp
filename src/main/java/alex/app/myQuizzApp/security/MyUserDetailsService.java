package alex.app.myQuizzApp.security;

import alex.app.myQuizzApp.security.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.management.relation.Role;

@Service
public class MyUserDetailsService implements UserDetailsService {


    UserRepository userRepository;

    @Autowired
    public MyUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        var details=userRepository.findByEmail(username);

        if (details.isEmpty()){
            throw new UsernameNotFoundException("not found");
        }

        return details.get();
    }
}
