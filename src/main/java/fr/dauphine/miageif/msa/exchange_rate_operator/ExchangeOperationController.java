package fr.dauphine.miageif.msa.exchange_rate_operator;


import org.json.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
public class ExchangeOperationController {
    @Autowired
    private Environment environment;
    @Autowired
    private ExchangeOperationRepository repository;





    @PostMapping("/exchange-operation")
    public ExchangeOperationEntity createExchangeOperation(@RequestBody ExchangeOperationEntity exchangeOperation){
        System.out.println("exchange operation controller");


        final String exchange_rate_uri = "http://localhost:8000/exchange-rate/source/" +
                exchangeOperation.getSource() + "/dest/" +
                exchangeOperation.getDest();

        System.out.println("exchange_rate_uri" + exchange_rate_uri);
        RestTemplate restTemplate = new RestTemplate();
        String result = restTemplate.getForObject(exchange_rate_uri, String.class);
        JSONObject obj = new JSONObject(result);
        double taux = obj.getDouble("taux");
        System.out.println("taux récupéré " + taux);
        exchangeOperation.setTaux(taux);
        return repository.save(exchangeOperation);

    }

    @GetMapping("/exchange-operation")
    public List<ExchangeOperationEntity> findAllExchangeOperations() {
        return repository.findAll();
    }

    @GetMapping("/exchange-operation/{id}")
    public ExchangeOperationEntity findExchangeOperationById(@PathVariable Long id) {
        return repository.findById(id).get();
    }

    /*@PostMapping("/exchange-operation/{id}")
    public ExchangeOperationEntity updatetaux(@RequestBody ExchangeOperationEntity exchangeTransaction, @PathVariable Long id) {
        return null;
    }*/

    @DeleteMapping("/exchange-operation/{id}")
    public void deleteOperationTauxChange(@PathVariable Long id) {
        repository.deleteById(id);
    }

}
