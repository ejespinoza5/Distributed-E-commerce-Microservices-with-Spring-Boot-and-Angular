import { Component, OnInit } from '@angular/core';
import { FormBuilder, Validators } from '@angular/forms';
import { HttpClient } from "@angular/common/http";
import { DataService } from "../../services/data-service.service";

@Component({
  selector: 'app-formulario-categoria',
  templateUrl: './formulario-categoria.component.html',
  styleUrls: ['./formulario-categoria.component.css']
})
export class FormularioCategoriaComponent implements OnInit {
  categoriaForm = this.fb.group({
    nombre: ['', Validators.required]
  });

  constructor(private fb: FormBuilder, private http: HttpClient, private dataService: DataService) { }

  ngOnInit(): void {
  }

  onSubmit() {
    this.http.post('http://localhost:8080/categorias', this.categoriaForm.value)
      .subscribe(response => {
        console.log(response);

        this.http.get<any[]>('http://localhost:8080/categorias/listar')
          .subscribe(categorias => {
            this.dataService.actualizarCategorias(categorias);
          });
      }, error => {
        console.error(error);

      });
  }
}
