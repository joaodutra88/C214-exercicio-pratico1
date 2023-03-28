import org.junit.jupiter.api.Test;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ProfessorTest {

    // testes com cenário de sucesso
    @Test
    public void testFromJsonSuccess() {
        String json = "{\"nome\":\"João\",\"horarioAtendimento\":\"8h às 10h\",\"periodo\":\"2022.1\",\"sala\":301,\"predio\":3}";
        Professor professor = Professor.fromJson(json);

        assertNotNull(professor);
        assertEquals("João", professor.getNome());
        assertEquals("8h às 10h", professor.getHorarioAtendimento());
        assertEquals("2022.1", professor.getPeriodo());
        assertEquals(301, professor.getSala());
        assertEquals(3, professor.getPredio());
    }

    @Test
    public void testListFromJsonSuccess() {
        String json = "[{\"nome\":\"João\",\"horarioAtendimento\":\"8h às 10h\",\"periodo\":\"2022.1\",\"sala\":301,\"predio\":3},{\"nome\":\"Maria\",\"horarioAtendimento\":\"14h às 16h\",\"periodo\":\"2022.1\",\"sala\":401,\"predio\":4}]";
        List<Professor> professores = new ArrayList<>();
        JSONArray jsonArray = new JSONArray(json);
        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject jsonObj = jsonArray.getJSONObject(i);
            String nome = jsonObj.getString("nome");
            String horarioAtendimento = jsonObj.getString("horarioAtendimento");
            String periodo = jsonObj.getString("periodo");
            int sala = jsonObj.getInt("sala");
            int predio = jsonObj.getInt("predio");
            Professor professor = new Professor(nome, horarioAtendimento, periodo, sala, predio);
            professores.add(professor);
        }

        assertEquals(2, professores.size());

        Professor professor1 = professores.get(0);
        assertEquals("João", professor1.getNome());
        assertEquals("8h às 10h", professor1.getHorarioAtendimento());
        assertEquals("2022.1", professor1.getPeriodo());
        assertEquals(301, professor1.getSala());
        assertEquals(3, professor1.getPredio());

        Professor professor2 = professores.get(1);
        assertEquals("Maria", professor2.getNome());
        assertEquals("14h às 16h", professor2.getHorarioAtendimento());
        assertEquals("2022.1", professor2.getPeriodo());
        assertEquals(401, professor2.getSala());
        assertEquals(4, professor2.getPredio());
    }

    @Test
    public void testGetNome() {
        Professor professor = new Professor("João", "Segunda-feira, das 14h às 16h", "Integral", 9, 3);
        assertEquals("João", professor.getNome());
    }

    @Test
    public void testGetHorarioAtendimento() {
        Professor professor = new Professor("João", "Segunda-feira, das 14h às 16h", "Integral", 9, 3);
        assertEquals("Segunda-feira, das 14h às 16h", professor.getHorarioAtendimento());
    }

    @Test
    public void testGetPeriodo() {
        Professor professor = new Professor("João", "Segunda-feira, das 14h às 16h", "Integral", 9, 3);
        assertEquals("Integral", professor.getPeriodo());
    }

    @Test
    public void testGetSala() {
        Professor professor = new Professor("João", "Segunda-feira, das 14h às 16h", "Integral", 9, 3);
        assertEquals(9, professor.getSala());
    }
    @Test
    public void testGetPredio() {
        Professor professor = new Professor("João", "Segunda-feira, das 14h às 16h", "Integral", 9, 3);
        assertEquals(3, professor.getPredio());
    }

    @Test
    public void testFromJson() {
        String json = "{\"nome\":\"João\",\"horarioAtendimento\":\"Segunda-feira, das 14h às 16h\",\"periodo\":\"Integral\",\"sala\":9,\"predio\":3}";
        Professor professor = Professor.fromJson(json);
        assertEquals("João", professor.getNome());
        assertEquals("Segunda-feira, das 14h às 16h", professor.getHorarioAtendimento());
        assertEquals("Integral", professor.getPeriodo());
        assertEquals(9, professor.getSala());
        assertEquals(3, professor.getPredio());
    }

    @Test
    public void testToJson() {
        Professor professor = new Professor("João", "Segunda-feira, das 14h às 16h", "Integral", 9, 3);
        String json = "{\"nome\":\"João\",\"horarioAtendimento\":\"Segunda-feira, das 14h às 16h\",\"periodo\":\"Integral\",\"sala\":9,\"predio\":3}";
        assertEquals(json, professor.toJson().toString());
    }

    @Test
    public void testEqualsTrue() {
        Professor professor1 = new Professor("João", "Segunda-feira, das 14h às 16h", "Integral", 9, 3);
        Professor professor2 = new Professor("João", "Segunda-feira, das 14h às 16h", "Integral", 9, 3);
        assertTrue(professor1.equals(professor2));
    }

    @Test
    public void testEqualsWithNull() {
        Professor professor = new Professor("João", "Segunda-feira, das 14h às 16h", "Integral", 9, 3);
        assertFalse(professor.equals(null));
    }


    // testes com cenário de falha
}

