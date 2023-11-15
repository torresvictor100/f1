package br.com.f1graphics.dto.factory;

import br.com.f1graphics.dto.response.ChampionshipResponseDTO;

public class F1GraphicsFactory {

    public static ChampionshipResponseDTO createChampionshipResponseDTO(String season){

         ChampionshipResponseDTO championship = new ChampionshipResponseDTO();
         championship.setSeason(season);

        return championship;
    }
}
