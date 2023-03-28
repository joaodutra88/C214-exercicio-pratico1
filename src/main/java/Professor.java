import org.json.JSONObject;

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
        JSONObject jsonObj = new JSONObject();
        jsonObj.put("nome", nome);
        jsonObj.put("horarioAtendimento", horarioAtendimento);
        jsonObj.put("periodo", periodo);
        jsonObj.put("sala", sala);
        jsonObj.put("predio", predio);
        return jsonObj.toString();
    }

}
