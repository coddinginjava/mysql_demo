package sai.service.mysql_demo.service;

import lombok.AllArgsConstructor;
import sai.service.mysql_demo.User.UserDTO;
import sai.service.mysql_demo.repository.UsersRepository;
import sai.service.mysql_demo.restTemplate.UserRestTemplate;

import java.util.List;
import java.util.Optional;

@org.springframework.stereotype.Service
@AllArgsConstructor
public class Service {

    private final UsersRepository usersRepository;
    private final UserRestTemplate restTemplate;

    public String testMethodService() {
        return "Spring boot is up and running";
    }

    public Optional<UserDTO> getuserbyId(Integer id) {
        return usersRepository.findById(id);
    }

    public List<UserDTO> getalluser() {
        return usersRepository.findAll();
    }

    public UserDTO addUsers(UserDTO user) {
        return usersRepository.save(user);
    }


    public String testConnectionMethodService() {
        return restTemplate.checkConnection();
    }
}
