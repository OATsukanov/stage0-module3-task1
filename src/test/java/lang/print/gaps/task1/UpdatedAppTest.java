package lang.print.gaps.task1;

import base.BaseIOTest;
import org.junit.jupiter.api.Test;

//import static org.junit.jupiter.api.Assertions.assertEquals;


class UpdatedAppTest extends BaseIOTest {

    @Test
    void mainUpdated() {
        UpdatedApp.main(null);

        assertEqualsForLogger(UpdatedApp.class, "I'm updated\ncan be compiled. And can write to console", "lang.print.gaps.task1.UpdatedApp");
    }
}
