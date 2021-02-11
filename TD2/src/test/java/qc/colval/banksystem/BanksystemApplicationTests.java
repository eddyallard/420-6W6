package qc.colval.banksystem;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import qc.colval.banksystem.entities.Account;
import qc.colval.banksystem.entities.Address;
import qc.colval.banksystem.entities.Client;
import qc.colval.banksystem.entities.User;
import qc.colval.banksystem.entities.enums.AccountType;
import qc.colval.banksystem.entities.enums.MaritalStatus;
import qc.colval.banksystem.entities.enums.Sex;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
class BanksystemApplicationTests {

    @Test
    void contextLoads() {
    }

    @Test
    void testBalance(){
        Account account = new Account();
        account.setType(AccountType.Checking);
        account.setBalance(50.78d);
        assertThat(account.getBalance()).isGreaterThan(50d);
        assertThat(account.getBalance()).isGreaterThanOrEqualTo(50.78d);
        assertThat(account.getBalance()).isEqualTo(50.78d);
        assertThat(account.getBalance()).isLessThanOrEqualTo(50.78d);
        assertThat(account.getBalance()).isLessThan(50.79d);
        assertThat(account.getBalance()).isNotEqualTo(67.78d);
    }

    @Test
    void testString(){
        Client client = new Client();
        client.setIncome(50000);
        client.setNip(1234);
        client.setMaritalStatus(MaritalStatus.Divorced);
        client.setEmail("jeanguy@gmail.com");
        client.setFirstName("Jean");
        client.setLastName("Guy");
        client.setPhoneNumber("957908656790");
        client.setSex(Sex.Male);

        assertThat(client.getEmail()).contains("@");
        assertThat(client.getEmail()).hasSizeLessThan(64);
        assertThat(client.getEmail()).hasSizeGreaterThan(8);
        assertThat(client.getEmail()).hasSizeBetween(8, 64);
    }

    @Test
    void testInstanceOf(){
        Client client = new Client();
        client.setIncome(50000);
        client.setNip(1234);
        client.setMaritalStatus(MaritalStatus.Divorced);
        client.setEmail("jeanguy@gmail.com");
        client.setFirstName("Jean");
        client.setLastName("Guy");
        client.setPhoneNumber("957908656790");
        client.setSex(Sex.Male);

        assertThat(client).isInstanceOf(User.class);
        assertThat(client).isNotInstanceOf(Address.class);
    }

    @Test
    void testEmpty(){
        Client client = new Client();
        client.setIncome(50000);
        client.setNip(1234);
        client.setMaritalStatus(MaritalStatus.Divorced);
        client.setEmail("jeanguy@gmail.com");
        client.setFirstName("Jean");
        client.setLastName("Guy");
        client.setPhoneNumber("957908656790");
        client.setSex(Sex.Male);

        assertThat(client.getManager()).isNull();
    }
}
