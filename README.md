# Quick Start

```
mkdir bin
javac -d bin src\account\*.java src\exception\*.java src\Application.java
java -cp bin Main
```

# 各個檔案用途解釋
### Main.java
main function 所在地，用於呼叫 Tester 物件進行測試

### Tester.java
用於撰寫各個帳號種類、情境的測試函式

### BankCalendar.java
用於紀錄時間的靜態物件，內部包含以年月日為單位快進的函式，所有帳號的時間都以這個物件為準

### Account.java
所有帳號種類都需繼承的父介面，內部定義了所有帳號種類都需實作的五個函式  
- deposit
- withdraw
- name
- balance
- compute_interest
