import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ServiceTypeAddFormComponent } from './service-type-add-form.component';

describe('ServiceTypeAddFormComponent', () => {
  let component: ServiceTypeAddFormComponent;
  let fixture: ComponentFixture<ServiceTypeAddFormComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ServiceTypeAddFormComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ServiceTypeAddFormComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should be created', () => {
    expect(component).toBeTruthy();
  });
});
