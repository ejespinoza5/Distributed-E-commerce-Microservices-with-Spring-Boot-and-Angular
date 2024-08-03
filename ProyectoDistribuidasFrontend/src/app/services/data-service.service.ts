import { Injectable } from '@angular/core';
import {BehaviorSubject, Observable} from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class DataService {
  private categoriasSource = new BehaviorSubject<any[]>([]);
  categoriasActualizadas$ = this.categoriasSource.asObservable();

  private proveedoresSource = new BehaviorSubject<any[]>([]);
  proveedoresActualizados$ = this.proveedoresSource.asObservable();


  actualizarCategorias(categorias: any[]) {
    this.categoriasSource.next(categorias);
  }

  actualizarProveedores(proveedores: any[]) {
    this.proveedoresSource.next(proveedores);
  }

//modal editar
  private dataSubject = new BehaviorSubject<any>(null);
  data$ = this.dataSubject.asObservable();
  changeData(data: any) {
    this.dataSubject.next(data);
  }
  closeModal() {
    this.dataSubject.next(null);
  }




}
