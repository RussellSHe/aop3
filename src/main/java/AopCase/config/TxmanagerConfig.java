package AopCase.config;

import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;

/**
 * @ProjectName: aop3
 * @Package: AopCase.config
 * @ClassName: TxmanagerConfig
 * @Description:
 * @Author: zengyanbo
 * @CreateDate: 2019-04-28 14:20
 * @UpdateDate: 2019-04-28 14:20
 * @Version: 1.0
 */

public class TxmanagerConfig {
    /**
     * 创建事务管理类
     * @param ds
     * @return
     */
    @Bean("txManager")
    public PlatformTransactionManager createTxmanager(DataSource ds){
        return new DataSourceTransactionManager(ds);
    }
}
