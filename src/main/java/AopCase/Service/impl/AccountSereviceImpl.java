package AopCase.Service.impl;

import AopCase.Service.IAccountService;
import AopCase.dao.IAccountDao;
import AopCase.domain.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @ProjectName: aop2
 * @Package: AopCase.Service.impl
 * @ClassName: AccountSereviceImpl
 * @Description:
 * @Author: zengyanbo
 * @CreateDate: 2019-04-27 15:24
 * @UpdateDate: 2019-04-27 15:24
 * @Version: 1.0
 */
@Service("accountService")
@Transactional(propagation = Propagation.SUPPORTS,readOnly = true)//只读事务
public class AccountSereviceImpl implements IAccountService {


    @Autowired
    private IAccountDao accountDao;

    public void setAccountDao(IAccountDao accountDao) {
        this.accountDao = accountDao;
    }

    @Override
    public int deleteAccount(int id) {
        return accountDao.deleteAccount(id);
    }

    @Override
    public List<Account> findAllAccount() {
        return accountDao.findAllAccount();
    }

    @Override
    public Account findAccountById(int id) {
        return accountDao.findAccountById(id);
    }

    @Override
    public Account findAccountByName(String name) {
        return accountDao.findAccountByName(name);
    }

    @Override
    public void saveAccount(Account ac) {
        accountDao.saveAccount(ac);
    }

    @Override
    public void updateAccount(Account ac) {
        accountDao.updateAccount(ac);

    }
    @Transactional(propagation = Propagation.REQUIRED,readOnly = false)//读写事务
    @Override
    public void transfer(String src, String dst, float money) {
        //执行操作
        Account srcAcconut = accountDao.findAccountByName(src);
        Account dstAcconut = accountDao.findAccountByName(dst);
        srcAcconut.setMoney(srcAcconut.getMoney()-money);
        dstAcconut.setMoney(dstAcconut.getMoney()+money);
        accountDao.updateAccount(srcAcconut);
        int i=1/0;
        accountDao.updateAccount(dstAcconut);
    }


}
