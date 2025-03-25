package com.example.groupe2_2025;

public enum TypeOperationEnum {

    ADD("+"),
    MOINS("-"),
    MULTIPLIER("x"),
    DIVISER("/");
    private String symbole;

    TypeOperationEnum(String s) {
        this.symbole=s;
    }

    public String getSymbole() {
        return symbole;
    }

    public static Integer calcul(TypeOperationEnum typeOperationEnum, Integer premierElement,Integer deuxiemeElement){
        switch (typeOperationEnum){
            case ADD:
                return premierElement+deuxiemeElement;
            case MOINS:
                return premierElement-deuxiemeElement;
            case DIVISER:
                return premierElement/deuxiemeElement;
            case MULTIPLIER:
                return premierElement*deuxiemeElement;
            default:
                return 0;
        }
    }
}
