package spittr.config;

import java.io.IOException;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;
import org.springframework.web.servlet.view.tiles3.TilesConfigurer;
import org.springframework.web.servlet.view.tiles3.TilesViewResolver;

@Configuration
@EnableWebMvc
@ComponentScan("spittr.web")
@ImportResource("classpath:webFlow.xml")
public class WebConfig extends WebMvcConfigurerAdapter{
	/**
	 * 视图解析器
	 * @description
	 * @return ViewResolver
	 * @author wanghaidong
	 * @date 2016年12月17日 上午9:15:13
	 */
	@Bean
	public ViewResolver viewResolver(){
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		resolver.setPrefix("/WEB-INF/views/");
		resolver.setSuffix(".jsp");
		//将视图解析为JstlView
		resolver.setViewClass(JstlView.class);
		
		resolver.setExposeContextBeansAsAttributes(true);
		return resolver;
	}
	/**
	 * 配置静态资源处理
	 */
	/*public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer){
		configurer.enable();
	}*/
	/**
	 * 信息源
	 * @return
	 */
	@Bean
	public MessageSource messageSource(){
		ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
		messageSource.setBasename("messages");
		return messageSource;
	}
	/**
	 * 配置tilesConfig来解析定义
	 * @description
	 * @return TilesConfigurer
	 * @author wanghaidong
	 * @date 2016年12月19日 上午8:52:57
	 */
	@Bean
	public TilesConfigurer tilesConfigurer(){
		TilesConfigurer tiles = new TilesConfigurer();
		tiles.setDefinitions(new String[] {"/WEB-INF/layout/tiles.xml"});
		tiles.setCheckRefresh(true);
		return tiles;
	}
	/**
	 * TilesviewResolver
	 * @description
	 * @return ViewResolver
	 * @author wanghaidong
	 * @date 2016年12月19日 上午8:57:49
	 */
	/*@Bean
	public ViewResolver viewResolver(){
		return new TilesViewResolver();
	}*/
	/**
	 * CommonsMultipartResolver
	 * @description
	 * @return MultipartResolver
	 * @author wanghaidong
	 * @throws IOException 
	 * @date 2016年12月19日 上午10:14:44
	 */
	@Bean
	public MultipartResolver multipartResolver() throws IOException{
		CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver();
		multipartResolver.setUploadTempDir(new FileSystemResource("/tmp/spittr/uploads"));
		//上传文件最大为2M
		multipartResolver.setMaxUploadSize(2097152);
		multipartResolver.setMaxInMemorySize(0);
		return multipartResolver;
	}
	
}
