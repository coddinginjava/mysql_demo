package sai.service.mysql_demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sai.service.mysql_demo.User.UserDTO;

public interface UsersRepository extends JpaRepository<UserDTO, Integer> {
}
