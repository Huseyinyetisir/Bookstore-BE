package com.huseyinyetisir.BookstoreBE.config;


import com.huseyinyetisir.BookstoreBE.Entity.Book;
import com.huseyinyetisir.BookstoreBE.Entity.Review;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.http.HttpMethod;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

@Configuration
public class MyDataRestConfig implements RepositoryRestConfigurer {

    private String theAllowedOrigin = "http://localhost:3000";

    public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config, CorsRegistry cors){

        HttpMethod[] theUnsupportedActions = {
                HttpMethod.PUT,
                HttpMethod.POST,
                HttpMethod.DELETE,
                HttpMethod.PATCH,

        };
        config.exposeIdsFor(Book.class);
        config.exposeIdsFor(Review.class);

        disableHttpMethods(Book.class, config, theUnsupportedActions);
        disableHttpMethods(Review.class, config, theUnsupportedActions);
        cors.addMapping(config.getBasePath()+"/**")
                .allowedOrigins(theAllowedOrigin);
    }

    private void disableHttpMethods(Class theClass,
                                    RepositoryRestConfiguration config,
                                    HttpMethod[] theUnsupportedActions) {

        config.getExposureConfiguration()
                .forDomainType(theClass)
                .withItemExposure(((metdata, httpMethods) -> httpMethods.disable(theUnsupportedActions) ))
                 .withCollectionExposure(((metdata, httpMethods) -> httpMethods.disable(theUnsupportedActions) ));

    }


}