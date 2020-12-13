package models;

public class Booking {
    private Customer customer;
    private ServiceProvider serviceProvider;

    public Booking(Customer customer, ServiceProvider serviceProvider) {
        this.customer = customer;
        this.serviceProvider = serviceProvider;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public ServiceProvider getServiceProvider() {
        return serviceProvider;
    }

    public void setServiceProvider(ServiceProvider serviceProvider) {
        this.serviceProvider = serviceProvider;
    }
}
