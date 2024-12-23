package in.sbmbank.Service.serviceInterface;

import in.sbmbank.FormBinding.signUpBinding;
import in.sbmbank.FormBinding.loginFormBinding;
import in.sbmbank.entity_interface.entity.AccountHolderEntity;

public interface serviceInterface {


    public boolean SaveAccountHolder(signUpBinding registration);

    public boolean LoginAccountHolder(loginFormBinding login );

    public Integer Deposit(Integer amount, String username ,String password);


}
