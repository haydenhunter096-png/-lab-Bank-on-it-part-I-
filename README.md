# -lab-Bank-on-it-part-I-

+ menu(): String
+ start(): void

- balance: double

+ CheckingAccount()
+ CheckingAccount(balance: double)
+ main(): void
+ menu(): String
+ start(): void
+ getBalance(): double
+ getBalanceString(): String
+ setBalance(balance: double): void
+ checkBalance(): void
- getDouble(): double
+ makeDeposit(): void
+ makeWithdrawal(): void

- interestRate: double

+ main(): void
+ calcInterest(): void
+ setInterestRate(rate: double): void
+ getInterestRate(): double

- userName: String
- PIN: String

+ login(): boolean
+ login(userName: String, PIN: String): boolean
+ setUserName(userName: String): void
+ getUserName(): String
+ setPIN(PIN: String): void
+ getPIN(): String
+ getReport(): String (abstract)

- checking: CheckingAccount
- savings: SavingsAccount

+ main(): void
+ Customer()
+ Customer(userName: String, PIN: String)
+ start(): void
+ menu(): String
+ changePIN(): void
+ getReport(): String