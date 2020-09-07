package com.example.internal.shared.infrastructure;

import org.apache.tomcat.dbcp.dbcp2.BasicDataSource;
import org.hibernate.cfg.AvailableSettings;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.stream.Collectors;

@Configuration
@EnableTransactionManagement
public class HibernateConfiguration {

    // Esto nos provee la instancia
    @Bean
    public LocalSessionFactoryBean sessionFactory() {
        LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
        sessionFactory.setDataSource(dataSource());
        sessionFactory.setHibernateProperties(hibernateProperties());
        List<Resource> mappingFiles = searchMappingFiles();

        sessionFactory.setMappingLocations(mappingFiles.toArray(new Resource[mappingFiles.size()]));


        return sessionFactory;
    }

    private List<Resource> searchMappingFiles()  {
        String path = "./src/internal/main/com/example/internal/";

        String[] modules = subdirectoriesFor(path);
        List<String> goodPaths = new ArrayList<>();

        for (String module: modules) {
            String[] files = mappingFilesIn(path + module + "/infrastructure/hibernate");

            for (String file: files) {
                goodPaths.add("C:/Users/junci/IdeaProjects/demo/src/internal/main/com/example/internal/courses/infrastructure/hibernate/" + file);
            }
        }

        return goodPaths.stream().map(FileSystemResource::new).collect(Collectors.toList());
    }

    private String[]subdirectoriesFor(String path) {
        String[] files = new File(path).list((current, name) -> new File(current, name).isDirectory());

        if (null == files) {
            return new String[0];
        }

        return files;
    }

    private String[] mappingFilesIn(String path) {

        String[] files = new File(path).list((current, name) -> new File(current, name).getName().contains(".hbm.xml"));

        if (null == files) {
            return new String[0];
        }

        return files;
    }

    @Bean
    public DataSource dataSource() {
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUrl(
                "jdbc:mysql://93.189.89.145:3306/test?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC"
        );
        dataSource.setUsername("angel");
        dataSource.setPassword("2G66YgKcuv*+UkW*");

        return dataSource;
    }

    @Bean
    public PlatformTransactionManager hibernateTransactionManager() {
        HibernateTransactionManager transactionManager
                = new HibernateTransactionManager();
        transactionManager.setSessionFactory(sessionFactory().getObject());
        return transactionManager;
    }

    // Considerado antipatron ahcer esto en XML por fuera de spring
    private Properties hibernateProperties() {
        Properties hibernateProperties = new Properties();
        // Si quiero cadav vez que ejecuto una query que mire si hay la tabla y si no que la cree
        // No delego la creacion de tablas a mi ORM
        hibernateProperties.put(AvailableSettings.HBM2DDL_AUTO, "none");
        hibernateProperties.put(AvailableSettings.SHOW_SQL, "false");
        hibernateProperties.put(AvailableSettings.DIALECT, "org.hibernate.dialect.MySQL8Dialect");

        return hibernateProperties;
    }

}
