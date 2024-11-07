/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Clases.datosEmpresa;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.json.JSONObject;

import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONObject;

public class DAODatosEmpresa {
    
    public List ObtenerDatos(String RUC){
        
            List<datosEmpresa> lista = new LinkedList();
            
            
            OkHttpClient client = new OkHttpClient();
            String token = "apis-token-10669.rhiGeb1StXgboky45Dz9SG6Q6kHwyckt";

            // URL de la API
            Request request = new Request.Builder()
                .url("https://api.apis.net.pe/v2/sunat/ruc?numero=" + RUC)
                .addHeader("Authorization", "Bearer " + token)
                .addHeader("Referer", "http://apis.net.pe/api-ruc")
                .build();

        try (Response response = client.newCall(request).execute()) {
        if (response.isSuccessful()) {
            // Obtener la respuesta de la API en formato JSON
            JSONObject empresa = new JSONObject(response.body().string());

            // Crear una nueva instancia de datosEmpresa
            datosEmpresa datos = new datosEmpresa();

            // Asignar los valores del JSON a los atributos de la clase datosEmpresa
            datos.setDistrito(empresa.optString("distrito", "No disponible"));
            datos.setEstado(empresa.optString("estado", "No disponible"));
            datos.setNumero(empresa.optString("numero", "No disponible"));
            datos.setDireccion(empresa.optString("direccion", "No disponible"));
            datos.setUbigeo(empresa.optString("ubigeo", "No disponible"));
            datos.setZonaCodigo(empresa.optString("zonaCodigo", "No disponible"));
            datos.setCondicion(empresa.optString("condicion", "No disponible"));
            datos.setRazonSocial(empresa.optString("razonSocial", "No disponible"));
            datos.setDepartamento(empresa.optString("departamento", "No disponible"));
            datos.setNumeroDocumento(empresa.optString("numeroDocumento", "No disponible"));
            datos.setViaNombre(empresa.optString("viaNombre", "No disponible"));

            lista.add(datos);

        } else {
            System.out.println("Error en la solicitud, código de respuesta: " + response.code());
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
        return lista;
    }
    
}
