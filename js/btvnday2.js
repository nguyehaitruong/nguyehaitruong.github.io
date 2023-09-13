let products = [
    {
        name: "Iphone 13 Pro Max", // Tên sản phẩm
        price: 3000000, // Giá mỗi sản phẩm
        brand: "Apple", // Thương hiệu
        count: 2, // Số lượng sản phẩm trong giỏ hàng
    },
    {
        name: "Samsung Galaxy Z Fold3",
        price: 41000000,
        brand: "Samsung",
        count: 1,
    },
    {
        name: "IPhone 11",
        price: 15500000,
        brand: "Apple",
        count: 1,
    },
    {
        name: "OPPO Find X3 Pro",
        price: 19500000,
        brand: "OPPO",
        count: 3,
    },
]
console.log(products[2])
let newProduct = {
    name: " MI 13",
    price: 500000, 
    brand: "XIAOMI",
    count: 10, 
};
products.push(newProduct);
console.log(products);


for (let i = 0; i < products.length; i++) {
    if (products[i].brand === "Samsung") {
        for (let j = i; j < products.length - 1; j++) {
            products[j] = products[j + 1];
        }
        products.length--;
        i--;
    }
}
console.log(products);
products.sort((a, b) => a.price - b.price);
console.log(products);

products.sort((a, b) => b.count - a.count);
console.log(products);


let TwoProducts = [products[0], products[1]];
console.log(TwoProducts);


