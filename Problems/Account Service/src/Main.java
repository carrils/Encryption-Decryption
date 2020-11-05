interface AccountService {
    /**
     * It finds an account by owner id
     * @param id owner unique identifier
     * @return account or null
     */
    Account findAccountByOwnerId(long id);
    /**
     * It counts the number of account with balance > the given value
     * @param value
     * @return the number of accounts
     */
    long countAccountsWithBalanceGreaterThan(long value);
}

// Declare and implement your AccountServiceImpl here

class Account {

    private long id;
    private long balance;
    private User owner;

    public Account(long id, long balance, User owner) {
        this.id = id;
        this.balance = balance;
        this.owner = owner;
    }

    public long getId() { 
        return id; 
    }

    public long getBalance() { 
        return balance; 
    }

    public User getOwner() { 
        return owner; 
    }
}

class User {

    private long id;
    private String firstName;
    private String lastName;

    public User(long id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public long getId() { 
        return id; 
    }

    public String getFirstName() { 
        return firstName; 
    }

    public String getLastName() { 
        return lastName; 
    }
}

class AccountServiceImpl implements AccountService {
    Account[] accounts;
    public AccountServiceImpl (Account[] accountArray){
        this.accounts = accountArray.clone();
    }

    @Override
    public Account findAccountByOwnerId(long id) {
        Account tempAccount = null;
        for(Account account : accounts){
            if (account.getOwner().getId() == id){
                tempAccount = account;
            }
        }
        return tempAccount;
    }

    @Override
    public long countAccountsWithBalanceGreaterThan(long value) {
        long numAccounts = 0;
        for(Account account : accounts){
            if (account.getBalance() > value){
                numAccounts++;
            }
        }
        return numAccounts;
    }
}