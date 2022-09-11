package come.warneriveris.SpringDoc.db;

import org.springframework.data.annotation.Id;

import lombok.Data;

@Data
public class AlbumDTO {
    
    @Id
    private long id;
    private String artist;
    private String title;
    private String[] tracks;
    private String year;
}
