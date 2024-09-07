package br.com.f1graphics.domain.statistics.dto.request;

import br.com.f1graphics.domain.statistics.dto.DTO;
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
public class ListDriversIdRequestDTO implements Serializable, DTO {

    private List<String> listDriversIdRequestDTO;

}
