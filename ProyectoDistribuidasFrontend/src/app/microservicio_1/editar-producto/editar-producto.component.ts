import {Component, OnInit, OnDestroy} from '@angular/core';
import {DataService} from '../../services/data-service.service';
import {Subscription} from 'rxjs';
import {HttpClient} from "@angular/common/http";
import {FormControl, FormGroup, Validators} from "@angular/forms";
import {MatDialogRef} from "@angular/material/dialog";

@Component({
  selector: 'app-editar-producto',
  templateUrl: './editar-producto.component.html',
  styleUrls: ['./editar-producto.component.css']
})
export class EditarProductoComponent implements OnInit, OnDestroy {
  producto: any;
  subscription: Subscription;
  http: HttpClient;
  editing: boolean = false;
  productForm: FormGroup;

  proveedores: any[] = [];
  categorias: any[] = [];

  constructor(private dataService: DataService, http: HttpClient, private dialogRef: MatDialogRef<EditarProductoComponent>) {
    this.subscription = new Subscription();
    this.http = http;
    this.productForm = new FormGroup({
      nombre: new FormControl('', Validators.required),
      descripcion: new FormControl('', Validators.required),
      precio: new FormControl('', [Validators.required, Validators.min(0)]),
      stock: new FormControl('', [Validators.required, Validators.min(0)]),
      categoria_id: new FormControl('', Validators.required),
      proveedor_id: new FormControl('', Validators.required)
    });
  }

  ngOnInit(): void {
    this.subscription = this.dataService.data$.subscribe(producto => {
      if (producto) {
        this.producto = producto;
        this.editing = true;
        this.productForm.setValue({
          nombre: producto.nombre,
          descripcion: producto.descripcion,
          precio: producto.precio,
          stock: producto.stock,
          categoria_id: producto.categoria_id,
          proveedor_id: producto.proveedor_id
        });
      } else {
        this.editing = false;
      }
    });

    this.dataService.proveedoresActualizados$.subscribe((proveedores: any[]) => {
      this.proveedores = proveedores;
    });

    this.dataService.categoriasActualizadas$.subscribe((categorias: any[]) => {
      this.categorias = categorias;
    });

    this.http.get<any[]>('http://localhost:8080/proveedores/listar')
      .subscribe(data => {
        this.proveedores = data;
      });

    this.http.get<any[]>('http://localhost:8080/categorias/listar')
      .subscribe(data => {
        this.categorias = data;
        this.dataService.actualizarCategorias(data);
      });
  }

  ngOnDestroy(): void {
    this.subscription.unsubscribe();
  }

  close(): void {
    this.dataService.closeModal();
    this.dialogRef.close()
  }

  updateProduct(id: number, data: any): void {
  const dataWithoutId = {...data};
  delete dataWithoutId.id;
  console.log('Datos a enviar:', dataWithoutId);
  this.http.put(`http://localhost:8080/productos/${id}`, dataWithoutId)
    .subscribe(response => {
      console.log('Respuesta del servidor:', response);
      this.producto = response;
      this.editing = true;
    }, error => {
      console.error('Error:', error);
    });
}
}
