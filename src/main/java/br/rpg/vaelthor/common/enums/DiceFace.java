package br.rpg.vaelthor.common.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum DiceFace {
    D4(4, "d4"),
    D6(6, "d6"),
    D8(8, "d8"),
    D10(10, "d9"),
    D12(12, "d12"),
    D20(20, "d20"),
    D100(100, "d100");

    private final int face;
    private final String desc;


    public static DiceFace getDiceFace(int face){
        for(DiceFace diceFace : DiceFace.values()){
            if(diceFace.face == face){
                return diceFace;
            }
        }
        return null;
    }
}
