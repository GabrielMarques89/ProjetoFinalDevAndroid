package geen.gabrielmarques.projetofinaldevandroid.Models;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import geen.gabrielmarques.projetofinaldevandroid.Models.PerguntaDto;
import geen.gabrielmarques.projetofinaldevandroid.Models.RespostaDto;

public class RoundDto {

    @JsonProperty("Pergunta")
    private PerguntaDto pergunta;
    @JsonProperty("Resposta")
    private List<RespostaDto> resposta = null;
    @JsonProperty("Id")
    private Integer id;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("Pergunta")
    public PerguntaDto getPergunta() {
        return pergunta;
    }

    @JsonProperty("Pergunta")
    public void setPergunta(PerguntaDto pergunta) {
        this.pergunta = pergunta;
    }

    @JsonProperty("Resposta")
    public List<RespostaDto> getResposta() {
        return resposta;
    }

    @JsonProperty("Resposta")
    public void setResposta(List<RespostaDto> resposta) {
        this.resposta = resposta;
    }

    @JsonProperty("Id")
    public Integer getId() {
        return id;
    }

    @JsonProperty("Id")
    public void setId(Integer id) {
        this.id = id;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }
}