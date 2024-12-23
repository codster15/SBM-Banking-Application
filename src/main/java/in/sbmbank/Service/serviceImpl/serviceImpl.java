package in.sbmbank.Service.serviceImpl;

import in.sbmbank.FormBinding.signUpBinding;
import in.sbmbank.FormBinding.loginFormBinding;
import in.sbmbank.Service.serviceInterface.serviceInterface;
import in.sbmbank.entity_interface.RepoInterface.AccountHolderRepositiory;
import in.sbmbank.entity_interface.entity.AccountHolderEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class serviceImpl implements serviceInterface {


    @Autowired
    private AccountHolderRepositiory accholderRepo;

    @Override
    public Integer Deposit(Integer amount, String username, String password) {
        AccountHolderEntity account = accholderRepo.findByUsernameAndPassword(username, password);



            if(account.getTotalAmount() == null){
               account.setTotalAmount(amount);
               accholderRepo.save(account);
               return amount;
            }if(account.getTotalAmount() > 0){
            Integer totalAmount = account.getTotalAmount();
            totalAmount += amount;
            account.setTotalAmount(totalAmount);
            accholderRepo.save(account);
            return totalAmount;
        }

        return null;

//
//        for (AccountHolderEntity acc: all){
//            if(acc.getUsername().equals(username) && acc.getPassword().equals(password)){
//
//                if(acc.getTotalAmount() == null){
//                    totalAmount += amount;
//
//
//                    System.out.println("if- with zero balanace - " + totalAmount );
//                    return totalAmount;
//                }
//               if(acc.getTotalAmount()>0){
//                   Integer someAmount = acc.getTotalAmount();
//                   someAmount += amount;
//                   amountTotal = someAmount;
//
//                   System.out.println("if- with Some old balanace - " + amountTotal );
//                   return amountTotal;

//               }
//
//
//
//            }
//        }
//
//
//        System.out.println(totalAmount);
//        System.out.println(amountTotal);
//

    }






    @Override
    public boolean SaveAccountHolder(signUpBinding registration) {

        AccountHolderEntity accountHolder = new AccountHolderEntity();

        accountHolder.setUsername(registration.getUsername());
        accountHolder.setPassword(registration.getPassword());


       accholderRepo.save(accountHolder);

        return true;
    }

    @Override
    public boolean LoginAccountHolder(loginFormBinding login) {

        String username = login.getUsername();
        String password = login.getPassword();

        List<AccountHolderEntity> all = accholderRepo.findAll();


        for (AccountHolderEntity user : all){
            if(user.getUsername().equals(username) && user.getPassword().equals(password) ){
                return true;
            }
        }

        return false;
    }



}
