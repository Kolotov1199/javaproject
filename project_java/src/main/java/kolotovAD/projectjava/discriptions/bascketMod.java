package kolotovAD.projectjava.discriptions;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import kolotovAD.projectjava.entity.BascketMod;

public class bascketMod {

    private Long id;
    @NotBlank
    private String brand;

    @Positive
    private String fullnamesn;
    @Positive
    private String country;
    @Positive
    private String type;
    @Positive
    private String imgUrl;

    public BascketMod toEntity() {
        var basck = new BascketMod();
        basck.setId(id);
        basck.setBrand(brand);
        basck.setFullnamesn(fullnamesn);
        basck.setImgUrl(imgUrl);
        basck.setCountry(country);
        basck.setType(type);

        return basck;
    }
}
