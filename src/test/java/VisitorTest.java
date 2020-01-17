import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class VisitorTest {

    @Test
    void save() {
        Visitor save = new Visitor();
        assertSame(Visitor.save("Morgan",25,25,25,"none","none"), Visitor.save("Zama",25,25,25,"hello","no"));

    }

    @Test
    void load() {
        Visitor load = new Visitor();
        assertSame("Morgan","Morgan");
    }
}