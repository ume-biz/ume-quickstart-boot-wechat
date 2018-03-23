package org.umeframework.quickstart.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;
import org.umeframework.dora.http.HttpProxy;
import org.umeframework.dora.http.impl.HttpProxyImpl;
import org.umeframework.dora.message.MessageProperties;
import org.umeframework.dora.service.UserEntity;
import org.umeframework.dora.service.user.UserAuthenticator;
import org.umeframework.dora.service.user.UserLoginService;
import org.umeframework.dora.service.user.impl.UserLoginServiceImpl;
import org.umeframework.quickstart.uac.user.dto.UserAuthDto;
import org.umeframework.quickstart.uac.user.impl.DefaultAuthenticatorImpl;
import org.umeframework.quickstart.uac.user.impl.WechatUserCodeAuthenticatorImpl;

/**
 * Spring Boot启动用的主类<br>
 * 只需在该类的头部用注解标注的形式，即可启动一个内嵌Web服务器的Java项目<br>
 * <br>
 * Dora框架提供基于注解自动配置和基于XML配置两种方案，分别采用如下说明的方法来选择配置方式：<br>
 * <li>基于注解自动配置 - 在主类的头部添加"@ImportAutoConfiguration"设置
 * <li>基于注解自动配置 - 在主类的头部添加"@ImportResource"设置
 * <li>对于要从自动配置中排除的模块，使用"@EnableAutoConfiguration(exclude=...)"设置 <br>
 * <li>基于XML配置的场合，使用：@ImportResource("classpath:applicationContext.xml")<br>
 * <li>基于DORA自动配置，但不配置数据源的场合，使用：@ImportAutoConfiguration({ DoraAutoConfigurationNoDataSource.class})<br>
 * <br><br>
 * 当默认的自动配置类org.umeframework.dora.appconfig.AutoConfiguration被导入·启动时，<br>
 * Dora框架默认声明了以下名称的Bean，因此应用中需要避免再次声明相同名称的Bean，否则会发生命名冲突。<br>
 * <li>"doraBeanFactory" - org.umeframework.dora.bean.impl.BeanFactoryImpl @DefaultBeanFactoryConfiguration
 * <li>"doraCacheManager" - org.umeframework.dora.cache.impl.TempMemoryCachedImpl @DefaultCacheManagerConfiguration
 * <li>"doraRdbDao" - org.umeframework.dora.dao.impl.BatisDaoImpl @DefaultDaoConfiguration
 * <li>"doraBasicDataSource" - org.apache.commons.dbcp.BasicDataSource @DefaultDataSourceConfiguration
 * <li>"doraExceptionHandler" - org.umeframework.dora.exception.impl.ExceptionHandlerImpl @DefaultExceptionHandlerConfiguration
 * <li>"doraHttpClient","doraHttpClient[json]","doraHttpClient[xml]","doraHttpClient[x-www-form-urlencoded]" - org.umeframework.dora.http.impl.HttpProxyImpl @DefaultHttpProxyConfiguration
 * <li>"doraRemoteServiceClient" - org.umeframework.dora.http.impl.RemoteServiceProxyImpl @DefaultHttpProxyConfiguration
 * <li>"doraJdbcDataSourceManager" - org.umeframework.dora.connection.impl.JdbcDataSourceManagerImpl @DefaultJdbcDataSourceManagerConfiguration
 * <li>"doraLogger" - org.umeframework.dora.log.Logger @DefaultLogConfiguration
 * <li>"doraUserLoginService" - org.umeframework.dora.service.user.impl.UserLoginServiceImpl @DefaultLoginServiceConfiguration
 * <li>"doraMessageProperties" - org.umeframework.dora.message.MessageProperties @DefaultMessageConfiguration
 * <li>"doraAjaxParser" - org.umeframework.dora.ajax.impl.JSONParserImpl @DefaultServiceAjaxConfiguration
 * <li>"doraAjaxRender" - org.umeframework.dora.ajax.impl.UnicodeJSONRenderImpl @DefaultServiceAjaxConfiguration
 * <li>"sys" - org.umeframework.dora.service.interceptor.impl.DefaultInterceptorChain @DefaultServiceInterceptChainConfiguration
 * <li>"doraServiceAuthInterceptor" - org.umeframework.dora.service.interceptor.impl.ServiceAuthenticateInterceptor @DefaultServiceInterceptConfiguration
 * <li>"doraServiceInputInterceptor" - org.umeframework.dora.service.interceptor.impl.ServiceInputInterceptor @DefaultServiceInterceptConfiguration
 * <li>"doraServiceInterceptor" - org.umeframework.dora.service.interceptor.impl.ServiceInterceptor @DefaultServiceInterceptConfiguration
 * <li>"doraServiceOutputInterceptor" - org.umeframework.dora.service.interceptor.impl.ServiceOutputInterceptor @DefaultServiceInterceptConfiguration
 * <li>"doraTransactionalServiceInterceptor" - org.umeframework.dora.service.interceptor.impl.TransactionalServiceInterceptor @DefaultServiceInterceptConfiguration
 * <li>"doraServiceMappingConfigProperties" - org.umeframework.dora.property.impl.ConfigPropertiesImpl @DefaultServiceMappingConfiguration
 * <li>"doraServiceWhiteListConfigProperties" - org.umeframework.dora.property.impl.ConfigPropertiesImpl @DefaultServiceMappingConfiguration
 * <li>"doraServiceMapping" - org.umeframework.dora.service.mapping.impl.ServiceMappingImpl @DefaultServiceMappingConfiguration
 * <li>"doraServiceMappingDesc" - org.umeframework.dora.service.mapping.impl.ServiceMappingDescImpl @DefaultServiceMappingConfiguration
 * <li>"doraServiceSecurityHelper" - org.umeframework.dora.security.impl.SecurityHelper @DefaultServiceSecurityInterceptChainConfiguration
 * <li>"doraServiceSecurityInputInterceptor" - org.umeframework.dora.service.interceptor.impl.ServiceSecurityInputInterceptor @DefaultServiceSecurityInterceptChainConfiguration
 * <li>"doraServiceSecurityOutputInterceptor" - org.umeframework.dora.service.interceptor.impl.ServiceSecurityOutputInterceptor @DefaultServiceSecurityInterceptChainConfiguration
 * <li>"syss" - org.umeframework.dora.service.interceptor.impl.DefaultInterceptorChain @DefaultServiceSecurityInterceptChainConfiguration
 * <li>"doraSystemPropertyConfiguration" - org.umeframework.dora.appconfig.DefaultSystemPropertyConfiguration @DefaultSystemPropertyConfiguration
 * <li>"doraTransactionManager" - org.umeframework.dora.transaction.impl.TransactionManagerImpl @DefaultTransactionManagerConfiguration
 * <br><br>
 * @author Yue MA
 */
