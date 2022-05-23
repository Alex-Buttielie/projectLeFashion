package br.com.lefashion.clothingstore.store.services.impl;

import br.com.lefashion.clothingstore.store.dtos.SaleDTO;
import br.com.lefashion.clothingstore.store.repository.SaleRepository;
import br.com.lefashion.clothingstore.store.services.SaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SaleServiceImpl implements SaleService {

    @Autowired
    private SaleRepository repository;

    protected SaleRepository getRepository () {
        return this.repository;
    }

    @Override
    public SaleDTO runSale(SaleDTO dto) {
        return null;
    }
}
