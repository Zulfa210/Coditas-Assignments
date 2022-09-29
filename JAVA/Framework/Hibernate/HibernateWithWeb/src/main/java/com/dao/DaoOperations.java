package com.dao;

/**
 * @author Zulfa Attar
 */
public interface DaoOperations {

    public int insertAccount();
    public int deleteAccount(int accountNumber);
    public int updateAccount(int accountNumber, String property, String value);
}
