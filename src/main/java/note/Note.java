package note;

import exceptions.UnknownValueException;

public class Note {

    public enum Alteration{

        DOUBLE_SHARP(2),
        SHARP(1),
        NATURAL(0),
        FLAT(-1),
        DOUBLE_FLAT(-2)

        ;

        private final int value;
        Alteration(int value){
            this.value = value;
        }

        public int getValue() {
            return value;
        }

        public static Alteration getByValue(int value){
            switch (value){
                case -2: return DOUBLE_FLAT;
                case -1: return FLAT;
                case 0: return NATURAL;
                case 1: return SHARP;
                case 2: return DOUBLE_SHARP;
                default: throw new UnknownValueException("Cannot interpret alteration value of " + value + ".");
            }
        }
    }

}
