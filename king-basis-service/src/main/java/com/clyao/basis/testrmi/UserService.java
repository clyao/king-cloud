package com.clyao.basis.testrmi;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface UserService extends Remote {

    public List<User> selectAll() throws RemoteException;

}
