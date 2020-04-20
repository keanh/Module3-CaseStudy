package model;

public class Order {
    private int id;
    private String nameProduct;
    private int price;
    private String nameAccount;
    private String phoneNumberAccount;
    private String pictureLink;
    private int idProduct;
    private int idAccount;
    private int total;
    private int totalOrder;

    public Order() {
    }

        public Order(int id,int total,int totalOrder) {
        this.id = id;
        this.total = total;
        this.totalOrder = totalOrder;
    }

    public Order(int idProduct, String nameProduct, int price, String pictureLink) {
        this.idProduct = idProduct;
        this.nameProduct = nameProduct;
        this.price = price;
        this.pictureLink = pictureLink;
    }

    public Order(String nameProduct, int price, String nameAccount, String phoneNumberAccount, String pictureLink) {
        this.nameProduct = nameProduct;
        this.price = price;
        this.nameAccount = nameAccount;
        this.phoneNumberAccount = phoneNumberAccount;
        this.pictureLink = pictureLink;
    }

    public Order(int idProduct, int idAccount) {
        this.idProduct = idProduct;
        this.idAccount = idAccount;
    }

    public Order(int id, String nameProduct, int price, String nameAccount, String phoneNumberAccount, int idProduct, int idAccount) {
        this.id = id;
        this.nameProduct = nameProduct;
        this.price = price;
        this.nameAccount = nameAccount;
        this.phoneNumberAccount = phoneNumberAccount;
        this.idProduct = idProduct;
        this.idAccount = idAccount;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getTotalOrder() {
        return totalOrder;
    }

    public void setTotalOrder(int totalOrder) {
        this.totalOrder = totalOrder;
    }

    public String getPictureLink() {
        return pictureLink;
    }

    public void setPictureLink(String pictureLink) {
        this.pictureLink = pictureLink;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNameProduct() {
        return nameProduct;
    }

    public void setNameProduct(String nameProduct) {
        this.nameProduct = nameProduct;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getNameAccount() {
        return nameAccount;
    }

    public void setNameAccount(String nameAccount) {
        this.nameAccount = nameAccount;
    }

    public String getPhoneNumberAccount() {
        return phoneNumberAccount;
    }

    public void setPhoneNumberAccount(String phoneNumberAccount) {
        this.phoneNumberAccount = phoneNumberAccount;
    }

    public int getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(int idProduct) {
        this.idProduct = idProduct;
    }

    public int getIdAccount() {
        return idAccount;
    }

    public void setIdAccount(int idAccount) {
        this.idAccount = idAccount;
    }
}
