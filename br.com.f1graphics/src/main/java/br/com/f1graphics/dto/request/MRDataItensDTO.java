package br.com.f1graphics.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MRDataItensDTO {

    @JsonProperty("MRData")
    private MRDataDTO mrData;

    public MRDataDTO getMrData() {
        return mrData;
    }

    public void setMrData(MRDataDTO mrData) {
        this.mrData = mrData;
    }
}
