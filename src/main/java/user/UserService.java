package user;

import registration.RegistrationRequest;

import java.util.List;
import java.util.Optional;

public class UserService implements IUserService {
    private  UserRepository userRepository;
    @Override
    public List<User> getUsers() {
        return userRepository.findAll();
    }

    @Override
    public User registerUser(RegistrationRequest request) {
        Optional<User> user = this.findByEmail(request.email());
        if (user.isPresent()) {
            throw  new UserAlreadyExistsException("User with email " + request.email() + " already exists");
        }
        return null;
    }

    @Override
    public Optional<User> findByEmail(String email) {
        return userRepository.findByEmail(email);
    }
}
