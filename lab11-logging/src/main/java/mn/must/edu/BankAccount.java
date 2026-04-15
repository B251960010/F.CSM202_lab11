package mn.must.edu;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class BankAccount {
    private static final Logger logger = LogManager.getLogger(BankAccount.class);
    private double balance;

    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
        logger.info("Данс үүслээ. Эхний үлдэгдэл: {}", initialBalance);
    }

    public void deposit(double amount) {
        logger.trace("deposit() метод эхэллээ. Хэмжээ: {}", amount);
        if (amount < 0) {
            logger.warn("Буруу оролт: Сөрөг дүн {} оруулсан байна!", amount);
            return;
        }
        logger.debug("Хадгаламж хийхээс өмнөх үлдэгдэл: {}", balance);
        balance += amount;
        logger.info("{} төгрөг нэмэгдлээ. Шинэ үлдэгдэл: {}", amount, balance);
    }

    public void withdraw(double amount) {
        logger.trace("withdraw() метод эхэллээ.");
        if (amount > balance) {
            logger.error("Алдаа: Үлдэгдэл хүрэлцэхгүй байна! (Үлдэгдэл: {}, Авах дүн: {})", balance, amount);
            return;
        }
        balance -= amount;
        logger.info("{} төгрөг авлаа. Үлдсэн: {}", amount, balance);
    }

    public static void main(String[] args) {
        BankAccount account = new BankAccount(1000);
        account.deposit(500);      // INFO
        account.deposit(-100);     // WARN
        account.withdraw(2000);    // ERROR
        logger.fatal("Системийн критик алдааг дуурайлгав!"); // FATAL
    }
}