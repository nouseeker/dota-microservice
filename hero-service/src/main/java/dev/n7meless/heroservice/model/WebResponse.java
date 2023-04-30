package dev.n7meless.heroservice.model;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@JsonPropertyOrder({"code", "status", "message"})
public class WebResponse {
    private Integer code;
    private String status;
    private String message;
}
