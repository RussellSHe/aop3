package AopCase.dao.impl;

import AopCase.dao.IAccountDao;
import AopCase.domain.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @ProjectName: aop2
 * @Package: AopCase.dao.impl
 * @ClassName: AccountDao
 * @Description:
 * @Author: zengyanbo
 * @CreateDate: 2019-04-27 21:51
 * @UpdateDate: 2019-04-27 21:51
 * @Version: 1.0
 */
@Repository("accountDao")
public class AccountDao implements IAccountDao {
    @Autowired
    private JdbcTemplate jt;

    public void setJt(JdbcTemplate jt) {
        this.jt = jt;
    }

    @Override
    public List<Account> findAllAccount() {
        return jt.query("select * from account",new BeanPropertyRowMapper<Account>(Account.class));
    }

    @Override
    public Account findAccountByName(String name) {
        List<Account> list = jt.query("select *from account where name=?", new BeanPropertyRowMapper<Account>(Account.class),name);
        if(list.isEmpty()){
            return null;
        }else if(list.size()>1){
            throw  new RuntimeException("结果不唯一");
        }else {
            return list.get(0);
        }
    }

    @Override
    public Account findAccountById(int id) {
        List<Account> list = jt.query("select *from account where id=?", new BeanPropertyRowMapper<Account>(Account.class), id);
       return list.isEmpty()?null:list.get(0);
    }

    @Override
    public void saveAccount(Account ac) {
        jt.update("insert into account(name,money)values(?,?)",ac.getName(),ac.getMoney());
    }

    @Override
    public void updateAccount(Account ac) {
        jt.update("update account set name=?,money=? where id=?",ac.getName(),ac.getMoney(),ac.getId());

    }

    @Override
    public int deleteAccount(int id) {

        return jt.update("delete from account where id=?",id);
    }


}
