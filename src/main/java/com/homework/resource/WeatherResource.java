package com.homework.resource;

import com.homework.service.IWeatherService;
import io.smallrye.mutiny.Uni;
import org.jboss.resteasy.annotations.jaxrs.PathParam;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.io.IOException;

@ApplicationScoped
@Path("/weather")
public class WeatherResource {

    IWeatherService service;

    @Inject
    public WeatherResource(IWeatherService service) {
        this.service = service;
    }

    @GET
    @Path("/{city}")
    @Produces(MediaType.TEXT_PLAIN)
    public Uni<String> getWeather(@PathParam String city) {
        return Uni.createFrom().item(() -> service.getCityWeather(city));
    }
}
