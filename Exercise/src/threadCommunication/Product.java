package threadCommunication;

public class Product
{
    private int product;

    public Product(int product)
    {
        this.product = product;
    }

    public int getProduct()
    {
        return product;
    }

    public void reducePro(int number)
    {
        product-=number;
    }
    public void increasePro(int number)
    {
        product=product+number;
    }
}
