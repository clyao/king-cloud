package com.clyao.basis.testrmi;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class UserRMIService {

    public static void main(String[] args) {
        try {
            UserService userService = new UserServiceImpl();
            LocateRegistry.createRegistry(1099);
            Registry registry = LocateRegistry.getRegistry();
            registry.bind("user", userService);
            System.out.println(registry.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
