package com.clyao.basis.testrmi;

import java.rmi.Naming;
import java.rmi.Remote;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class UserRMIClient {

    public static void main(String[] args) {
        try {
            Registry registry = LocateRegistry.getRegistry();
            System.out.println(registry);
            UserService userService = (UserService) registry.lookup("user");
            //UserService userService = (UserService) Naming.lookup("rmi://localhost:1099/user");
            System.out.println(userService.selectAll());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
