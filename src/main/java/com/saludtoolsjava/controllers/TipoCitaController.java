package com.saludtoolsjava.controllers;

import com.saludtoolsjava.models.ApiResponse;
import com.saludtoolsjava.models.TipoCitaModel;
import com.saludtoolsjava.services.TipoCitaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api")
public class TipoCitaController {

    @Autowired
    private TipoCitaService tipoCitaService;

    @PostMapping(value = "/guardarTipoCita")
    public ApiResponse postTipoCita(@RequestBody TipoCitaModel body) {
        try {
            TipoCitaModel response = tipoCitaService.postTipoCita(body);
            return new ApiResponse(
                true,
                "El tipo de cita ha sido "+(body.getId() != null ? "actualizada " : "almecenada ")+"exitosamente!",
                response
            );
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            return new ApiResponse(
                false,
                "Error interno",
                null
            );
        }
    }

    @GetMapping(value = "/consultarTiposCita")
    public ApiResponse getTiposCita() {
        try {
            return new ApiResponse(
                true,
                "Listado - tipos de cita",
                tipoCitaService.getTiposCita()
            );
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            return new ApiResponse(
                false,
                "Error interno",
                null
            );
        }
    }

    @GetMapping(value = "/consultarTipoCita/{id}")
    public ApiResponse getTipoCita(@PathVariable Integer id) {
        try {
            TipoCitaModel response = tipoCitaService.getTipoCita(id);
            return new ApiResponse(
                (response != null) ? true : false,
                (response != null) ? "Tipo de cita" : "No se encontró ningún tipo de cita con el id " + id,
                response
            );
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            return new ApiResponse(
                false,
                "Error interno",
                null
            );
        }
    }

    @DeleteMapping(value = "/eliminarTipoCita/{id}")
    public ApiResponse deleteTipoCita(@PathVariable Integer id) {
        try {
            TipoCitaModel response = tipoCitaService.getTipoCita(id);
            if (response == null) {
                return new ApiResponse(
                    false,
                    "El tipo de cita con el id "+id+" no existe",
                    null
                );
            }
            tipoCitaService.deleteTipoCita(id);
            return new ApiResponse(
                true,
                "El tipo de cita ha sido eliminado",
                null
            );
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            return new ApiResponse(
                false,
                "Error interno",
                null
            );
        }
    }

    @PutMapping(value = "/actualizarEstadoTipoCita/{id}")
    public ApiResponse updateEstadoTipoCita(@PathVariable Integer id) {
        try {
            TipoCitaModel tipoCita = tipoCitaService.getTipoCita(id);
            if (tipoCita == null) {
                return new ApiResponse(
                    false,
                    "El tipo de cita con el id "+id+" no existe",
                    null
                );
            }
            String response = tipoCitaService.updateEstadoTipoCita(tipoCita.getEstado(), id);
            tipoCita.setEstado(response);
            return new ApiResponse(
                true,
                "El tipo de cita ha sido actualizada!",
                tipoCita
            );
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            return new ApiResponse(
                false,
                "Error interno",
                null
            );
        }
    }
}
