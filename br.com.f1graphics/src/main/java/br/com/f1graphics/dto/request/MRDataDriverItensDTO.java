package br.com.f1graphics.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MRDataDriverItensDTO {

    @JsonProperty("MRData")
    private MRDataDriverDTO mrData;

    public MRDataDriverDTO getMrData() {
        return mrData;
    }

    public void setMrData(MRDataDriverDTO mrData) {
        this.mrData = mrData;
    }
}
