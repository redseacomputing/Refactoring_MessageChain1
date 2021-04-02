package messagechain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class InvoiceTest {

    Invoice invoice;

    @BeforeEach
    void setUpInvoiceWithShippingCosts() {
        invoice = new Invoice(new Customer(new Address(new Country())));
    }

    @Test
    void ShouldReturnPriceOfOneItemWithShippingCost() {
        InvoiceItem item = new InvoiceItem(100);
        invoice.addItem(item);
        assertEquals(110, invoice.getTotalPrice());
    }

    @Test
    void ShouldReturnPriceOfTwoItemWithShippingCost() {
        InvoiceItem item = new InvoiceItem(100);
        invoice.addItem(item);
        invoice.addItem(item);
        assertEquals(210, invoice.getTotalPrice());
    }

}