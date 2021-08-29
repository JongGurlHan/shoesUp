package project.shoesUp.form;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class ItemSaveForm {


    @NotBlank
    private String itemName; //상품명

    @NotBlank //null을 허용하지 않는다.
    private String date; //출시일

    @NotBlank//null을 허용하지 않는다.
    private String releaseTime; //출시 시간


}
