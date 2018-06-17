
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
        "Correta",
        "Pergunta",
        "Id"
})

public class RespostaDto {

    public RespostaDto(String conteudo, boolean correta) {
        this.conteudo = conteudo;
        this.correta = correta;
    }

    @JsonProperty("Conteudo")
    private String conteudo;
    @JsonProperty("Correta")
    private Boolean correta;
    @JsonProperty("Pergunta")
    private PerguntaDto pergunta;
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

    @JsonProperty("Correta")
    public Boolean getCorreta() {
        return correta;
    }

    @JsonProperty("Correta")
    public void setCorreta(Boolean correta) {
        this.correta = correta;
    }

    @JsonProperty("Pergunta")
    public PerguntaDto getPergunta() {
        return pergunta;
    }

    @JsonProperty("Pergunta")
    public void setPergunta(PerguntaDto pergunta) {
        this.pergunta = pergunta;
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