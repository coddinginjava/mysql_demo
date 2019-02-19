package sai.service.mysql_demo.User;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "users")
public class UserDTO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "name")
    private  String name;

    @Column(name = "empid")
    private String empid;

    @Column(name = "department")
    private String department;
}

