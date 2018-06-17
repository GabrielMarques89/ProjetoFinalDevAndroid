package geen.gabrielmarques.projetofinaldevandroid.Models;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "Conteudo",
        "Dificuldade",
        "Id"
})

public class PerguntaDto {

    @JsonProperty("Conteudo")
    private String conteudo;
    @JsonProperty("Dificuldade")
    private Double dificuldade;
    @JsonProperty("Id")
    private Integer id;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("Conteudo")
    public String getConteudo() {
        return conteudo;
    }

    @JsonProperty("Conteudo")
    public void setConteudo(String conteudo) {
        this.conteudo = conteudo;
    }

    @JsonProperty("Dificuldade")
    public Double getDificuldade() {
        return dificuldade;
    }

    @JsonProperty("Dificuldade")
    public void setDificuldade(Double dificuldade) {
        this.dificuldade = dificuldade;
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