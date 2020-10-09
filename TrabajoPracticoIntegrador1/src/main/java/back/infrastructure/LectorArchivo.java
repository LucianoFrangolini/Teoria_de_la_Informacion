package back.infrastructure;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

public class LectorArchivo {
    public ArrayList<Double> leerVector(String direccion) {
        ArrayList<Double> resultado = new ArrayList<>();
        try {
            Scanner input = new Scanner(new File(direccion));
            while (input.hasNextLine()) {
                resultado.add(input.nextDouble());
            }
        } catch (FileNotFoundException e) {
            System.out.println("No se pudo leer el archivo.");
        }
        return resultado;
    }

    public double[][] leerMatriz(String direccion) {
        double[][] resultado = new double[0][];
        try {
            Scanner sc = new Scanner(new BufferedReader(new FileReader("sample.txt")));
            int cantFilas = Integer.parseInt(sc.nextLine());
            resultado = new double[cantFilas][cantFilas];
            while(sc.hasNextLine()) {
                for (int i=0; i<resultado.length; i++) {
                    String[] line = sc.nextLine().trim().split(" ");
                    for (int j=0; j<line.length; j++) {
                        resultado[i][j] = Double.parseDouble(line[j]);
                    }
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return resultado;

        /*double [][] resultado = new double[0][];
        try {
            Scanner sc = new Scanner(new File(direccion));
            int cantFilas = sc.nextInt();
            resultado = new double[cantFilas][cantFilas];
            int filaActual = 0;
            int columnaActual = 0;
            while (sc.hasNext()) {
                resultado[filaActual][columnaActual++] = sc.nextDouble();
                if (columnaActual >= 3) {
                    columnaActual = 0;
                    filaActual++;
                }
            }
            sc.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return resultado;*/
    }
}
