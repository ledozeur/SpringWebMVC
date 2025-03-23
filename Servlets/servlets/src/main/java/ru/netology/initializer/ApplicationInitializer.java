package ru.netology.initializer;

import jakarta.servlet.ServletException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletContext;

public class ApplicationInitializer implements WebApplicationInitializer {
    @Override
    public void onStartup(jakarta.servlet.ServletContext servletContext){
        try (var context = new AnnotationConfigApplicationContext()) {
            context.scan("ru.netology");
            context.refresh();
        }
        final var servlet = new DispatcherServlet();
        final var registration = servletContext.addServlet("app", String.valueOf(servlet));
        registration.setLoadOnStartup(1);
        registration.addMapping("/");
    }


}
