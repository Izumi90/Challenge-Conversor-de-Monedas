package Utils;

import com.google.gson.Gson;
import Model.ExhangeRate;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class ExRtSave {


    public static void guardarHistorial(List<String> historial){
        try (FileWriter writer = new FileWriter("historial_conversiones.txt")) {
            for (String linea : historial) {
                writer.write(linea + System.lineSeparator());
            }
            System.out.println("Archivo 'historial_conversiones.txt' guardado correctamente.");
        } catch (IOException e) {
            System.out.println("Error al guardar archivo" + e.getMessage());
        }
    }

}
