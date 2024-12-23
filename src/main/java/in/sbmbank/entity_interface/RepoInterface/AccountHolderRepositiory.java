package in.sbmbank.entity_interface.RepoInterface;

import in.sbmbank.entity_interface.entity.AccountHolderEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountHolderRepositiory extends JpaRepository <AccountHolderEntity , Integer> {


    AccountHolderEntity findByUsernameAndPassword(String username, String password);
}