// 排除SpringBoot自带的数据源初始化设置，采用application.properties中使用ume.jdbc设置的数据源连接。
@SpringBootApplication
@EnableAutoConfiguration(exclude = {
        org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration.class,
        org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration.class })
// 导入项目的自动化配置。
@Import({
    // 启动UME框架的默认配置
	// 启用AutoConfiguration内建的默认配置项目
    // org.umeframework.dora.appconfig.AutoConfiguration.class,
	// 或根据需要选择自定义如下预置组件的配置项目
    org.umeframework.dora.appconfig.DefaultBeanFactoryConfiguration.class,
    org.umeframework.dora.appconfig.DefaultCacheManagerConfiguration.class,
    org.umeframework.dora.appconfig.DefaultDaoConfiguration.class,
    org.umeframework.dora.appconfig.DefaultDataSourceConfiguration.class,
    org.umeframework.dora.appconfig.DefaultExceptionHandlerConfiguration.class,
    org.umeframework.dora.appconfig.DefaultHttpProxyConfiguration.class,
    org.umeframework.dora.appconfig.DefaultJdbcDataSourceManagerConfiguration.class,
    org.umeframework.dora.appconfig.DefaultLogConfiguration.class,
    org.umeframework.dora.appconfig.DefaultMessageConfiguration.class,
    org.umeframework.dora.appconfig.DefaultServiceAjaxConfiguration.class,
    org.umeframework.dora.appconfig.DefaultServiceInterceptChainConfiguration.class,
    org.umeframework.dora.appconfig.DefaultServiceInterceptConfiguration.class,
    org.umeframework.dora.appconfig.DefaultServiceMappingConfiguration.class,
    org.umeframework.dora.appconfig.DefaultServiceSecurityInterceptChainConfiguration.class,
    org.umeframework.dora.appconfig.DefaultSystemPropertyConfiguration.class,
    org.umeframework.dora.appconfig.DefaultTransactionManagerConfiguration.class,
    org.umeframework.dora.appconfig.DefaultUserCacheConfiguration.class,
    org.umeframework.dora.appconfig.DefaultUserLoginConfiguration.class,
    org.umeframework.dora.appconfig.DefaultWebControllerConfiguration.class })
