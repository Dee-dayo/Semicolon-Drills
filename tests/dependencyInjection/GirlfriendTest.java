package dependencyInjection;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GirlfriendTest {

    @Test
    public void testGirlfriend(){
        LekkiGuy franklin = new LekkiGuy();
        MushinGuy dayo = new MushinGuy();
        IkoroduGuy femi = new IkoroduGuy();

        Girlfriend blessing = new Girlfriend(femi);
        blessing.spend();

        blessing.setBoyfriend(dayo);
        blessing.spend();
    }

}