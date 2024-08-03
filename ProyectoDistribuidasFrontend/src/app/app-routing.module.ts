import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {FormularioCategoriaComponent} from "./microservicio_1/formulario-categoria/formulario-categoria.component";
import {FormularioProveedorComponent} from "./microservicio_1/formulario-proveedor/formulario-proveedor.component";
import {TablaProductoComponent} from "./microservicio_1/tabla-producto/tabla-producto.component";
import {FormularioProductoComponent} from "./microservicio_1/formulario-producto/formulario-producto.component";
import {
  FormularioPedidoDetalleComponent
} from "./microservicio_2/formulario-pedido-detalle/formulario-pedido-detalle.component";
import {FormularioPagoComponent} from "./microservicio_2/formulario-pago/formulario-pago.component";


const routes: Routes = [
  { path: 'categorias', component: FormularioCategoriaComponent },
  { path: 'proveedores', component: FormularioProveedorComponent },
  { path: 'productos', component: TablaProductoComponent },
  { path: 'productos/nuevo', component: FormularioProductoComponent },
  { path: 'pedidos', component: FormularioPedidoDetalleComponent },
  { path: 'pagos', component: FormularioPagoComponent },
  { path: '', redirectTo: '/categorias', pathMatch: 'full' }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
