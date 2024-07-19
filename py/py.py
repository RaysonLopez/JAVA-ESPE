import json
import random

products = []

for i in range(1, 51):
    product = {
        "codigo": f"P{i:03d}",
        "nombre": f"Producto {i}",
        "precio": round(random.uniform(10.0, 100.0), 2)
    }
    products.append(product)

with open('productos.json', 'w') as f:
    json.dump(products, f, indent=4)

print("JSON creado con 50 productos.")
