package come.warneriveris.SpringDoc.api;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;

import come.warneriveris.SpringDoc.db.AlbumDTO;
import come.warneriveris.SpringDoc.service.AlbumService;
import reactor.core.publisher.Mono;

import static org.springdoc.webflux.core.fn.SpringdocRouteBuilder.route;

@Configuration
public class RouteConfig {
    private final AlbumService service;

    public RouteConfig(AlbumService service) {
        this.service = service;
    }
    
    @Bean
    RouterFunction<ServerResponse> routerFunction() {
        return route().GET("/album/{id}", this::byId, ops -> ops.beanClass(AlbumService.class).beanMethod("getAlbumById")).build()
                .and(route().GET("/album/title/{title}", this::byTitle, ops -> ops.beanClass(AlbumService.class).beanMethod("getAlbumByTitle")).build())
                .and(route().GET("/album/artist/{artist}", this::byArtist, ops -> ops.beanClass(AlbumService.class).beanMethod("getAlbumsByArtist")).build());
    }
    
    
    private Mono<ServerResponse> byId(ServerRequest req){
        return ServerResponse.ok().body(service.getAlbumById(req.pathVariable("id")), AlbumDTO.class);
    }
    
    private Mono<ServerResponse> byTitle(ServerRequest req){
        return ServerResponse.ok().body(service.getAlbumByTitle(req.pathVariable("title")), AlbumDTO.class);
    }
    
    private Mono<ServerResponse> byArtist(ServerRequest req){
        return ServerResponse.ok()
                .contentType(MediaType.TEXT_EVENT_STREAM)
                .body(service.getAlbumsByArtist(req.pathVariable("artist")), AlbumDTO.class);
    }
    
}
