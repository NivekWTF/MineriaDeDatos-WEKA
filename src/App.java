import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class App {
        static Random random = new Random();
        static int edad;
        static int Estacionrandom;
        static String Licencia;
        static String Estacion;
        static String Genero;
        static int CalifacionTeorica;
    public static void main(String[] args) throws Exception {
        try {
            GeneraDatos();
        } catch (Exception e) {
            System.out.println("Error al crear el archivo");
        }
    }

    public static void GeneraDatos() throws IOException{
        FileWriter archivoARFF = new FileWriter("Datos.arff");

        String aprobacion = "";
        
        archivoARFF.write("@relation Licencias\n");
            archivoARFF.write("@attribute Edad numeric\n");
            archivoARFF.write("@attribute Licencia {Auto, Moto, Chofer}\n");
            archivoARFF.write("@attribute Estacion {Primavera, Verano, Otono, Invierno}\n");
            archivoARFF.write("@attribute Genero {Hombre, Mujer}\n");
            archivoARFF.write("@attribute CalifacionTeorica numeric\n");
            archivoARFF.write("@attribute CalifacionPractica {Baja, Media, Alta}\n");
            archivoARFF.write("@attribute Aprobacion {si, no}\n");
            archivoARFF.write("@data\n");

        for (int i = 0; i < 10000; i++) {
            String CalifacionPractica = "";
            CalifacionTeorica = random.nextInt(11);
            edad = random.nextInt(50) + 16;
            Estacionrandom = random.nextInt(4);
            int licrandom = random.nextInt(3);
            
            if (edad < 18) {
                Licencia = "Auto";
            } else if (licrandom == 0) {
                Licencia = "Chofer";
            } else if (licrandom == 1) {
                Licencia = "Moto";
            } else {
                Licencia = "Auto";
            }
            
            if (Estacionrandom == 0) {
                Estacion = "Primavera";
            } else if (Estacionrandom == 1) {
                Estacion = "Verano";
            } else if (Estacionrandom == 2) {
                Estacion = "Otono";
            } else {
                Estacion = "Invierno";
            }

            if (random.nextInt(2) == 0) {
                Genero = "Hombre";
            } else {
                Genero = "Mujer";
            }

            if (CalifacionTeorica <= 5) {
                CalifacionPractica = "Baja"; //Reprobada
                if (random.nextInt(100) < 10){
                    aprobacion = "si";
                } else {
                    aprobacion = "no";
                }
            } else if (CalifacionTeorica <= 8) {
                CalifacionPractica = "Media";
            } else {
                CalifacionPractica = "Alta";
            }
            
            
            if (CalifacionTeorica >= 6 && CalifacionPractica != "Baja") {
                if (random.nextInt(100) < 95) {
                    aprobacion = "si";
                } else {
                    aprobacion = "no";
                }
            } else if (CalifacionTeorica >= 6 || CalifacionPractica != "Baja") {
                if (random.nextInt(100) < 40 ) {
                    aprobacion = "si";
                } else {
                    aprobacion = "no";
                }
            } else {
                aprobacion = "no";
            }
            
            archivoARFF.write(edad + "," + Licencia + "," + Estacion + "," + Genero + "," + CalifacionTeorica + "," + CalifacionPractica + "," + aprobacion + "\n");
            System.out.println(edad + ","+ licrandom + "," + Licencia + "," + Estacion + "," + Genero + "," + CalifacionTeorica + "," + CalifacionPractica + "," + aprobacion);
        }

        archivoARFF.close();
        System.out.println("Archivo creado");
    }
}

