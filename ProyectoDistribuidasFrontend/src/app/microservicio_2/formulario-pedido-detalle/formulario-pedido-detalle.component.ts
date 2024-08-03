import {Component, OnInit} from '@angular/core';
import {FormControl, FormGroup} from "@angular/forms";
import {HttpClient} from "@angular/common/http";
import {ChangeDetectorRef} from '@angular/core';
import {map, switchMap, tap} from "rxjs/operators";

interface Product {
  id: number;
  nombre: string;
  precio: number;
  stock: number;
}

@Component({
  selector: 'app-formulario-pedido-detalle',
  templateUrl: './formulario-pedido-detalle.component.html',
  styleUrls: ['./formulario-pedido-detalle.component.css']
})
export class FormularioPedidoDetalleComponent implements OnInit {

  products: Product[] = [];
  productoForm = new FormGroup({
    productoId: new FormControl(''),
    precioUnitario: new FormControl(''),
    stock: new FormControl(),
    nombreCliente: new FormControl(''),
    apellidosCliente: new FormControl(''),
    cedulaCliente: new FormControl(''),
    cantidad: new FormControl(''),
    total: new FormControl(""),
    fecha_entrega: new FormControl(''),
  });

  constructor(private http: HttpClient, private cdr: ChangeDetectorRef) {
  }

  ngOnInit(): void {
    this.http.get<Product[]>('http://localhost:8081/pedidos-detalles/productos').subscribe(products => {
      this.products = products;
      this.cdr.detectChanges();
    });

    this.productoForm.get('productoId')?.valueChanges.pipe(
      switchMap(productId => this.http.get<Product>(`http://localhost:8081/pedidos-detalles/consumir/${productId}`)),
      map(product => ({
        ...product,
        precioUnitario: product.precio.toString(),
        stock: product.stock.toString(),
      }))
    ).subscribe(product => {
      // Actualiza los controles 'precio' y 'stock'
      const precioControl = this.productoForm.get('precioUnitario');
      const stockControl = this.productoForm.get('stock');
      if (precioControl && stockControl && product) {
        precioControl.setValue(product.precioUnitario);
        stockControl.setValue(product.stock);
      }
    });

    this.productoForm.get('cantidad')?.valueChanges.subscribe(() => {
      const precioControl = this.productoForm.get('precioUnitario');
      const cantidadControl = this.productoForm.get('cantidad');
      if (precioControl && precioControl.value && cantidadControl && cantidadControl.value) {
        const precio = parseFloat(precioControl.value);
        const cantidad = parseFloat(cantidadControl.value);
        if (!isNaN(precio) && !isNaN(cantidad)) {
          this.productoForm.get('total')?.setValue((precio * cantidad).toString());
        }
      }
    });


  }

 onSubmit() {
  const productoId = this.productoForm.get('productoId')?.value;
  const cantidad = this.productoForm.get('cantidad')?.value;
  const stock = this.productoForm.get('stock')?.value;


  if (cantidad !== null && cantidad !== undefined && stock !== null && stock !== undefined) {
    if (cantidad > stock) {
      alert('Cantidad de productos no dispobibles');
    } else {
      this.http.put(`http://localhost:8081/pedidos-detalles/consumir/${productoId}/${cantidad}`, {})
        .pipe(
          switchMap(() => this.http.post('http://localhost:8081/pedidos-detalles', this.productoForm.value))
        )
        .subscribe(
          response => {
            console.log(response);
          },
          error => {
            console.error(error);
            if (error.status === 400 && error.error.message === 'Stock insuficiente') {
              alert('El producto está agotado');
            }
          }
        );
    }
  }
}
}
