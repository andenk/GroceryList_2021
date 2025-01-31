package se.iths.grocerylist.service;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import se.iths.grocerylist.entity.RoleEntity;
import se.iths.grocerylist.entity.UserEntity;
import se.iths.grocerylist.repository.RoleRepository;
import se.iths.grocerylist.repository.UserRepository;

import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;
    private BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
    private final RoleRepository roleRepository;

    public UserService(UserRepository userRepository, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }

    public UserEntity createUser(UserEntity user) {

        //Defaultanvändare
        // userRepository.save(new UserEntity("Customer1", "email", "a", "b", "123"));
        // UserEntity customer1 = userRepository.findByUsername("Customer1");
        //customer1.setPassword(passwordEncoder.encode(customer1.getPassword()));
        // RoleEntity roleToAdd1 = roleRepository.findByRoleName("ROLE_CUSTOMER");
        //  customer1.setRole(roleToAdd1);

        user.setPassword(passwordEncoder.encode(user.getPassword()));
        RoleEntity roleToAdd = roleRepository.findByRoleName("ROLE_CUSTOMER");
        user.setRole(roleToAdd);
        return userRepository.save(user);
    }

    public Optional<UserEntity> findUserById(Long id) {
        return userRepository.findById(id);
    }

    public Iterable<UserEntity> findAllUsers() {
        return userRepository.findAll();
    }

    public UserEntity updateUser(UserEntity user) {
        return userRepository.save(user);
    }

    public Optional<UserEntity> updateUserEmail(Long id, String email) {
        Optional<UserEntity> foundUser = userRepository.findById(id);
        foundUser.get().setEmail(email);
        userRepository.save(foundUser.get());
        return foundUser;

    }

    public void deleteUser(Long id) {
        Optional<UserEntity> foundUser = userRepository.findById(id);
        userRepository.deleteById(foundUser.get().getId());
    }


}

