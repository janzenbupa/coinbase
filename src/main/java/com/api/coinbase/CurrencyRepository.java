package com.api.coinbase;

//import org.springframework.data.repository.CrudRepository;

//public interface CurrencyRepository extends CrudRepository<Currency, String> {
  //  public Currency findCurrencyByName(String name);
//}

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface CurrencyRepository {
    Currency findCurrencyByName(String _id);

    ArrayList<Currency> findCurrencies();

    <T> String Serialize(T obj);
}
