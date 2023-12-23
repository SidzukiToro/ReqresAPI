package models.responseModels;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResourceListResponse {
    private long page;
    @JsonProperty("per_page")
    private long perPage;
    private long total;
    @JsonProperty("total_pages")
    private long totalPages;
    private UnknownDataResponse[] data;
    private SupportResponse support;
}
