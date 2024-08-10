
import java.util.Date;

class Customer {
    private String name;
    private boolean member;
    private String memberType;

    public Customer(String name) {
        this.name = name;
        this.member = false;
        this.memberType = "";
    }

    public String getName() {
        return name;
    }

    public boolean isMember() {
        return member;
    }

    public void setMember(boolean member) {
        this.member = member;
    }

    public String getMemberType() {
        return memberType;
    }

    public void setMemberType(String memberType) {
        this.memberType = memberType;
    }
}

class Discount {
    public static double getServiceDiscountRate(String type) {
        switch (type) {
            case "Premium":
                return 0.2;
            case "Gold":
                return 0.15;
            case "Silver":
                return 0.1;
            default:
                return 0;
        }
    }

    public static double getProductDiscountRate(String type) {
        return 0.1;
    }
}

class Visit {
    private Customer customer;
    private Date date;
    private double serviceExpense;
    private double productExpense;

    public Visit(Customer customer, Date date) {
        this.customer = customer;
        this.date = date;
    }

    public String getCustomerName() {
        return customer.getName();
    }

    public double getServiceExpense() {
        return serviceExpense;
    }

    public void setServiceExpense(double serviceExpense) {
        this.serviceExpense = serviceExpense;
    }

    public double getProductExpense() {
        return productExpense;
    }

    public void setProductExpense(double productExpense) {
        this.productExpense = productExpense;
    }

    public double getTotalExpense() {
        double serviceDiscount = serviceExpense * Discount.getServiceDiscountRate(customer.getMemberType());
        double productDiscount = productExpense * Discount.getProductDiscountRate(customer.getMemberType());
        return (serviceExpense - serviceDiscount) + (productExpense - productDiscount);
    }
}

class BeautySaloon {
    public static void main(String[] args) {
        Customer customer1 = new Customer("Ram");
        customer1.setMember(true);
        customer1.setMemberType("Premium");

        Visit visit1 = new Visit(customer1, new Date());
        visit1.setServiceExpense(100);
        visit1.setProductExpense(50);

        System.out.println("Customer: " + visit1.getCustomerName());
        System.out.println("Total Expense: रु " + visit1.getTotalExpense());

        Customer customer2 = new Customer("Geeta");
        customer2.setMember(true);
        customer2.setMemberType("Silver");

        Visit visit2 = new Visit(customer2, new Date());
        visit2.setServiceExpense(80);
        visit2.setProductExpense(30);

        System.out.println("\nCustomer: " + visit2.getCustomerName());
        System.out.println("Total Expense: रु " + visit2.getTotalExpense());
    }
}