package reflect;

import lombok.Data;

@Data
public class Bar {
 
    @Foo ("chen")
    private String val;

    private Boolean aBoolean;



}