package dev.prototype.iamportal.application.account;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class RegistrationController {

//    @Authenticate(fetchPermission = INITIATE_REQUEST)
//    @PostMapping({"/v1/contracts",
//        "/contract/v1/requests"})
//    public ContractDTO createContract(@RequestBody RequestInput input) {
//        ContractDependencies d = ContractDependencies.from(appContext);
//        RequestDTO requestDTO = new CmdCreateContract(input, domain)
//            .authorized(d)
//            .execute(d);
//        return ContractDTO.from(requestDTO);
//    }
}
