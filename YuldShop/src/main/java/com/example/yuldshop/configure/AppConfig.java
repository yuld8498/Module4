package com.example.yuldshop.configure;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.example.yuldshop.service.LocationRegion.ILocationRegionService;
import com.example.yuldshop.service.LocationRegion.LocationRegionService;
//import com.example.yuldshop.service.ProductImgService.IProductImgService;
import com.example.yuldshop.service.Role.IRoleService;
import com.example.yuldshop.service.Role.RoleService;
import com.example.yuldshop.service.category.CategoryService;
import com.example.yuldshop.service.category.ICategoryService;
import com.example.yuldshop.service.customer.CustomerServiceImp;
import com.example.yuldshop.service.customer.ICustomerService;
import com.example.yuldshop.service.order.IOrderService;
import com.example.yuldshop.service.order.OrderServiceImp;
import com.example.yuldshop.service.orderItems.IOrderItemService;
import com.example.yuldshop.service.orderItems.OrderItemServiceImp;
import com.example.yuldshop.service.product.IProductService;
import com.example.yuldshop.service.product.ProductService;
import com.example.yuldshop.service.user.IUserService;
import com.example.yuldshop.service.user.UserService;
import lombok.NonNull;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.web.config.EnableSpringDataWebSupport;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.thymeleaf.spring5.SpringTemplateEngine;
import org.thymeleaf.spring5.templateresolver.SpringResourceTemplateResolver;
import org.thymeleaf.spring5.view.ThymeleafViewResolver;
import org.thymeleaf.templatemode.TemplateMode;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@EnableWebMvc
@EnableTransactionManagement
@ComponentScan("com.example.yuldshop")
@EnableJpaRepositories("com.example.yuldshop.repository")
@EnableSpringDataWebSupport
public class AppConfig implements WebMvcConfigurer, ApplicationContextAware {
    private ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(@NonNull ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    @Bean
    public ICustomerService customerService() {
        return new CustomerServiceImp();
    }

    @Bean
    public ILocationRegionService locationRegionService() {
        return new LocationRegionService();
    }

    @Bean
    public IProductService productService() {
        return new ProductService();
    }

    @Bean
    public ICategoryService categoryService() {
        return new CategoryService();
    }

    @Bean
    public IRoleService roleService() {
        return new RoleService();
    }

    @Bean
    public IOrderService orderService() {
        return new OrderServiceImp();
    }

    @Bean
    public IOrderItemService orderItemService() {
        return new OrderItemServiceImp();
    }
//    @Bean
//    public IUserService userService(){
//        return new UserService();
//    }
//    @Bean
//    public IRoleService roleService(){
//        return new RoleService();
//    }
//    @Bean
//    public ITransferService transferService(){
//        return new TransferServiceImp();
//    }
//    @Bean
//    public IDepositService depositService(){
//        return  new DepositServiceImp();
//    }
//    @Bean
//    public IWithdrawService withdrawService(){
//        return  new WithdrawServiceImp();
//    }


    // Thymeleaf Configuration
    @Bean
    public SpringResourceTemplateResolver templateResolver() {
        SpringResourceTemplateResolver templateResolver = new SpringResourceTemplateResolver();
        templateResolver.setApplicationContext(applicationContext);
        templateResolver.setPrefix("/WEB-INF/views");
        templateResolver.setSuffix(".html");
        templateResolver.setTemplateMode(TemplateMode.HTML);
        templateResolver.setCharacterEncoding("UTF-8");
        return templateResolver;
    }

    @Bean
    public SpringTemplateEngine templateEngine() {
        SpringTemplateEngine templateEngine = new SpringTemplateEngine();
        templateEngine.setTemplateResolver(templateResolver());
        return templateEngine;
    }

    @Bean
    public ThymeleafViewResolver viewResolver() {
        ThymeleafViewResolver viewResolver = new ThymeleafViewResolver();
        viewResolver.setTemplateEngine(templateEngine());
        viewResolver.setCharacterEncoding("UTF-8");
        return viewResolver;
    }

    // JPA Configuration
    @Bean
    @Qualifier(value = "entityManager")
    public EntityManager entityManager(EntityManagerFactory entityManagerFactory) {
        return entityManagerFactory.createEntityManager();
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
        LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
        em.setDataSource(dataSource());
        em.setPackagesToScan("com.example.yuldshop.model");
        JpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        em.setJpaVendorAdapter(vendorAdapter);
        em.setJpaProperties(additionalProperties());
        return em;
    }

    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/yuld_shop");
        dataSource.setUsername("root");
        dataSource.setPassword("123456");
        return dataSource;
    }

    @Bean
    public PlatformTransactionManager transactionManager(EntityManagerFactory emf) {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(emf);
        return transactionManager;
    }

    Properties additionalProperties() {
        Properties properties = new Properties();
        properties.setProperty("hibernate.hbm2ddl.auto", "update");
        properties.setProperty("hibernate.show_sql", "false");
        properties.setProperty("hibernate.format_sql", "true");
        properties.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL8Dialect");
        return properties;
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/access/**").addResourceLocations("/access/");
    }

    //    @Bean
//    public MessageSource messageSource() {
//        ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
//        messageSource.setBasenames("validation-message");
//        return messageSource;
//    }
    @Bean
    public CommonsMultipartResolver multipartResolver() {
        int maxUploadSizeInMb = 10 * 1024 * 1024;     //10mb
        CommonsMultipartResolver resolver = new CommonsMultipartResolver();
        resolver.setDefaultEncoding("UTF-8");
        resolver.setMaxUploadSize(maxUploadSizeInMb * 2);
        resolver.setMaxUploadSizePerFile(maxUploadSizeInMb); //bytes
        return resolver;
    }

    @Bean
    public Cloudinary cloudinary() {
        Cloudinary cloudinary = new Cloudinary(ObjectUtils.asMap(
                "cloud_name", "dkm0vpby1",
                "api_key", "526871447322655",
                "api_secret", "YKXgHVCCh-qqaFSOLOUv_6qXDr8",
                "secure", true
        ));
        return cloudinary;
    }
}
