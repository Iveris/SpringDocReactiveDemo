package come.warneriveris.SpringDoc.db;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public interface AlbumRepository extends ReactiveCrudRepository<AlbumDTO, Long> {

    Flux<AlbumDTO> findAllByArtist(String artist);

    Mono<AlbumDTO> findByTitle(String title);

}
