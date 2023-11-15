package br.com.f1graphics.dto.request;

import br.com.f1graphics.DTO;
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
public class ListNamesRacingDTO  implements Serializable, DTO {

    private List<String> listNamesRacingDTO;
    public List<String> getListNamesRacingDTO() {
        return listNamesRacingDTO;
    }

    public void setListNamesRacingDTO(List<String> listaRacingDTO) {
        this.listNamesRacingDTO = listNamesRacingDTO;
    }
}
