package AopCase.utils;

import AopCase.Service.IAccountService;
import AopCase.config.SpringConfig;
import AopCase.domain.Account;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

/**
 * @ProjectName: aop2
 * @Package: AopCase.utils
 * @ClassName: JdbcTemplateDeomo
 * @Description:
 * @Author: zengyanbo
 * @CreateDate: 2019-04-27 21:27
 * @UpdateDate: 2019-04-27 21:27
 * @Version: 1.0
 */

public class JdbcTemplateDeomo {
    public static void main(String[] args) {

        //AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        IAccountService accountService = (IAccountService)context.getBean("accountService");

        /*List<Account> allAccount = accountService.findAllAccount();
        allAccount.forEach(System.out::println);*/
       /* Account sansan = accountService.findAccountByName("sansan");
        System.out.println(sansan);*/
       accountService.transfer("sansan","wangyi",1f);


    }
}
