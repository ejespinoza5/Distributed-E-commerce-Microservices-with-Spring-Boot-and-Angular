import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent {
  title = 'ProyectoDistribuidas';
  showFormularioCategoria = false;
  showFormularioProveedor = false;
  showTablaProducto = false;
  showFormularioProducto = false;


  toggleFormularioCategoria(): void {
    this.showFormularioCategoria = !this.showFormularioCategoria;
  }

  toggleFormularioProveedor(): void {
    this.showFormularioProveedor = !this.showFormularioProveedor;
  }

  toggleTablaProducto(): void {
    this.showTablaProducto = !this.showTablaProducto;
  }

  toggleFormularioProducto(): void {
    this.showFormularioProducto = !this.showFormularioProducto;
  }

}
