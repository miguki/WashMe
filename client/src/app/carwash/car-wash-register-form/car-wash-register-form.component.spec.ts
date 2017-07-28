import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CarWashRegisterFormComponent } from './car-wash-register-form.component';

describe('CarWashRegisterFormComponent', () => {
  let component: CarWashRegisterFormComponent;
  let fixture: ComponentFixture<CarWashRegisterFormComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CarWashRegisterFormComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CarWashRegisterFormComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should be created', () => {
    expect(component).toBeTruthy();
  });
});
