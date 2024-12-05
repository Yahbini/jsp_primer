package com.demo.models;

import com.demo.entity.Account;
import org.mindrot.jbcrypt.BCrypt;

import java.util.List;
import java.util.Optional;

public class AccountModel {
    private List<Account> accounts;

    public AccountModel() {
        accounts = List.of(
                new Account("acc1", "$2a$10$VvhUNOecvSm1.9ZNXv9vA.zkzpZjbn6MmvXf3paV4BZQPABI6Nvra", "Name 1"),
                new Account("acc2", "$2a$10$PK1h5b7iuD.dWO8H9ZOiPumdnJnHLZs3cgL0crm6G/Ono5g3q5/je", "Name 2"),
                new Account("acc3", "$2a$10$lUMJ7541GgrM1vC5d9NSGeD99hs9.UoZOYLAlntPPhmPyTXvMfIoC", "Name 3")
        );
    }

    public boolean login(String username, String password) {
        Optional<Account> account = accounts.stream().filter(a -> a.getUsername().equals(username)).findFirst();
        if(account.isPresent()) {
            return BCrypt.checkpw(password, account.get().getPassword());
        }
        return false;
    }
}
