import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {

        Scanner consulta = new Scanner(System.in);
        Menu menu = new Menu();
        String direccion = "";
        float monto = 0;
        int opcion = 0;
        String falsaOpcion = "";

        System.out.println("Bienvenido al conversor de monedas.");

        while (opcion != 7) {
            System.out.println("Ingrese una opcion: ");
            System.out.println("1) Dólar =>> Peso argentino");
            System.out.println("2) Peso argentino =>> Dólar");
            System.out.println("3) Dólar =>> Real brasileño");
            System.out.println("4) Real brasileño =>> Dólar");
            System.out.println("5) Dólar =>> Peso colombiano");
            System.out.println("6) Peso colombiano =>> Dólar");
            System.out.println("7) SALIR");

            falsaOpcion = consulta.nextLine();

            try {
                opcion = Integer.parseInt(falsaOpcion);
                if (opcion > 7 || opcion < 0){
                    System.out.println("Ingrese una opcion valida!");
                    continue;
                }
                if (opcion == 7){
                    System.out.println("Programa finalizado.");
                    break;
                }
            }catch (NumberFormatException e){
                System.out.println("No se admiten letras, ingrese un numero dentro de las opciones.");
                continue;
            }

            System.out.println("Ingrese el monto: ");
            falsaOpcion = consulta.nextLine();

            try {
                monto = Float.parseFloat(falsaOpcion);
            }catch (NumberFormatException e){
                System.out.println("No se admiten letras, ingresar un monto valido!");
            }

            direccion = menu.retornaDireccion(opcion);
            direccion+= monto;

            try {
                HttpClient client = HttpClient.newHttpClient();
                HttpRequest request = HttpRequest.newBuilder()
                        .uri(URI.create(direccion))
                        .build();

                HttpResponse<String> response = client
                        .send(request, HttpResponse.BodyHandlers.ofString());

                String json = response.body();

                Gson gson = new GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_DASHES).create();
                Cotizacion cotizacion = gson.fromJson(json, Cotizacion.class);
                ClaseCotizacion total = new ClaseCotizacion(cotizacion);
                menu.mensajeFinal(opcion, monto);
                System.out.println(total.getResultado());

            } catch (NumberFormatException e) {
                System.out.println("Ocurrio un error: " + e.getMessage());
            } catch (IOException e) {
                throw new RuntimeException(e);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        }
        }

}


