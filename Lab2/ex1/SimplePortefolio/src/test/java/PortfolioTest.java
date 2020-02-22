import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class PortfolioTest {
    @Mock
    private StockMarket marketMock;
    @InjectMocks
    private Portfolio portfolio;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        portfolio.setName("NewPortfolio");
        portfolio.setStockMarket(marketMock);
    }

    @Test
    void getTotalValue() {
        when(marketMock.getPrice("Ebay")).thenReturn(42.00);
        Stock ebayStock = new Stock("Ebay", 2);
        portfolio.addStock(ebayStock);
        assertEquals(84.00, portfolio.getTotalValue());
    }
}