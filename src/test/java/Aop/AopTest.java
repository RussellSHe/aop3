package Aop;

import AopCase.Service.IAccountService;
import AopCase.config.SpringConfig;
import AopCase.domain.Account;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * @ProjectName: aop3
 * @Package: Aop
 * @ClassName: AopTest
 * @Description:
 * @Author: zengyanbo
 * @CreateDate: 2019-04-28 14:06
 * @UpdateDate: 2019-04-28 14:06
 * @Version: 1.0
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes =SpringConfig.class)
public class AopTest {
    @Autowired
    private IAccountService ac;

    @Test
    public void transferTest(){
        ac.transfer("wangyi","sansan",1f);
    }

    @Test
    public void findAll(){
        List<Account> allAccount = ac.findAllAccount();
        allAccount.forEach(System.out::println);
    }
}
