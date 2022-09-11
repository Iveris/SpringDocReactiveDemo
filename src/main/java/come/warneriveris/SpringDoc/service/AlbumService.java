package come.warneriveris.SpringDoc.service;

import org.springframework.stereotype.Service;

import come.warneriveris.SpringDoc.db.AlbumDTO;
import come.warneriveris.SpringDoc.db.AlbumRepository;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class AlbumService {
    private final AlbumRepository albumRepo;

    public AlbumService(AlbumRepository albumRepo) {
        this.albumRepo = albumRepo;
    }
    
    public Mono<AlbumDTO> getAlbumById(@Parameter(in = ParameterIn.PATH) String id){
        return albumRepo.findById(Long.parseLong(id));
    }
    
    public Mono<AlbumDTO> getAlbumByTitle(@Parameter(in = ParameterIn.PATH) String title){
        return albumRepo.findByTitle(title);
    }
    
    public Flux<AlbumDTO> getAlbumsByArtist(@Parameter(in = ParameterIn.PATH) String artist){
        return albumRepo.findAllByArtist(artist);
    }
    
}
