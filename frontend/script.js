const API_URL = "http://localhost:8081/products";

// ✅ LOAD PRODUCTS
function loadProducts() {
    fetch(API_URL)
        .then(res => res.json())
        .then(data => {
            const table = document.getElementById("productTable");
            table.innerHTML = "";

            data.forEach(p => {
                table.innerHTML += `
                    <tr>
                        <td>${p.id}</td>
                        <td>${p.name}</td>
                        <td>${p.price}</td>
                        <td>${p.quantity}</td>
                        <td>
                            <button onclick="deleteProduct(${p.id})">Delete</button>
                        </td>
                    </tr>
                `;
            });
        })
        .catch(err => console.error("Load Error:", err));
}

// ✅ ADD PRODUCT
function addProduct() {
    const product = {
        name: document.getElementById("name").value,
        price: parseFloat(document.getElementById("price").value),
        quantity: parseInt(document.getElementById("quantity").value)
    };

    fetch(API_URL, {
        method: "POST",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify(product)
    })
    .then(res => res.json())
    .then(() => {
        loadProducts();

        // clear inputs
        document.getElementById("name").value = "";
        document.getElementById("price").value = "";
        document.getElementById("quantity").value = "";
    })
    .catch(err => console.error("Add Error:", err));
}

// ✅ DELETE PRODUCT
function deleteProduct(id) {
    fetch(API_URL + "/" + id, {
        method: "DELETE"
    })
    .then(() => loadProducts())
    .catch(err => console.error("Delete Error:", err));
}

// ✅ LOAD DATA WHEN PAGE OPENS
window.onload = loadProducts;