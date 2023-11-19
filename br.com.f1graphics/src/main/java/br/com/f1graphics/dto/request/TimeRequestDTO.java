package br.com.f1graphics.dto.request;

import br.com.f1graphics.dto.DTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TimeRequestDTO implements Serializable, DTO {

    private String millis;
    private String time;

}