package AopCase.dao;

import AopCase.domain.Account;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @ProjectName: aop2
 * @Package: AopCase.dao
 * @ClassName: IAccountDao
 * @Description:
 * @Author: zengyanbo
 * @CreateDate: 2019-04-27 21:47
 * @UpdateDate: 2019-04-27 21:47
 * @Version: 1.0
 */

public interface IAccountDao {

    List<Account> findAllAccount();
    Account findAccountByName(String name);
    Account findAccountById(int id);
    void saveAccount(Account ac);
    void updateAccount(Account ac);
    int deleteAccount(int id);

}
