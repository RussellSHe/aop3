package AopCase.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * User: Russell
 * Date: 2019-04-25
 * Time: 0:25
 * 配置类 相当于Beans.xml
 */
@ComponentScan("AopCase")
@Import({JdbcConfig.class,TxmanagerConfig.class})
@PropertySource("classpath:jdbcConfig.properties")
@EnableTransactionManagement
public class SpringConfig {
}
