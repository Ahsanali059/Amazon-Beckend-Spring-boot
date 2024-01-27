package com.example.amazonclone.services.User;

import com.example.amazonclone.Repository.UserRepository;
import com.example.amazonclone.models.User;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

  private final UserRepository userRepository;

  public UserDetailsService userDetailsService() {
      return new UserDetailsService() {
          @Override
          public UserDetails loadUserByUsername(String username) {
              return userRepository.findByEmail(username)
                      .orElseThrow(() -> new UsernameNotFoundException("User not found"));
          }
      };
  }

  public User save(User newUser) {
    if (newUser.getId() == null) {
      newUser.setCreatedAt(LocalDateTime.now());
    }

    newUser.setUpdatedAt(LocalDateTime.now());
    return userRepository.save(newUser);
  }


    //get all Users
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    //get user by id

    public Optional<User> getUserById(Long userId) {
        return userRepository.findById(userId);
    }
    public void updateUser(Long userId, User updatedUser) {
        // Assuming you want to update existing user details
        Optional<User> existingUser = userRepository.findById(userId);
        existingUser.ifPresent(user -> {
            // Update user fields
            user.setFirstName(updatedUser.getFirstName());
            user.setLastName(updatedUser.getLastName());
            user.setEmail(updatedUser.getEmail());
            user.setPassword(updatedUser.getPassword());
            user.setRole(updatedUser.getRole());
            user.setUpdatedAt(LocalDateTime.now());

            // Save the updated user
            userRepository.save(user);
        });
    }

    public void deleteUser(Long userId) {
        userRepository.deleteById(userId);
    }


    public Optional<User> getUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }





}
