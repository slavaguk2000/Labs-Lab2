package sample;

import java.util.List;

enum TypeOfProduct {
    AUTO,
    MATCH
}

public class Factory {
    private List<Worker> workers;
    private List<Product> products;
    private TypeOfProduct typeOfProduct;

    public boolean hireWorker() {
        Worker worker = new Worker();
        workers.add(worker);
        return true;
    }

    public Product releaseProduct(){
        Product product;
        if (typeOfProduct == typeOfProduct.AUTO) product = new Auto("Lexus");
        else if (typeOfProduct == typeOfProduct.MATCH) product = new Auto("Lexus");
        else product = new Product();
        for (Worker worker: workers) {
            worker.work();
        }
        return product;
    }

}
