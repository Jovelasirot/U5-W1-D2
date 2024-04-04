package jovelAsirot.U5W1D2.entities;

import jovelAsirot.U5W1D2.enums.OrderStatus;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Order {
    private int orderNumber;
    private OrderStatus status;
    private int numberOfSeats;
    private LocalDate acquisitionTime;
    private List<MenuItem> items = new ArrayList<>();
    private double totalAmount;

    public int getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(int orderNumber) {
        this.orderNumber = orderNumber;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public int getNumberOfSeats() {
        return numberOfSeats;
    }

    public void setNumberOfSeats(int numberOfSeats) {
        this.numberOfSeats = numberOfSeats;
    }

    public LocalDate getAcquisitionTime() {
        return acquisitionTime;
    }

    public void setAcquisitionTime(LocalDate acquisitionTime) {
        this.acquisitionTime = acquisitionTime;
    }

    public List<MenuItem> getItems() {
        return items;
    }

    public void setItems(List<MenuItem> items) {
        this.items = items;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderNumber=" + orderNumber +
                ", status=" + status +
                ", numberOfSeats=" + numberOfSeats +
                ", acquisitionTime=" + acquisitionTime +
                ", items=" + items +
                ", totalAmount=" + totalAmount +
                '}';
    }
}
