# -lab-Bank-on-it-part-II-

# UML


classDiagram

class HasMenu {
  <<interface>>
  +menu() String
  +start() void
}

class CheckingAccount {
  -double balance
  +CheckingAccount()
  +CheckingAccount(double balance)
  +main() void
  +menu() String
  +start() void
  +getBalance() double
  +getBalanceString() String
  +setBalance(double balance) void
  +checkBalance() void
  -getDouble() double
  +makeDeposit() void
  +makeWithdrawal() void
}

class SavingsAccount {
  -double interestRate
  +main() void
  +calcInterest() double
  +setInterestRate(double rate) void
  +getInterestRate() double
}

class User {
  <<abstract>>
  -String userName
  -String PIN
  +login() boolean
  +login(String userName, String PIN) boolean
  +setUserName(String userName) void
  +getUserName() String
  +setPIN(String PIN) void
  +getPIN() String
  +getReport() String
}

class Customer {
  -CheckingAccount checking
  -SavingsAccount savings
  +Customer()
  +Customer(String userName, String PIN)
  +start() void
  +menu() String
  +changePIN() void
  +getReport() String
}

class Admin {
  +Admin()
  +menu() void
  +start() void
  +getReport() String
}

class CustomerList {
}

class Bank {
  -Admin admin
  -CustomerList customers
  +Bank()
  +menu() void
  +start() void
  -startAdmin() void
  -loginCustomer() void
  -fullCustomerReport() void
  -addUser() void
  -applyInterest() void
  -saveCustomers() void
  -loadCustomers() void
  -loadSampleCustomers() void
}

CheckingAccount ..|> HasMenu
User ..|> HasMenu
SavingsAccount --|> CheckingAccount
Customer --|> User
Admin --|> User
CustomerList --|> ArrayList
Bank --> Admin
Bank --> CustomerList
