import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MainTest {
    @Test
    public void testEmpty() {
        Assertions.assertThrows(NumberFormatException.class, () -> Integer.decode(""), "Zero length string");
    }

    @Test
    public void justStringTest() {
        Assertions.assertThrows(NumberFormatException.class, () -> Integer.decode("Test string"), "For input string: \"Test string\"");
    }

    @Test
    public void zeroTest() {
        Assertions.assertEquals(0, Integer.decode("+0"));
        Assertions.assertEquals(0, Integer.decode("0"));
        Assertions.assertEquals(0, Integer.decode("-0"));
    }

    @Test
    public void forMaxTest() {
        Assertions.assertEquals(Integer.MAX_VALUE, Integer.decode(Integer.MAX_VALUE + ""));
    }

    @Test
    public void forMinTest() {
        Assertions.assertEquals(Integer.MIN_VALUE, Integer.decode(Integer.MIN_VALUE + ""));
    }

    @Test
    public void positiveNegativeTest() {
        Assertions.assertEquals(1, Integer.decode("+1"));
        Assertions.assertEquals(1, Integer.decode("1"));
        Assertions.assertEquals(-1, Integer.decode("-1"));
    }

    @Test
    public void hexTest() {
        Assertions.assertEquals(16, Integer.decode("0x10"));
        Assertions.assertEquals(273, Integer.decode("0X111"));
        Assertions.assertEquals(273, Integer.decode("0x0111"));
        Assertions.assertEquals(-272, Integer.decode("-0x110"));
        Assertions.assertEquals(289, Integer.decode("#121"));
        Assertions.assertEquals(-274, Integer.decode("-#112"));
    }

    @Test
    public void signWrongPosTest() {
        Assertions.assertThrows(NumberFormatException.class, () -> Integer.decode("1+2"), "Sign character in wrong position");
    }

    @Test
    public void octalTest() {
        Assertions.assertEquals(8, Integer.decode("010"));
        Assertions.assertEquals(-8, Integer.decode("-010"));
        Assertions.assertEquals(9, Integer.decode("011"));
        Assertions.assertEquals(-9, Integer.decode("-011"));
    }
}