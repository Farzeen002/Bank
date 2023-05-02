package com.bank.application.AccountRepository;





import org.springframework.data.repository.CrudRepository;

import com.bank.application.account.entity.Logger;



public interface LoggerRepository extends CrudRepository<Logger, Integer> {

}