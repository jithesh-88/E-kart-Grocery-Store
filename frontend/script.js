const BASE_URL = "http://localhost:8081";


// LOAD PRODUCTS

async function loadProducts() {

    const response =
        await fetch(`${BASE_URL}/products`);

    const products =
        await response.json();

    const tableBody =
        document.getElementById("productTableBody");

    tableBody.innerHTML = "";

    products.forEach(product => {

        tableBody.innerHTML += `

            <tr>

                <td>${product.productId}</td>

                <td>${product.name}</td>

                <td>${product.category}</td>

                <td>${product.price}</td>

                <td>${product.stockQuantity}</td>

            </tr>

        `;
    });
}


// LOAD CUSTOMERS

async function loadCustomers() {

    const response =
        await fetch(`${BASE_URL}/customers`);

    const customers =
        await response.json();

    const tableBody =
        document.getElementById("customerTableBody");

    tableBody.innerHTML = "";

    customers.forEach(customer => {

        tableBody.innerHTML += `

            <tr>

                <td>${customer.customerId}</td>

                <td>${customer.name}</td>

                <td>${customer.phone}</td>

            </tr>

        `;
    });
}


// LOAD SUPPLIERS

async function loadSuppliers() {

    const response =
        await fetch(`${BASE_URL}/suppliers`);

    const suppliers =
        await response.json();

    const tableBody =
        document.getElementById("supplierTableBody");

    tableBody.innerHTML = "";

    suppliers.forEach(supplier => {

        tableBody.innerHTML += `

            <tr>

                <td>${supplier.supplierId}</td>

                <td>${supplier.name}</td>

                <td>${supplier.contact}</td>

            </tr>

        `;
    });
}


// ADD PRODUCT

async function addProduct() {

    const product = {

        name:
            document.getElementById("productName").value,

        category:
            document.getElementById("productCategory").value,

        price:
            parseFloat(
                document.getElementById("productPrice").value
            ),

        stockQuantity:
            parseInt(
                document.getElementById("productStock").value
            )
    };

    await fetch(`${BASE_URL}/products`, {

        method: "POST",

        headers: {
            "Content-Type": "application/json"
        },

        body: JSON.stringify(product)
    });

    alert("✅ Product Added");

    loadProducts();
}


// ADD CUSTOMER

async function addCustomer() {

    const customer = {

        name:
            document.getElementById("customerName").value,

        phone:
            document.getElementById("customerPhone").value
    };

    await fetch(`${BASE_URL}/customers`, {

        method: "POST",

        headers: {
            "Content-Type": "application/json"
        },

        body: JSON.stringify(customer)
    });

    alert("✅ Customer Added");

    loadCustomers();
}


// ADD SUPPLIER

async function addSupplier() {

    const supplier = {

        name:
            document.getElementById("supplierName").value,

        contact:
            document.getElementById("supplierContact").value
    };

    await fetch(`${BASE_URL}/suppliers`, {

        method: "POST",

        headers: {
            "Content-Type": "application/json"
        },

        body: JSON.stringify(supplier)
    });

    alert("✅ Supplier Added");

    loadSuppliers();
}


// ADD STOCK

async function addStock() {

    const productId =
        document.getElementById("stockProductId").value;

    const supplierId =
        document.getElementById("stockSupplierId").value;

    const quantity =
        document.getElementById("stockQuantity").value;

    const response = await fetch(

        `${BASE_URL}/stock/add?productId=${productId}&supplierId=${supplierId}&quantity=${quantity}`,

        {
            method: "POST"
        }
    );

    const result =
        await response.text();

    alert(result);

    loadProducts();
}


// PLACE ORDER

async function placeOrder() {

    const customerId =
        document.getElementById("customerId").value;

    const productId =
        document.getElementById("productId").value;

    const quantity =
        document.getElementById("quantity").value;

    const response = await fetch(

        `${BASE_URL}/orders/place?customerId=${customerId}&productId=${productId}&quantity=${quantity}`,

        {
            method: "POST"
        }
    );

    const result =
        await response.text();

    alert(result);

    loadProducts();
}


// INITIAL LOAD

loadProducts();
loadCustomers();
loadSuppliers();