import {Component, OnInit, } from '@angular/core';
import {AbstractControl, FormBuilder, ValidationErrors, Validators} from '@angular/forms';
import {HttpClient} from "@angular/common/http";
import {DataService} from "../../services/data-service.service";

@Component({
  selector: 'app-formulario-producto',
  templateUrl: './formulario-producto.component.html',
  styleUrls: ['./formulario-producto.component.css']
})
export class FormularioProductoComponent implements OnInit {


  productoForm = this.fb.group({
    nombre: ['', Validators.required],
    descripcion: ['', Validators.required],
    precio: ['', [Validators.required, Validators.min(0), this.decimalValidator]],
    stock: ['', [Validators.required, Validators.min(0)]],
    categoria_id: ['', Validators.required],
    proveedor_id: ['', Validators.required]
  });

  proveedores: any[] = [];
  categorias: any[] = [];

  constructor(private fb: FormBuilder, private http: HttpClient, private dataService: DataService) {
  }


  ngOnInit(): void {
    this.dataService.categoriasActualizadas$.subscribe((categorias: any[]) => {
      this.categorias = categorias;
    });

    this.dataService.proveedoresActualizados$.subscribe((proveedores: any[]) => {
      this.proveedores = proveedores;

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

  onSubmit() {
    this.http.post('http://localhost:8080/productos/agregar', this.productoForm.value)
      .subscribe(response => {
        console.log(response);
        // handle your response here
      }, error => {
        console.error(error);
        // handle your error here
      });

  }

  decimalValidator(control: AbstractControl): ValidationErrors | null {
    const value = control.value;
    if (!Number(value)) {
      return {notANumber: true};
    }
    if (Math.floor(value) === value) {
      return {notADecimal: true};
    }
    return null;
  }


}
