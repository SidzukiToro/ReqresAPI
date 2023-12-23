package models.responseModels;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UnknownDataResponse {
    private long id;
    private String name;
    private long year;
    private String color;
    @JsonProperty("pantone_value")
    private String pantoneValue;
}
