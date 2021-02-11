import junit.framework.TestCase;
import org.mockito.Mock;
import org.mockito.Mockito;

public class TradeTest extends TestCase {

    Trade trade;
    MallonExchange mockExchange = Mockito.mock(MallonExchange.class);

    @Override
    public void setUp() throws Exception {
        super.setUp();

        Mockito.when(mockExchange.getPrice(Mockito.anyString(), Mockito.anyInt()))
                .thenReturn(3.0);

        this.trade = new Trade(
                "1",
                "GOOGL",
                3,
                mockExchange
        );
    }

    public void testSetPrice() {}

    public void testGetWorth() {
        assertEquals(
                9.0,
                trade.getWorth()
        );

        Mockito.verify(mockExchange)
                .getPrice(Mockito.eq("GOOGL"), Mockito.eq(3));
    }

//    public void testSetPriceShouldUpdatePriceOnlyForNonNegatives() {
//        assertEquals(
//                0,
//                trade.setPrice(-9),
//                "Ensure non-negative prices only"
//        );
//    }

}