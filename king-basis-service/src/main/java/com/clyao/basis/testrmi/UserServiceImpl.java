package com.clyao.basis.testrmi;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Arrays;
import java.util.List;

public class UserServiceImpl extends UnicastRemoteObject implements UserService{

    private static final long serialVersionUID = -2787211821140324068L;

    protected UserServiceImpl() throws RemoteException {
        super();
    }

    @Override
    public List<User> selectAll() throws RemoteException{
        User user = new User();
        user.setName("king");
        user.setAge(20);
        return Arrays.asList(user);
    }
}
