package jolaexpress.africa.data.dto.respond;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter

public class CustomerRegistrationResponse{
    private  Long id;
    private String message;
    private int code;
}