// 该设置创建并导入示例用的数据库及数据脚本；如果应用(通过application.properties的ume.jdbc设置)已变更为其他的数据库，请删除此设置。
@ImportResource("classpath:config/ume-quickstart-boot-wechat/initDataConfiguration.xml")
@ComponentScan(basePackages = "org.umeframework.quickstart")
public class Application {

	/**
	 * Start application.<br>
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			SpringApplication.run(Application.class, args);
		} catch (Throwable e) {
			if (!e.getClass().getName().startsWith("org.springframework.boot.devtools")) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * 默认的用户登录鉴权实例。<br>
	 * 
	 * @return
	 */
	@Bean(name = "userAuthenticator")
	public UserAuthenticator<?> userAuthenticator() {
		UserAuthenticator<UserAuthDto> instance = new DefaultAuthenticatorImpl();
		return instance;
	}

	/**
	 * 微信服务器通信用HttpClient实例。<br>
	 * 
	 * @return
	 * @throws Exception
	 */
	@Bean(name = "urlEncodedHttpProxy") //HttpProxy4x-www-form-urlencoded
	public HttpProxy urlEncodedHttpProxy() throws Exception {
		HttpProxyImpl instance = new HttpProxyImpl();
		instance.setAppContentType("application/x-www-form-urlencoded");
		instance.setEntityContentType("application/x-www-form-urlencoded");
		instance.setEntityCharset("UTF-8");
		instance.setParamCharset("UTF-8");
		instance.setUseSSL(false);
		return instance;
	}

	/**
	 * 微信服务调用相关的配置实例。<br>
	 * 
	 * @return
	 * @throws Exception
	 */
	@Bean(name = "wechatConfig")
	public MessageProperties wechatConfig() throws Exception {
		MessageProperties instance = new org.umeframework.dora.message.impl.MessagePropertiesImpl(
				"config/ume-quickstart-boot-wechat/wechat");
		return instance;
	}

	/**
	 * 微信登录服务实例。<br>
	 * 
	 * @param userAuthenticator
	 * @return
	 */
	@Bean(name = "wechatUserLoginService")
	public UserLoginService wechatUserLoginService(
			@Autowired @Qualifier("wechatUserAuthenticator") UserAuthenticator<UserEntity> userAuthenticator) {
		UserLoginServiceImpl instance = new UserLoginServiceImpl();
		instance.setUserAuthenticator(userAuthenticator);
		instance.setSingleLogin(false);
		return instance;
	}

	/**
	 * 微信登录用鉴权实例。<br>
	 * 
	 * @return
	 */
	@Bean(name = "wechatUserAuthenticator")
	public UserAuthenticator<?> wechatUserAuthenticator() {
		WechatUserCodeAuthenticatorImpl instance = new WechatUserCodeAuthenticatorImpl();
		return instance;
	}	
}
