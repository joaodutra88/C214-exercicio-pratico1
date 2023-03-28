import org.json.JSONObject;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;
import net.minidev.json.JSONStyle;
import net.minidev.json.JSONValue;
//import com.jayway.jsonpath.*;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Professor {
    private String nome;
    private String horarioAtendimento;
    private String periodo;
    private int sala;
    private int predio;

    // construtor
    public Professor(String nome, String horarioAtendimento, String periodo, int sala, int predio) {
        this.nome = nome;
        this.horarioAtendimento = horarioAtendimento;
        this.periodo = periodo;
        this.sala = sala;
        this.predio = predio;
    }

    // getters e setters
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getHorarioAtendimento() {
        return horarioAtendimento;
    }

    public void setHorarioAtendimento(String horarioAtendimento) {
        this.horarioAtendimento = horarioAtendimento;
    }

    public String getPeriodo() {
        return periodo;
    }

    public void setPeriodo(String periodo) {
        this.periodo = periodo;
    }

    public int getSala() {
        return sala;
    }

    public void setSala(int sala) {
        this.sala = sala;
    }

    public int getPredio() {
        return predio;
    }

    public void setPredio(int predio) {
        this.predio = predio;
    }

    public static Professor fromJson(String json) {
        JSONObject jsonObj = new JSONObject(json);
        String nome = jsonObj.getString("nome");
        String horarioAtendimento = jsonObj.getString("horarioAtendimento");
        String periodo = jsonObj.getString("periodo");
        int sala = jsonObj.getInt("sala");
        int predio = jsonObj.getInt("predio");

        return new Professor(nome, horarioAtendimento, periodo, sala, predio);
    }
    public String toJson() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        sb.append("\"nome\":\"").append(nome).append("\",");
        sb.append("\"horarioAtendimento\":\"").append(horarioAtendimento).append("\",");
        sb.append("\"periodo\":\"").append(periodo).append("\",");
        sb.append("\"sala\":").append(sala).append(",");
        sb.append("\"predio\":").append(predio);
        sb.append("}");
        return sb.toString();
    }
//    public String toJson() {
//        Map<String, Object> map = new LinkedHashMap<>();
//        map.put("nome", nome);
//        map.put("horarioAtendimento", horarioAtendimento);
//        map.put("periodo", periodo);
//        map.put("sala", sala);
//        map.put("predio", predio);
//        JSONObject jsonObj = new JSONObject(map, JSONStyle.NO_COMPRESS);
//        return jsonObj.toString();
//    }
}
