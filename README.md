# -lab-Bank-on-it-part-I-

# UML


## HasMenu (interface)
- menu(): String
- start(): void

## CheckingAccount
- balance: double
- CheckingAccount()
- CheckingAccount(balance: double)
- main(): void
- menu(): String
- start(): void
- getBalance(): double
- getBalanceString(): String
- setBalance(balance: double): void
- checkBalance(): void
- getDouble(): double
- makeDeposit(): void
- makeWithdrawal(): void

## SavingsAccount
- interestRate: double
- main(): void
- calcInterest(): void
- setInterestRate(rate: double): void
- getInterestRate(): double

## User (abstract)
- userName: String
- PIN: String
- login(): boolean
- login(userName: String, PIN: String): boolean
- setUserName(userName: String): void
- getUserName(): String
- setPIN(PIN: String): void
- getPIN(): String
- getReport(): String

## Customer
- checking: CheckingAccount
- savings: SavingsAccount
- main(): void
- Customer()
- Customer(userName: String, PIN: String)
- start(): void
- menu(): String
- changePIN(): void
- getReport(): String

## Relationships
- CheckingAccount implements HasMenu
- SavingsAccount extends CheckingAccount
- User implements HasMenu
- Customer extends User