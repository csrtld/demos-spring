package com.ig.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import cl.bci.integ.db.banele.convenios.client.sp_OMNI_eli_enr_empClient;
import cl.bci.integ.db.banele.enrolamiento.client.sp_OMNI_mig_cam_id_grupo_serClient;

@RestController
public class IgController {

    @Autowired
    sp_OMNI_eli_enr_empClient sp_OMNI_eli_enr_empClient;

    @Autowired
    sp_OMNI_mig_cam_id_grupo_serClient sp_OMNI_mig_cam_id_grupo_serClient;

    @GetMapping(value = "/get-sp-banele")
    public String getDtoService() {
        return "ok";
    }
}
