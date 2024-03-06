package account;


import java.util.List;

public interface AccountService {
    String deposit(Account dto);
    String withdraw(Account dto);
    String getBalance(String accountNumber);
}
