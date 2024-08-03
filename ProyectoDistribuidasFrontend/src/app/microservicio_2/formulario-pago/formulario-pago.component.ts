import {Component, OnInit} from '@angular/core';
import {FormControl, FormGroup} from "@angular/forms";
import {HttpClient} from "@angular/common/http";

interface Pedido {
  id: number;
  fecha: string;
  total: number;
  cedulaCliente: string;
  nombreCliente: string;
  apellidosCliente: string;
  productoId: number;
  cantidad: number;
  precioUnitario: number;
}

@Component({
  selector: 'app-formulario-pago',
  templateUrl: './formulario-pago.component.html',
  styleUrls: ['./formulario-pago.component.css']
})
export class FormularioPagoComponent implements OnInit {

  pedidos: Pedido[] = [];
  pagoForm = new FormGroup({
    id: new FormControl(''),
    pedidoId: new FormControl(''),
    nombreCliente: new FormControl(''),
    apellidosCliente: new FormControl(''),
    numeroTarjeta: new FormControl(''),
    fechaVencimiento: new FormControl(''),
    codigoSeguridad: new FormControl(''),
    monto: new FormControl("")
  });

  constructor(private http: HttpClient) {
  }

  ngOnInit(): void {
    this.http.get<Pedido[]>('http://localhost:8081/pedidos-detalles').subscribe(pedidos => {
      this.pedidos = pedidos;
    });

    this.pagoForm.get('pedidoId')?.valueChanges.subscribe(pedidoId => {
      const pedidoIdNumber = Number(pedidoId);
      const pedido = this.pedidos.find(p => p.id === pedidoIdNumber);
      if (pedido) {
        this.pagoForm.get('nombreCliente')?.setValue(pedido.nombreCliente);
        this.pagoForm.get('apellidosCliente')?.setValue(pedido.apellidosCliente);
        this.pagoForm.get('monto')?.setValue(pedido.total.toString());
      }
    });
  }

  onSubmit(): void {
    if (this.pagoForm.valid) {
      this.http.post('http://localhost:8081/pagos', this.pagoForm.value).subscribe(response => {
        console.log(response);

      }, error => {
        console.error(error);

      });
    }
  }
}
