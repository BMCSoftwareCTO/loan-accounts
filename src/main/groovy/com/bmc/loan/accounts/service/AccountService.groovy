package com.bmc.loan.accounts.service

import org.springframework.stereotype.Service

import com.bmc.loan.accounts.model.Account
@Service
class AccountService {
    
    Map<String, Account> accounts

    AccountService() {
        accounts = new HashMap<String, Account>()
        accounts.put("Walter White", new Account("Walter White", "1234567890"))
        accounts.put("Tim Whatley", new Account("Tim Whatley", "0987654321"))
        accounts.put("Bryan Cranston", new Account("Bryan Cranston", "76859403021"))
        accounts.put("Hal Wilkerson", new Account("Hal Wilkerson", "1029384756"))
    }
    
    List<Account> findAll() {
        def accountList = new ArrayList<String>()
        for(def acct : accounts.entrySet()) {
            accountList.add(acct.getValue())
        }
        
        return accountList
    }
    
    Account findOne(String name) {
        return accounts.get(name)
    }
}
