package dev.n7meless.dota.security;

import dev.n7meless.dota.model.Role;
import dev.n7meless.dota.model.Status;
import dev.n7meless.dota.model.User;
import dev.n7meless.dota.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    private final UserRepository userRepository;


    @Autowired
    public UserDetailsServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username).orElseThrow(() ->
                new UsernameNotFoundException("User doesn't exists"));
        return SecurityUser.fromUser(user);
    }

    public boolean saveUser(User user) {
        Optional<User> userFromDB = userRepository.findByEmail(user.getEmail());
        if (!userFromDB.isEmpty()) {
            return false;
        }
        user.setRole(Role.USER);
        user.setStatus(Status.ACTIVE);
        user.setPassword(new BCryptPasswordEncoder(12).encode(user.getPassword()));
        userRepository.save(user);
        return true;
    }

}
