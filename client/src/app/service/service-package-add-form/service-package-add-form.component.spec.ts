import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ServicePackageAddFormComponent } from './service-package-add-form.component';

describe('ServicePackageAddFormComponent', () => {
  let component: ServicePackageAddFormComponent;
  let fixture: ComponentFixture<ServicePackageAddFormComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ServicePackageAddFormComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ServicePackageAddFormComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should be created', () => {
    expect(component).toBeTruthy();
  });
});
