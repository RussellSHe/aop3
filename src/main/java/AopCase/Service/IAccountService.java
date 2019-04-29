package AopCase.Service;

import AopCase.domain.Account;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ProjectName: aop2
 * @Package: AopCase.Service
 * @ClassName: IAccountService
 * @Description:
 * @Author: zengyanbo
 * @CreateDate: 2019-04-27 15:22
 * @UpdateDate: 2019-04-27 15:22
 * @Version: 1.0
 */

public interface IAccountService {

    List<Account> findAllAccount();
    Account findAccountById(int id);
    Account findAccountByName(String name);
    void saveAccount(Account ac);
    void updateAccount(Account ac);
    int deleteAccount(int id);

    void transfer(String src,String dst,float money);
}
