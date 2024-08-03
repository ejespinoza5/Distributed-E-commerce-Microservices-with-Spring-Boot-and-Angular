import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import {Observable, Subscription} from 'rxjs';
import { DataService } from "../../services/data-service.service";
import {EditarProductoComponent} from "../editar-producto/editar-producto.component";
import {MatDialog} from "@angular/material/dialog";

@Component({
  selector: 'app-tabla-producto',
  templateUrl: './tabla-producto.component.html',
  styleUrls: ['./tabla-producto.component.css']
})
export class TablaProductoComponent implements OnInit {
  productos: any[] = [];
  producto: any; // Declara la propiedad producto
  subscription: Subscription; // Declara la propiedad subscription
  proveedores: any[] = [];
  categorias: any[] = [];



  pageSize = 10;
  page = 1;
  totalItems: number =0;
  pageSizeOptions = [5, 10, 15, 20];
  displayedColumns: string[] = ['nombre', 'descripcion', 'precio', 'stock', 'proveedor_id', 'categoria_id', 'acciones'];

  constructor(private http: HttpClient, private dataService: DataService, private dialog: MatDialog) {
    this.subscription = new Subscription();
  } // Inyecta el servicio DataService

  loadData(): void {
    this.http.get<any[]>('http://localhost:8080/productos/listar')
      .subscribe(data => {
        this.productos = data;
        this.totalItems = this.productos.length;
      });
  }

ngOnInit(): void {
  this.http.get<any[]>('http://localhost:8080/proveedores/listar')
    .subscribe(data => {
      this.proveedores = data;
      this.dataService.actualizarProveedores(data);
    });

  this.http.get<any[]>('http://localhost:8080/productos/listar')
    .subscribe(data => {
      this.productos = data;
      this.totalItems = this.productos.length;
    });

  this.subscription = this.dataService.data$.subscribe(producto => {
    this.producto = producto;
  });

  this.dataService.categoriasActualizadas$.subscribe((categorias: any[]) => {
    this.categorias = categorias;
  });

  this.dataService.proveedoresActualizados$.subscribe((proveedores: any[]) => {
    this.proveedores = proveedores;
  });
}

  pageChanged(event: number): void {
    this.page = event;
  }


  editProduct(product: any): void {
  this.dataService.changeData(product);
  this.dialog.open(EditarProductoComponent);
}
// En tu servicio

  deleteProduct(id: number): void {
    this.http.delete(`http://localhost:8080/productos/${id}`).subscribe(response => {
      console.log('Producto eliminado:', response);
      // Aquí puedes actualizar la lista de productos si es necesario
    }, error => {
      console.error('Error:', error);
    });
  }

  close(): void {
    this.dataService.closeModal();
  }
}
