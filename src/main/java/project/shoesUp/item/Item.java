package project.shoesUp.item;

import lombok.Data;

@Data
public class Item {
    private Long id; //상품 아이디
    private String itemName; //상품명
    private Integer price; //상품가격
    private String date; //출시일

    private ItemType itemType; //상품종류
    private String brand; // 브랜드 종류


}
