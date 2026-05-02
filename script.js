// Sample product data (later replace with backend data)
let products = [
    { id: 1, name: "Rice", price: 50, stock: 10 },
    { id: 2, name: "Sugar", price: 40, stock: 8 },
    { id: 3, name: "Milk", price: 30, stock: 5 }
];

let cart = [];

// Display products
function displayProducts() {
    let container = document.getElementById("product-list");
    container.innerHTML = "";

    products.forEach(p => {
        container.innerHTML += `
            <div class="product">
                <h3>${p.name}</h3>
                <p>Price: ₹${p.price}</p>
                <p>Stock: ${p.stock}</p>
                <input type="number" id="qty-${p.id}" min="1" value="1">
                <button onclick="addToCart(${p.id})">Add</button>
            </div>
        `;
    });
}

// Add to cart
function addToCart(id) {
    let qty = parseInt(document.getElementById(`qty-${id}`).value);
    let product = products.find(p => p.id === id);

    if (qty > product.stock) {
        alert("Not enough stock!");
        return;
    }

    let existing = cart.find(item => item.id === id);

    if (existing) {
        existing.qty += qty;
    } else {
        cart.push({ ...product, qty });
    }

    updateCart();
}

// Update cart UI
function updateCart() {
    let cartDiv = document.getElementById("cart");
    let total = 0;

    cartDiv.innerHTML = "";

    cart.forEach(item => {
        let subtotal = item.qty * item.price;
        total += subtotal;

        cartDiv.innerHTML += `
            <p>${item.name} - ${item.qty} x ₹${item.price} = ₹${subtotal}</p>
        `;
    });

    document.getElementById("total").innerText = "Total: ₹" + total;
}

// Checkout
function checkout() {
    if (cart.length === 0) {
        alert("Cart is empty!");
        return;
    }

    alert("Order placed successfully!");

    // Reduce stock (simulate DB update)
    cart.forEach(item => {
        let product = products.find(p => p.id === item.id);
        product.stock -= item.qty;
    });

    cart = [];
    displayProducts();
    updateCart();
}

// Initialize
displayProducts();