package models.responseModels;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class СhangedUserResponse {
    private String name;
    private String job;
    private Date updatedAt;
}
