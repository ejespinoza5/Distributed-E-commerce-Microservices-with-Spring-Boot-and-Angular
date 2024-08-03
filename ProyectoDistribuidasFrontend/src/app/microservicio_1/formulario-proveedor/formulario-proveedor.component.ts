import { Component, OnInit } from '@angular/core';
import { FormBuilder, Validators } from '@angular/forms';
import { HttpClient } from "@angular/common/http";
import { DataService } from "../../services/data-service.service";

@Component({
  selector: 'app-formulario-proveedor',
  templateUrl: './formulario-proveedor.component.html',
  styleUrls: ['./formulario-proveedor.component.css']
})
export class FormularioProveedorComponent implements OnInit {
  proveedorForm = this.fb.group({
    nombre: ['', Validators.required],
    direccion: ['', Validators.required],
    telefono: ['', Validators.required]
  });

  constructor(private fb: FormBuilder, private http: HttpClient,private dataService: DataService) { }

  ngOnInit(): void {
  }

  onSubmit() {
    this.http.post('http://localhost:8080/proveedores', this.proveedorForm.value)
      .subscribe(response => {
        console.log(response);

        this.http.get<any[]>('http://localhost:8080/proveedores/listar')
          .subscribe(proveedores => {
            this.dataService.actualizarProveedores(proveedores);
          });

      }, error => {
        console.error(error);
        // handle your error here
      });
  }
}
