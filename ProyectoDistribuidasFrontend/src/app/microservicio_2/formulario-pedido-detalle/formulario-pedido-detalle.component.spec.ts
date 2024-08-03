import { ComponentFixture, TestBed } from '@angular/core/testing';

import { FormularioPedidoDetalleComponent } from './formulario-pedido-detalle.component';

describe('FormularioPedidoDetalleComponent', () => {
  let component: FormularioPedidoDetalleComponent;
  let fixture: ComponentFixture<FormularioPedidoDetalleComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [FormularioPedidoDetalleComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(FormularioPedidoDetalleComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
