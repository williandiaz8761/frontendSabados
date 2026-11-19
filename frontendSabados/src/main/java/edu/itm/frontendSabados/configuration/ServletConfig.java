package edu.itm.frontendSabados.configuration;

import edu.itm.frontendSabados.servlets.ParamServlet;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class ServletConfig {
    /**
     * Define un Bean para registrar el Servlet.
     * @return ServletRegistrationBean con el Servlet y el patrón de URL.
     */
    @Bean
    public ServletRegistrationBean<ParamServlet> myServletRegistration() {
        ServletRegistrationBean<ParamServlet> registration = new ServletRegistrationBean<>(new ParamServlet(), "/misServlets/*");
        // Opcional: configurar la prioridad de carga
        registration.setLoadOnStartup(1);
        return registration;
    }
}
