package br.com.f1graphics.dto.response;

import br.com.f1graphics.dto.DTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ListNamesRacesResponseDTO implements Serializable, DTO {

    private List<String> listNamesRacesDTO;

}
