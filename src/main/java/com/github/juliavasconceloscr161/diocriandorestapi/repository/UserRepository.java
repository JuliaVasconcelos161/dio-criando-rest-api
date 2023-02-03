package com.github.juliavasconceloscr161.diocriandorestapi.repository;

import com.github.juliavasconceloscr161.diocriandorestapi.handler.BusinessException;
import com.github.juliavasconceloscr161.diocriandorestapi.handler.RequiredField;
import com.github.juliavasconceloscr161.diocriandorestapi.model.User;
import org.springframework.stereotype.Repository;


import java.util.ArrayList;
import java.util.List;

@Repository
public class UserRepository {
    public void save(User user){
        if(user.getLogin()==null){
            throw new RequiredField("Login");
        }

        if(user.getPassword()==null){
            throw new RequiredField("Password");
        }

        if(user.getId()==null){
            System.out.println("SAVE - Recebendo o usuário na camada de repositório.");
        } else {
            System.out.println("UPDATE - Recebendo o usuário na camada de repositório.");
        }

        System.out.println(user);
    }

    public void deleteById(Integer id){
        System.out.println(String.format("DELETE/id - Recebendo o id: %d para excluir um usuário.",id));
        System.out.println(id);
    }

    public List<User> findAll(){
        System.out.println("LIST - Listando os usuários do sistema");
        List<User> users = new ArrayList<>();
        users.add(new User("juliav","1234"));
        users.add(new User("giuv", "567"));
        return users;
    }

    public User findById(Integer id){
        System.out.println(String.format("FIND/id - Recebendo o id: %d para localizar um usuário.",id));
        return new User("juliavcr","123");
    }

    public User findByUserName(String nome){
        System.out.println(String.format("FIND/username - Recebendo o username"));
        return new User("juliavcr", "123");
    }

}
