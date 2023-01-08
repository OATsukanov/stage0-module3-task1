package lang.print.gaps.task1;

import base.BaseIOTest;
import org.junit.jupiter.api.Test;

//import java.io.ByteArrayOutputStream;
import java.io.IOException;
//import java.util.InvalidPropertiesFormatException;

//import static org.junit.jupiter.api.Assertions.assertEquals;

class BrokenAppTest extends BaseIOTest {
    @Test
    void main() throws IOException {
        //BrokenApp.main(null);

        assertEqualsForLogger(BrokenApp.class, "fixMe", "lang.print.gaps.task1.BrokenApp");

    }


}