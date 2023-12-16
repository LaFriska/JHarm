package note;

import exceptions.UnknownValueException;

/**
 * To efficiently calculate intervals and enharmonics, the lowest conceptual abstraction shall
 * be “base notes”. In JHarm, a base note is defined as a note without any alterations to it.
 * In other words, the 7 white notes within an octave on the piano are base notes. In JHarm, each
 * base note within 1 octave will be labelled with an identifier starting from the 0, mapped to a
 * C. Each base note should also have a chromatic value, which again starts from 0. The chromatic
 * value defines their position in the octave while counting the black notes in between.
 * **/
public enum BaseNote {
    C(0, 0),
    D(1, 2),
    E(2, 4),
    F(3, 5),
    G(4, 7),
    A(5, 9),
    B(6, 11)

    ;
    private final int id;
    private final int chrVal;

    private BaseNote(int id, int chrVal){
        this.id = id;
        this.chrVal = chrVal;
    }

    /**
     * Gets the corresponding BaseNote by the identifier. The ID is first reduced modulo 7 in case of
     * integers above or below 0 and 6 being input.
     * **/
    public static BaseNote get(int id){
        id = id % 7;
        switch (id){
            case 0: return C;
            case 1: return D;
            case 2: return E;
            case 3: return F;
            case 4: return G;
            case 5: return A;
            default: return B;
        }
    }

    /**
     * Gets the corresponding BaseNote by the chromatic value. The value is first reduced modulo 12 in case of
     * integers above or below 0 and 11 being input.
     * @throws UnknownValueException when a chromatic value that correlates to a black note on the keyboard is input.
     * **/
    public static BaseNote getByChromaticValue(int chrVal){
        chrVal = chrVal % 12;
        switch (chrVal){
            case 0: return C;
            case 2: return D;
            case 4: return E;
            case 5: return F;
            case 7: return G;
            case 9: return A;
            case 11: return B;
            default: throw new UnknownValueException("Input chromatic value does not correlate to a base note.");
        }
    }
    /**
     * Returns the base note identifier.
     * **/
    public int getId() {
        return id;
    }

    /**
     * Returns the base note chromatic value.
     * **/
    public int getChrVal() {
        return chrVal;
    }
}
