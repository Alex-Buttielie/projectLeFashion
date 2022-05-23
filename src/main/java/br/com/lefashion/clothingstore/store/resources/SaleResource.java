package br.com.lefashion.clothingstore.store.resources;

import br.com.lefashion.clothingstore.store.dtos.SaleDTO;
import br.com.lefashion.clothingstore.store.services.SaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/sale")
public class SaleResource {

    @Autowired
    private SaleService service;

    private SaleService getService () {
        return this.service;
    }

    private ResponseEntity runSale (SaleDTO dto) {
        return ResponseEntity.ok().body(this.getService().runSale(dto));
    }

}
