package service;

import model.Account;

public interface AccountService {
    void insertAccount(Account account);
    boolean deleteAccount(int id);
    boolean updateAccount(Account account);
    Account selectAccount(int id);
    boolean checkLoginWebsite(String username, String password);
}
