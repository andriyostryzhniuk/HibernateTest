package andrii.logic;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import javax.sql.DataSource;
import java.beans.PropertyVetoException;
import java.util.Properties;

@Configuration
@Component
@EnableTransactionManagement
public class DatabaseConfig {

    public static DataSource dataSource() {
        return createDataSource("127.0.0.1", "3306", "catering", "root", "qwerty");
    }

    public static DataSource createDataSource(String address,
                                              String port,
                                              String dbName,
                                              String dbUser,
                                              String dbPassword) {
        try {
            ComboPooledDataSource c3p0 = new ComboPooledDataSource();
            c3p0.setDriverClass("com.mysql.jdbc.Driver");
            c3p0.setJdbcUrl(String.format("jdbc:mysql://%s:%s/%s", address, port, dbName));
            c3p0.setUser(dbUser);
            c3p0.setPassword(dbPassword);

            Properties properties = new Properties();
            properties.setProperty("useSSL", "false");
            c3p0.setProperties(properties);

            return c3p0;
        } catch (PropertyVetoException e) {
            throw new RuntimeException(e);
        }
    }

    @Bean
    public LocalSessionFactoryBean sessionFactory () {

        LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
        sessionFactory.setDataSource(dataSource());
        sessionFactory.setPackagesToScan(new String[] { "andrii.data.model" });

        return sessionFactory;
    }

    @Bean
    @Autowired
    public HibernateTransactionManager transactionManager (SessionFactory sessionFactory) {
        HibernateTransactionManager transactionManager = new HibernateTransactionManager();

        transactionManager.setSessionFactory(sessionFactory);
        return transactionManager;
    }


}
