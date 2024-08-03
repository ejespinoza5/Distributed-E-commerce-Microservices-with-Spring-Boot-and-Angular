import { NgModule } from '@angular/core';
import { BrowserModule, provideClientHydration } from '@angular/platform-browser';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { FormularioProductoComponent } from './microservicio_1/formulario-producto/formulario-producto.component';
import {FormsModule, ReactiveFormsModule} from "@angular/forms";
import {HttpClientModule} from "@angular/common/http";
import { FormularioCategoriaComponent } from './microservicio_1/formulario-categoria/formulario-categoria.component';
import { FormularioProveedorComponent } from './microservicio_1/formulario-proveedor/formulario-proveedor.component';
import { TablaProductoComponent } from './microservicio_1/tabla-producto/tabla-producto.component';
import {TableModule} from "primeng/table";
import {BrowserAnimationsModule} from "@angular/platform-browser/animations";
import {MatTableModule} from "@angular/material/table";
import { provideAnimationsAsync } from '@angular/platform-browser/animations/async';
import {MatIcon} from "@angular/material/icon";
import {MatFormField} from "@angular/material/form-field";
import {MatOption, MatSelect} from "@angular/material/select";
import {MatSelectModule} from "@angular/material/select";
import {NgxPaginationModule} from "ngx-pagination";
import { EditarProductoComponent } from './microservicio_1/editar-producto/editar-producto.component';
import {MatDialog, MatDialogModule} from "@angular/material/dialog";
import { FormularioPedidoDetalleComponent } from './microservicio_2/formulario-pedido-detalle/formulario-pedido-detalle.component';
import { FormularioPagoComponent } from './microservicio_2/formulario-pago/formulario-pago.component';
import {MatSidenav, MatSidenavContainer, MatSidenavContent} from "@angular/material/sidenav";
import {MatToolbar} from "@angular/material/toolbar";
import {MatNavList} from "@angular/material/list";
import {MatMenu, MatMenuTrigger} from "@angular/material/menu";



@NgModule({
  declarations: [
    AppComponent,
    FormularioProductoComponent,
    FormularioCategoriaComponent,
    FormularioProveedorComponent,
    TablaProductoComponent,
    EditarProductoComponent,
    FormularioPedidoDetalleComponent,
    FormularioPagoComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    ReactiveFormsModule,
    HttpClientModule,
    TableModule,
    BrowserAnimationsModule,
    MatTableModule,
    MatIcon,
    MatFormField,
    MatSelect,
    MatOption,
    MatSelectModule,
    NgxPaginationModule,
    FormsModule,
    MatDialogModule,
    MatSidenavContent,
    MatToolbar,
    MatNavList,
    MatSidenav,
    MatSidenavContainer,
    MatMenuTrigger,
    MatMenu
  ],
  providers: [
    provideClientHydration(),
    provideAnimationsAsync()
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
