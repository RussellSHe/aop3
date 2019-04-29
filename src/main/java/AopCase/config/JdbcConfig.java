package AopCase.config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.mchange.v2.c3p0.DriverManagerDataSource;
import org.apache.commons.dbutils.QueryRunner;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;


/**
 * User: Russell
 * Date: 2019-04-24
 * Time: 23:39
 */
//@Configuration
//@ComponentScan("CaseDemo1")
public class JdbcConfig {
    @Value("${driver}")
    private String driver;
    @Value("${jdbcUrl}")
    private String url;
    @Value("${user}")
    private String name;
    @Value("${password}")
    private String pwd;
    @Bean(name="jt")
    public JdbcTemplate getJdbcTemplate(DataSource source){return  new JdbcTemplate(source);}
    @Bean(name = "source")
    public DataSource createDataSource() {
        try {
            DriverManagerDataSource pool = new DriverManagerDataSource();
            pool.setDriverClass(driver);
            pool.setJdbcUrl(url);
            pool.setUser(name);
            pool.setPassword(pwd);
            return pool;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return  null;
    }

}
